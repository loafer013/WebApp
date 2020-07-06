package by.roman.shop.command.impl;

import by.roman.shop.command.Command;
import by.roman.shop.content.RequestContent;
import by.roman.shop.content.ResponseContent;
import by.roman.shop.content.RouteType;
import by.roman.shop.page.JSPPage;

public class OpenCartCommand implements Command {
    @Override
    public ResponseContent execute(RequestContent e) {
        return new ResponseContent(JSPPage.CART, RouteType.FORWARD);
    }
}
