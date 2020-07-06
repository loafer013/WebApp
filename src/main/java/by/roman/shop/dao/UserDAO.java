package by.roman.shop.dao;

import by.roman.shop.database.ConnectionPoolException;
import by.roman.shop.entitiy.User;

import java.sql.Connection;

public abstract class UserDAO extends DAO<User> {

    public UserDAO() throws ConnectionPoolException {
        super();
    }

    public UserDAO(Connection c) {
        super(c);
    }

    /**
     * Find users count
     *
     * @return users count
     * @throws DAOException when sql request error
     */
    public abstract int findUsersCount() throws DAOException;

    /**
     * Find user by email and password
     *
     * @param user user
     * @return user
     * @throws DAOException when sql request error
     */
    public abstract User findUser(User user) throws DAOException;

    /**
     * Update user role
     *
     * @param entity user
     * @return update success
     * @throws DAOException when sql request error
     */
    public abstract boolean updateRole(User entity) throws DAOException;

    /**
     * Update user role
     *
     * @param entity user
     * @return update success
     * @throws DAOException when sql request error
     */
    public abstract boolean updateAvatarPath(User entity) throws DAOException;

    /**
     * Update user password
     *
     * @param entity user
     * @return update success
     * @throws DAOException when sql request error
     */
    public abstract boolean updatePassword(User entity) throws DAOException;
}
