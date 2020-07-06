package by.roman.shop.receiver.impl;

import by.roman.shop.dao.DAOException;
import by.roman.shop.dao.ProductDAO;
import by.roman.shop.dao.impl.ProductDAOImpl;
import by.roman.shop.database.ConnectionPoolException;
import by.roman.shop.entitiy.Product;
import by.roman.shop.receiver.ProductReceiver;
import by.roman.shop.receiver.ReceiverException;

import java.util.List;

public class ProductReceiverImpl implements ProductReceiver {

    public List<Product> showAll() throws ReceiverException {
        List<Product> products;

        try (ProductDAO dao = new ProductDAOImpl()) {
            products = dao.findAll();

        } catch (DAOException | ConnectionPoolException e) {
            throw new ReceiverException(e) ;
        }
        return products;
    }
}
