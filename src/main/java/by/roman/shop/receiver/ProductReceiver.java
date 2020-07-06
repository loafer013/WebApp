package by.roman.shop.receiver;

import by.roman.shop.entitiy.Product;

import java.util.List;

public interface ProductReceiver {
    public abstract List<Product> showAll() throws ReceiverException;
}
