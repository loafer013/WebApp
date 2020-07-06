package by.roman.shop.dao.impl;

import by.roman.shop.dao.DAOException;
import by.roman.shop.dao.UserDAO;
import by.roman.shop.database.ConnectionPoolException;
import by.roman.shop.entitiy.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl extends UserDAO {
    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String PASSWORD = "password";
    public static final String ROLE = "role";
    public static final String EMAIL = "email";
    private static final String FIND_ALL_USER = "SELECT user_id, user_name, password, role, email FROM user";

    public UserDAOImpl() throws ConnectionPoolException {
        super();
    }

    public UserDAOImpl(Connection c) {
        super(c);
    }



    @Override
    public List<User> findAll() throws DAOException {

        List<User> users = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(FIND_ALL_USER)) {
            ResultSet result = statement.executeQuery();
            users = extractProducts(result);

        } catch (SQLException e) {
            throw new DAOException("Find all product error ", e);
        }
        return null;
    }

    private List<User> extractProducts(ResultSet result) throws SQLException {
        List<User> products = new ArrayList<>();
        while (result.next()) {
            products.add(extractUser(result));
        }
        return products;
    }

    private User extractUser(ResultSet result) throws SQLException {
        int userId = result.getInt(USER_ID);
        String userName = result.getString(USER_NAME);
        String password = result.getString(PASSWORD);
        String role = result.getString(ROLE);
        String email = result.getString(EMAIL);
        return new User(userId, userName, password, role, email);
    }
    @Override
    public int findUsersCount() throws DAOException {
        return 0;
    }

    @Override
    public User findUser(User user) throws DAOException {
        return null;
    }

    @Override
    public boolean updateRole(User entity) throws DAOException {
        return false;
    }

    @Override
    public boolean updateAvatarPath(User entity) throws DAOException {
        return false;
    }

    @Override
    public boolean updatePassword(User entity) throws DAOException {
        return false;
    }
    @Override
    public User findEntity(int id) throws DAOException {
        return null;
    }

    @Override
    public User findEntity(User entity) throws DAOException {
        return null;
    }

    @Override
    public boolean delete(int id) throws DAOException {
        return false;
    }

    @Override
    public boolean delete(User entity) throws DAOException {
        return false;
    }

    @Override
    public boolean create(User entity) throws DAOException {
        return false;
    }

    @Override
    public boolean update(User entity) throws DAOException {
        return false;
    }

}

