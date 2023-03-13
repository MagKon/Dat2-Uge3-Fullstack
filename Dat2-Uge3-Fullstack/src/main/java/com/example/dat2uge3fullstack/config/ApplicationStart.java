package com.example.dat2uge3fullstack.config;

import com.example.dat2uge3fullstack.entities.User;
import com.example.dat2uge3fullstack.entities.interfaces.IUser;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ApplicationStart implements ServletContextListener {

//    private static ConnectionPool connectionPool;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Logger.getLogger("web").log(Level.INFO, "Application started");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Logger.getLogger("web").log(Level.SEVERE, "Could not load driver");
        }
        List<IUser> users = new ArrayList<>();
        IUser user1 = new User("Magnus", "Password");
        IUser user2 = new User("John", "Password");
        IUser user3 = new User("Peter", "Password");

        users.add(user1);
        users.add(user2);
        users.add(user3);

        sce.getServletContext().setAttribute("users", users);
    }
}
