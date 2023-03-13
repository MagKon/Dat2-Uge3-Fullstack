package com.example.dat2uge3fullstack.model;

import com.example.dat2uge3fullstack.entities.interfaces.IUser;

import java.util.Map;

public class Facade {

    public static Map<String, IUser> getAllUsers() {
        return UserMapper.getAllUsers();
    }
}
