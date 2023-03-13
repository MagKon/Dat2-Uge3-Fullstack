package com.example.dat2uge3fullstack.config;

import com.example.dat2uge3fullstack.entities.User;
import com.example.dat2uge3fullstack.entities.interfaces.IUser;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ApplicationStart implements ServletContextListener {
    private static final Map<String, IUser> usersMap = new HashMap<>();
//    private static ConnectionPool connectionPool;

    public ApplicationStart() {
    }
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Logger.getLogger("web").log(Level.INFO, "Application started");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Logger.getLogger("web").log(Level.SEVERE, "Could not load driver");
        }

        try {
            List<IUser> users = new ArrayList<>();
            IUser user1 = new User("magnus", "Password");
            IUser user2 = new User("john", "Password");
            IUser user3 = new User("peter", "Password");
            users.add(user1);
            users.add(user2);
            users.add(user3);

            for (IUser user : users) {
                usersMap.put(user.getName(), user);
            }
            sce.getServletContext().setAttribute("users", usersMap);
        }
        catch (Exception e) {
            e.printStackTrace();
            Logger.getLogger("web").log(Level.SEVERE, "Could not load users");
        }
    }

    public static Map<String, IUser> getUsersMap() {
        return usersMap;
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //TODO: Figure this out
//        Logger.getLogger("web").log(Level.INFO, "Application stopped");
//        Enumeration<Driver> drivers = DriverManager.getDrivers();
//        while (drivers.hasMoreElements()) {
//            Driver driver = drivers.nextElement();
//            try {
//                DriverManager.deregisterDriver(driver);
//            } catch (SQLException e) {
//                e.printStackTrace();
//                Logger.getLogger("web").log(Level.SEVERE, "Could not deregister driver");
//            }
//        }
    }
}
