package com.example.dat2uge3fullstack.web;

import com.example.dat2uge3fullstack.entities.interfaces.IUser;
import com.example.dat2uge3fullstack.model.Facade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletDeleteValue", value = "/ServletDeleteValue")
public class ServletDeleteValue extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        IUser user = (IUser) request.getSession().getAttribute("user");
        int index = Integer.parseInt(request.getParameter("delValue"));
        String value = user.getList().get(index);

        user.removeFromList(value);
        Facade.updateUser(user);

        request.getSession().setAttribute("user", user);
        request.getRequestDispatcher("UserPage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
