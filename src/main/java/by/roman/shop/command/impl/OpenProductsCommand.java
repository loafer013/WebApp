package by.roman.shop.command.impl;

import by.roman.shop.command.Command;
import by.roman.shop.content.RequestContent;
import by.roman.shop.content.ResponseContent;
import by.roman.shop.content.RouteType;
import by.roman.shop.entitiy.Product;
import by.roman.shop.page.JSPPage;
import by.roman.shop.receiver.ProductReceiver;
import by.roman.shop.receiver.ReceiverException;
import by.roman.shop.receiver.impl.ProductReceiverImpl;

import java.util.List;

public class OpenProductsCommand implements Command {
    private ProductReceiver productReceiver = new ProductReceiverImpl();
    @Override
    public ResponseContent execute(RequestContent e) {
        ResponseContent responseContent;
        try {
            List<Product> products = productReceiver.showAll();
            responseContent = new ResponseContent(JSPPage.PRODUCTS, RouteType.FORWARD);
            responseContent.getRequestParams().put("products", products );

        } catch (ReceiverException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Can not retrieve products", ex);
        }
        return responseContent;
    }
}
