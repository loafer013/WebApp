package by.roman.shop.database;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import scala.Tuple2;

import java.util.*;
import java.util.stream.Collectors;


class ConnectionPoolConfig {

    private final static Logger LOGGER = LogManager.getLogger();
    private final Properties properties;
    public static final String DRIVER = "driver";
    public static final String URL = "url";
    public static final String POOL_CAPACITY = "poolCapacity";
    public static final String DB_PROPERTIES = "db_config";

    /**
     * Default constructor.
     */
        ConnectionPoolConfig() {
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle(DB_PROPERTIES, Locale.ROOT);
            Map<String, String> configMap = resourceBundle
                    .keySet()
                    .stream()
                    .map(key -> new Tuple2<>(key, resourceBundle.getString(key)))
                    .collect(Collectors.toMap(Tuple2::_1, Tuple2::_2));

            properties = new Properties();
            properties.putAll(configMap);

            Class.forName(properties.getProperty(DRIVER));

        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.FATAL, "Connection pool will nowhere create. ", e);
            throw new RuntimeException("Driver not found. ", e);

        } catch (MissingResourceException e) {
            LOGGER.log(Level.FATAL, "Connection pool will nowhere create. ", e);
            throw new RuntimeException("Data base configuration file not found. ", e);

        }
    }

    /**
     * `get URL.
     *
     * @return url
     */
    String getUrl() {
        return properties.getProperty(URL);
    }

    /**
     * Get properties.
     *
     * @return properties
     */
    Properties getProperties() {
        return properties;
    }

    /**
     * Get pool capacity.
     *
     * @return pool capacity
     */
    int getPoolCapacity() {
        return Integer.parseInt(properties.getProperty(POOL_CAPACITY));
    }

}