package com._1stDibs.app.registries;

import com._1stDibs.app.entites.User;

import java.util.HashMap;

public class UserRegistry {

    private static UserRegistry userRegistry = null;
    private final HashMap<String, User> users = new HashMap<>();

    public static synchronized UserRegistry getInstance() {
        if (userRegistry != null) {
            return userRegistry;
        } else {
            userRegistry = new UserRegistry();
            return userRegistry;
        }
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public User getUserByUsername(String username) {
        return users.get(username);
    }

}
