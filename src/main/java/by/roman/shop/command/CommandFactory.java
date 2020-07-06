package by.roman.shop.command;

import by.roman.shop.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private Map<String, Command> commands = new HashMap<String, Command>() {{
        put("CREATE_USER", new CreateUserCommand());
        put("OPEN_MAIN", new OpenMainCommand());
        put("OPEN_PRODUCTS", new OpenProductsCommand());
        put("OPEN_CART", new OpenCartCommand());
        put("OPEN_LOGIN", new OpenLoginCommand());
    }};

    public Command getCommand(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Command name can not be null");
        }

        Command command = commands.get(name.toUpperCase());

        if (command == null) {
            throw new IllegalArgumentException("Unsupported command name: " + name);
        }

        return command;
    }
}
