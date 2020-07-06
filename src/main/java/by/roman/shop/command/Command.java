package by.roman.shop.command;

import by.roman.shop.content.RequestContent;
import by.roman.shop.content.ResponseContent;

public interface Command {
    ResponseContent execute (RequestContent e);
}
