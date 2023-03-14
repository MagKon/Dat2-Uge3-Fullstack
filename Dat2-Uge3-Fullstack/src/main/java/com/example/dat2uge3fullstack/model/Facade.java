package com.example.dat2uge3fullstack.model;

import com.example.dat2uge3fullstack.entities.interfaces.IUser;

import java.util.Map;

public class Facade {

    public static Map<String, IUser> getAllUsers() {
        return UserMapper.getAllUsers();
    }

    public static void addUser(IUser user) {
        UserMapper.addUser(user);
    }

    public static void removeUser(IUser user) {
        UserMapper.removeUser(user);
    }

    public static void updateUser(IUser user) {
        UserMapper.updateUser(user);
    }

    public static IUser containsUser(String name) {
        return UserMapper.getUser(name);
    }
}
