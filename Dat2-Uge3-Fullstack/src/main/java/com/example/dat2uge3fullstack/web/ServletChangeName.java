package com.example.dat2uge3fullstack.web;

import com.example.dat2uge3fullstack.entities.interfaces.IUser;
import com.example.dat2uge3fullstack.model.Facade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletChangeName", value = "/ServletChangeName")
public class ServletChangeName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newname = request.getParameter("newname");

        if (newname == null || newname.equals(" ")) {
            request.setAttribute("message", "Please enter a valid name");
        }

        if (request.getAttribute("message") == null) {
            IUser user = (IUser) request.getSession().getAttribute("user");
            user.setName(newname);
            request.getSession().setAttribute("user", user);
            Facade.updateUser(user);
            request.getRequestDispatcher("UserPage.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("UserPage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
