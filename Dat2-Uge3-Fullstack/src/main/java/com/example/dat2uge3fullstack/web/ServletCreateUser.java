package com.example.dat2uge3fullstack.web;

import com.example.dat2uge3fullstack.entities.User;
import com.example.dat2uge3fullstack.entities.interfaces.IUser;
import com.example.dat2uge3fullstack.model.Facade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletCreateUser", value = "/ServletCreateUser")
public class ServletCreateUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String newname = request.getParameter("newname");
        String newpassword = request.getParameter("newpassword");

        if (newname == null || newname.equals(" ")) {
            request.setAttribute("message2", "Please enter a name");
        }

        if (newpassword == null || newpassword.contains(" ") || newpassword.length() < 5) {
            request.setAttribute("message2", "Please enter a password. Password must be at least 5 characters long and contain no spaces");
        }

        if (Facade.containsUser(newname) != null) {
            request.setAttribute("message2", "User already exists");
        }

        if (request.getAttribute("message2") == null) {
            IUser user = new User(newname, newpassword);
            Facade.addUser(user);
            request.getSession().setAttribute("loggedIn", true);
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("UserPage.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
