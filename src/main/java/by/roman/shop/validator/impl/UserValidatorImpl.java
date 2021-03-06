package by.roman.shop.validator.impl;

import by.roman.shop.entitiy.User;
import by.roman.shop.validator.UserValidator;

import java.util.regex.Pattern;

public class UserValidatorImpl implements UserValidator {
    private final static String EMAIL_REGEX = "([_\\w-]+(\\.[_\\w-]+)*@[\\w-]+(\\.[\\w-]+)*(\\.[a-zA-Z]{1,6}))";
    private final static  String BIG_RU_ENG_LETTER_REGEX = "[A-ZА-Я]";
    private final static  String LITTLE_RU_ENG_LETTER_REGEX = "[a-zа-я]";
    private final static  String NUMBER_REGEX = "\\d";
    private static final int MIN_PASSWORD_LENGTH = 6;
    private static final int MAX_PASSWORD_LENGTH = 80;
    private static final int MAX_NAME_LENGTH = 45;
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_EMAIL_LENGTH = 100;



    @Override
    public boolean checkPassword(String password) {
        if (password == null) {
            return false;
        }

        boolean hasBigWord = Pattern.compile(BIG_RU_ENG_LETTER_REGEX).matcher(password).find();
        boolean hasWord = Pattern.compile(LITTLE_RU_ENG_LETTER_REGEX).matcher(password).find();
        boolean hasNumber = Pattern.compile(NUMBER_REGEX).matcher(password).find();
        boolean hasSatisfactoryLength =
                (password.length() >= MIN_PASSWORD_LENGTH && password.length() < MAX_PASSWORD_LENGTH);

        return (hasBigWord && hasWord && hasNumber && hasSatisfactoryLength);
    }

    @Override
    public boolean checkEmail(String email) {
        if (email == null) {
            return false;
        }
        email = email.trim();
        boolean isEmail = Pattern.compile(EMAIL_REGEX).matcher(email).matches();
        boolean hasSatisfactoryLength = email.length() <= MAX_EMAIL_LENGTH;

        return isEmail && hasSatisfactoryLength;
    }

    @Override
    public boolean checkName(String name) {
        if (name == null) {
            return false;
        }

        name = name.trim();
        boolean isName = name.length() >= MIN_NAME_LENGTH;
        boolean hasSatisfactoryLength = name.length() <= MAX_NAME_LENGTH;

        return isName && hasSatisfactoryLength;
    }

    @Override
    public boolean isAdmin(User user) {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean isUser(User user) {
        throw new UnsupportedOperationException();
    }


}