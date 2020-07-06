package by.roman.shop.receiver.impl;


import by.roman.shop.content.RequestContent;
import by.roman.shop.receiver.ReceiverException;
import by.roman.shop.receiver.UserReceiver;

import javax.sound.midi.MidiMessage;


public class UserReceiverImpl implements UserReceiver {

    @Override
    public void signUp(RequestContent content) throws ReceiverException {
//        UserValidatorImpl validator = new UserValidatorImpl();
//        CommonValidatorImpl commonValidator = new CommonValidatorImpl();
//        String[] name = content.getRequestParameters().get(USER_NAME);
//        String[] email = content.getRequestParameters().get(EMAIL);
//        String[] password = content.getRequestParameters().get(PASSWORD);
//        String dbPassword;
//        boolean isValidData = true;
//
//        content.getRequestAttributes().put(USER_NAME, name[0]);
//        content.getRequestAttributes().put(EMAIL, email[0]);
//        content.getRequestAttributes().put(PASSWORD, password[0]);
//
//
//        if (!commonValidator.isVarExist(password) || !validator.checkPassword(password[0])) {
//            content.getRequestAttributes().put(PASSWORD, true);
//            return;
//
//
//        }
//        if (!commonValidator.isVarExist(email) || !validator.checkEmail(email[0])) {
//            content.getRequestAttributes().put(EMAIL, true);
//            isValidData = false;
//
//        }
//        if (!commonValidator.isVarExist(name) || !validator.checkName(name[0])) {
//            content.getRequestAttributes().put(USER_NAME, true);
//            isValidData = false;
//
//        }
//        if (!isValidData) {
//            return;
//        }
//
//        dbPassword = StringEncoder.encode(password[0]);
//
//        User user = new User();
//        user.setName(name[0]);
//        user.setEmail(email[0]);
//        user.setPassword(dbPassword);
//
//        TransactionManager handler = new TransactionManager();
//        try {
//            UserDAOImpl userDao = new UserDAOImpl();
//            handler.beginTransaction(userDao);
//
//            if (userDao.create(user)) {
//                handler.commit();
//                content.getSessionAttributes().put(USER, userDao.findUser(user));
//            } else {
//                content.getRequestAttributes().put(EMAIL_EXISTS, true);
//            }
//            handler.commit();
//            handler.endTransaction();
//
//        } catch (DAOException e) {
//            try {
//                handler.rollback();
//                handler.endTransaction();
//            } catch (DAOException e1) {
//                throw new ReceiverException("Sign up rollback error", e);
//            }
//            throw new ReceiverException(e);
//        }

    }

    @Override
    public void signIn(RequestContent content) throws ReceiverException {
//        String[] email = content.getRequestParameters().get(EMAIL);
//        String[] password = content.getRequestParameters().get(PASSWORD);
//        String dbPassword;
//
//        CommonValidatorImpl commonValidator = new CommonValidatorImpl();
//        UserValidatorImpl validator = new UserValidatorImpl();
//        content.getRequestAttributes().put(EMAIL, email);
//        content.getRequestAttributes().put(PASSWORD, password);
//
//        if (!commonValidator.isVarExist(password) || !commonValidator.isVarExist(email) ||
//                !validator.checkPassword(password[0]) || !validator.checkEmail(email[0])) {
//            content.getRequestAttributes().put(WRONG_DATA, true);
//            return;
//        }
//
//        dbPassword = StringEncoder.encode(password[0]);
//        User user = new User();
//        user.setEmail(email[0]);
//        user.setPassword(dbPassword);
//
//        TransactionManager handler = new TransactionManager();
//        try {
//            UserDAOImpl userDao = new UserDAO();
//            handler.beginTransaction(userDao);
//            UserEntity foundUser = userDao.findUser(user);
//
//            handler.commit();
//            handler.endTransaction();
//
//            if (foundUser != null) {
//                if (foundUser.getIsBlocked()) {
//                    content.getSessionAttributes().put(TEXT, foundUser.getBlockedText());
//                    content.getRequestAttributes().put(IS_BLOCKED, true);
//
//                } else {
//                    content.getSessionAttributes().put(USER, foundUser);
//                }
//            } else {
//                content.getRequestAttributes().put(WRONG_DATA, true);
//            }
//
//        } catch (DAOException e) {
//            try {
//                handler.rollback();
//                handler.endTransaction();
//            } catch (DAOException e1) {
//                throw new ReceiverException("Sign in rollback error", e);
//            }
//            throw new ReceiverException(e);
//        }

    }

    @Override
    public void signOut(RequestContent content) {
       // content.getSessionAttributes().remove(RequestNameConstant.USER);
    }

    @Override
    public void openProfile(RequestContent content) throws ReceiverException {

    }

    @Override
    public void changeRole(RequestContent content) throws ReceiverException {

    }

    @Override
    public void send(MidiMessage message, long timeStamp) {

    }

    @Override
    public void close() {

    }
}
