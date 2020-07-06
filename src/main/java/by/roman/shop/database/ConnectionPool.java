package by.roman.shop.database;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * Class for contain connections
 */
public class ConnectionPool {
    private final static Logger LOGGER = LogManager.getLogger();
    private static Lock locker = new ReentrantLock();
    private static AtomicBoolean isCreated = new AtomicBoolean(false);
    private static ConnectionPool instance;
    private ArrayBlockingQueue<ProxyConnection> availableConns;
    private ArrayBlockingQueue<ProxyConnection> usedConns;
    private ConnectionPoolConfig config;

    /**
     * Default constructor.
     */
    private ConnectionPool() {
        config = new ConnectionPoolConfig();
        availableConns = new ArrayBlockingQueue<>(config.getPoolCapacity());
        usedConns = new ArrayBlockingQueue<>(config.getPoolCapacity());
    }

    /**
     * Get instance.
     *
     * @return connection pool instance
     */
    public static ConnectionPool getInstance() {
        if (!isCreated.get()) {
            locker.lock();
            if (instance == null) {
                instance = new ConnectionPool();
                isCreated.set(true);
                LOGGER.log(Level.INFO, "Connection pool successfully created");
            }
            locker.unlock();
        }
        return instance;
    }

    private ProxyConnection createConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(config.getUrl(), config.getProperties());
        LOGGER.log(Level.INFO, "New connection created");
        return new ProxyConnection(connection);
    }

    /**
     * Retrieve connection.
     *
     * @return proxy connection
     * @throws ConnectionPoolException when sql error
     */
    public Connection retrieveConnection() throws ConnectionPoolException {
        ProxyConnection newConn;
        try {
            boolean exceedCapacity = availableConns.size() + usedConns.size() < config.getPoolCapacity();
            newConn = exceedCapacity && availableConns.isEmpty() ? createConnection() : availableConns.take();

        } catch (SQLException | InterruptedException e) {
            throw new ConnectionPoolException("Connect to data base error. ", e);
        }

        if (!usedConns.offer(newConn))
            throw new ConnectionPoolException("usedConns.offer(newConn) Error");

        return newConn;
    }

    /**
     * Put back connection.
     *
     * @param connection connection
     */
    public void pushbackConnection(ProxyConnection connection) {
        if (usedConns.remove(connection)) {
            availableConns.offer(connection);
        }
    }

    /**
     * Destroy pool.
     *
     * @throws ConnectionPoolException when sql error
     */
    public void destroyPool() throws ConnectionPoolException {
        closeConnections(availableConns);
        availableConns = new ArrayBlockingQueue<>(config.getPoolCapacity());

        closeConnections(usedConns);
        usedConns = new ArrayBlockingQueue<>(config.getPoolCapacity());
    }

    private void closeConnections(Queue<ProxyConnection> connections) {
        for (ProxyConnection availableConn : connections) {
            try {
                if (!availableConn.isClosed()) {
                    availableConn.realClose();
                }
            } catch (SQLException e) {
                LOGGER.log(Level.ERROR, "Destroy pool error.", e);
            }
        }
    }
}
