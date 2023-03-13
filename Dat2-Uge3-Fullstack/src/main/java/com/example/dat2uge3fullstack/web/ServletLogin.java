package com.example.dat2uge3fullstack.web;

import com.example.dat2uge3fullstack.config.ApplicationStart;
import com.example.dat2uge3fullstack.entities.interfaces.IUser;

import java.io.*;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, IUser> map = ApplicationStart.getUsersMap();
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        if (map.containsKey(username)) {
            IUser user = map.get(username);
            if (user.getPassword().equals(password)) {
                request.getSession().setAttribute("user", user);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Username or password is incorrect");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "Username or password is incorrect");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}