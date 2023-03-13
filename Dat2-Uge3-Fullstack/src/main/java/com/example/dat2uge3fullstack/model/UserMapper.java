package com.example.dat2uge3fullstack.model;

import com.example.dat2uge3fullstack.config.ApplicationStart;
import com.example.dat2uge3fullstack.entities.interfaces.IUser;

import java.util.Map;

public class UserMapper {

    protected static Map<String, IUser> getAllUsers() {
        return ApplicationStart.getUsersMap();
    }
}
