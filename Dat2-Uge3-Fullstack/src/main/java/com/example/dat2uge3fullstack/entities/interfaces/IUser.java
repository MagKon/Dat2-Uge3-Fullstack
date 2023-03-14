package com.example.dat2uge3fullstack.entities.interfaces;

import com.example.dat2uge3fullstack.enums.Permission;

import java.util.List;

public interface IUser {
    void setId(int id);
    int getId();
    void setName(String name);
    String getName();
    void setPassword(String password);
    String getPassword();
    void setRole(Permission role);
    Permission getRole();
    void setList(List<String> strings);
    List<String> getList();
    void addToList(String string);
    void removeFromList(String string);
}
