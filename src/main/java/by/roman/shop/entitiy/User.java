package by.roman.shop.entitiy;

import lombok.Data;

@Data
public class User extends Entity {
    private int id;
    private String name;
    private String password;
    private String role;
    private String email;


    public User(int userId, String userName, String password, String role, String email) {
        this.id = userId;
        this.name = userName;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public User() {
    }

    enum UserRole {
        ADMIN, USER
    }
}

