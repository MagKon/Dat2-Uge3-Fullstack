package com.example.dat2uge3fullstack.web;

import com.example.dat2uge3fullstack.entities.interfaces.IUser;
import com.example.dat2uge3fullstack.model.Facade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletAddValue", value = "/ServletAddValue")
public class ServletAddValue extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        String value = request.getParameter("value");
        IUser user = (IUser) request.getSession().getAttribute("user");

        user.addToList(value);
        Facade.updateUser(user);

        request.getSession().setAttribute("user", user);
        request.getRequestDispatcher("UserPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
