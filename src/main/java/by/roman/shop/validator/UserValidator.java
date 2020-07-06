package by.roman.shop.validator;

import by.roman.shop.entitiy.User;



public interface UserValidator {
    /**
     * Check password.
     *
     * @param password
     * @return
     */
    boolean checkPassword(String password);

    /**
     * Check email.
     *
     * @param email
     * @return
     */
    boolean checkEmail(String email);

    /**
     * Check name.
     *
     * @param name
     * @return
     */
    boolean checkName(String name);

    /**
     * Is admin.
     *
     * @param user
     * @return
     */
    boolean isAdmin(User user);

    /**
     * Is user.
     *
     * @param user
     * @return
     */
    boolean isUser(User user);

}