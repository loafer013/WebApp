package by.roman.shop.dao;

import by.roman.shop.database.ConnectionPool;
import by.roman.shop.database.ConnectionPoolException;
import by.roman.shop.entitiy.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class DAO<T extends Entity> implements AutoCloseable {
    protected final static Logger LOGGER = LogManager.getLogger();

    protected Connection connection;

    public abstract List<T> findAll() throws DAOException;

    public abstract T findEntity(int id) throws DAOException;

    public abstract T findEntity(T entity) throws DAOException;

    public abstract boolean delete(int id) throws DAOException;

    public abstract boolean delete(T entity) throws DAOException;

    public abstract boolean create(T entity) throws DAOException;

    public abstract boolean update(T entity) throws DAOException;

    public DAO(Connection connection) {
        this.connection = connection;
    }
    public DAO() throws ConnectionPoolException {
        this.connection = ConnectionPool.getInstance().retrieveConnection();
    }

    @Override
    public void close() throws  DAOException {
        try {
            connection.close();
        } catch (SQLException e) {
           throw new DAOException(e);
        }
    }
}
