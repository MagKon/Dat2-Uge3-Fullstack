package com.example.dat2uge3fullstack.web;

import com.example.dat2uge3fullstack.entities.interfaces.IUser;
import com.example.dat2uge3fullstack.model.Facade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletDeleteUser", value = "/ServletDeleteUser")
public class ServletDeleteUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUser user = (IUser) request.getSession().getAttribute("user");
        request.getSession().setAttribute("loggedIn", false);
        request.getSession().setAttribute("user", null);
        Facade.removeUser(user);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
