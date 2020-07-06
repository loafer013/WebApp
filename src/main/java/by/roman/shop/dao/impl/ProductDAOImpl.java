package by.roman.shop.dao.impl;

import by.roman.shop.dao.DAOException;
import by.roman.shop.dao.ProductDAO;
import by.roman.shop.database.ConnectionPoolException;
import by.roman.shop.entitiy.Product;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl extends ProductDAO {
    public static final String PRODUCT_ID = "product_id";
    public static final String PRODUCT_NAME = "product_name";
    public static final String PRICE = "price";
    public static final String IMAGE_PATH = "image_path";
    private static final String FIND_ALL_PRODUCT = "SELECT product_id, product_name, price, image_path FROM product";

   public ProductDAOImpl() throws ConnectionPoolException {
        super();
    }

    public ProductDAOImpl(Connection c) {
        super(c);
    }



    @Override
    public List<Product> findAll() throws DAOException {

        List<Product> products;

        try (PreparedStatement statement = connection.prepareStatement(FIND_ALL_PRODUCT)) {
            ResultSet result = statement.executeQuery();
            products = extractProducts(result);

        } catch (SQLException e) {
            throw new DAOException("Find all product error ", e);
        }
        return products;
    }

    private List<Product> extractProducts(ResultSet result) throws SQLException {
        List<Product> products = new ArrayList<>();
        while (result.next()) {
            products.add(extractProduct(result));
        }
        return products;
    }

    private Product extractProduct(ResultSet result) throws SQLException {
        int productId = result.getInt(PRODUCT_ID);
        String productName = result.getString(PRODUCT_NAME);
        String imagePath = result.getString(IMAGE_PATH);
        BigDecimal price = result.getBigDecimal(PRICE);
        return new Product(productId, productName, imagePath, price);
    }

    @Override
    public Product findEntity(int id) throws DAOException {
        return null;
    }

    @Override
    public Product findEntity(Product entity) throws DAOException {
        return null;
    }

    @Override
    public boolean delete(int id) throws DAOException {
        return false;
    }

    @Override
    public boolean delete(Product entity) throws DAOException {
        return false;
    }

    @Override
    public boolean create(Product entity) throws DAOException {
        return false;
    }

    @Override
    public boolean update(Product entity) throws DAOException {
        return false;
    }
}
