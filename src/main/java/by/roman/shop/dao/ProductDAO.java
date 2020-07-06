package by.roman.shop.dao;

import by.roman.shop.database.ConnectionPoolException;
import by.roman.shop.entitiy.Product;

import java.sql.Connection;

public abstract class ProductDAO extends DAO<Product> {
    public ProductDAO() throws ConnectionPoolException {
        super();
    }

    public ProductDAO(Connection c) {
        super(c);
    }

}
