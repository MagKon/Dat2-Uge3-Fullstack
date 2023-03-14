package com.example.dat2uge3fullstack.model;

import com.example.dat2uge3fullstack.config.ApplicationStart;
import com.example.dat2uge3fullstack.entities.interfaces.IUser;

import java.util.HashMap;
import java.util.Map;

public class UserMapper {
    Map<String, IUser> usersMap = new HashMap<>();
    protected static Map<String, IUser> getAllUsers() {
        return ApplicationStart.getUsersMap();
    }

    protected static void addUser(IUser user) {
        ApplicationStart.getUsersMap().put(user.getName(), user);
    }

    protected static void removeUser(IUser user) {
        ApplicationStart.getUsersMap().remove(user.getName());
    }

    protected static void removeUser(String name) {
        ApplicationStart.getUsersMap().remove(name);
    }

    protected static void updateUser(IUser user) {
        ApplicationStart.getUsersMap().put(user.getName(), user);
    }

    protected static IUser getUser(String name) {
        return ApplicationStart.getUsersMap().get(name);
    }

    protected static boolean containsUser(String name) {
        return ApplicationStart.getUsersMap().containsKey(name);
    }

    protected static boolean containsUser(IUser user) {
        return ApplicationStart.getUsersMap().containsKey(user.getName());
    }

    protected static boolean containsUser(String name, String password) {
        if (ApplicationStart.getUsersMap().containsKey(name)) {
            IUser user = ApplicationStart.getUsersMap().get(name);
            return user.getPassword().equals(password);
        }
        return false;
    }

    protected static boolean containsUser(IUser user, String password) {
        if (ApplicationStart.getUsersMap().containsKey(user.getName())) {
            IUser user1 = ApplicationStart.getUsersMap().get(user.getName());
            return user1.getPassword().equals(password);
        }
        return false;
    }
}
