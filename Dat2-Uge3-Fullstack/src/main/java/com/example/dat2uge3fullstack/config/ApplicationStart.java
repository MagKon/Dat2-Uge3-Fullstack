package com.example.dat2uge3fullstack.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
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
    }
}
