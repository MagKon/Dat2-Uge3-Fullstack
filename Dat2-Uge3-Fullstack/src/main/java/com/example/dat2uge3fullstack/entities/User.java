package com.example.dat2uge3fullstack.entities;

import com.example.dat2uge3fullstack.entities.interfaces.IUser;
import com.example.dat2uge3fullstack.enums.Permission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User implements IUser {
    private String name;
    private String password;
    private Permission role;
    List<String> strings = new ArrayList<>();

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.role = Permission.USER;
    }

    public User(String name, String password, Permission role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public User(String name, String password, Permission role, List<String> strings) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.strings = strings;
    }

    public User(String name, String password, Permission role, String... strings) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.strings.addAll(Arrays.asList(strings));
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setRole(Permission role) {
        this.role = role;
    }

    @Override
    public Permission getRole() {
        return this.role;
    }

    @Override
    public void setList(List<String> strings) {
        this.strings = strings;
    }

    @Override
    public List<String> getList() {
        return this.strings;
    }

    @Override
    public void addToList(String string) {
        this.strings.add(string);
    }

    @Override
    public void removeFromList(String string) {
        this.strings.remove(string);
    }
}
