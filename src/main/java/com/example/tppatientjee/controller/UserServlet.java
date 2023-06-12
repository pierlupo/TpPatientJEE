package com.example.tppatientjee.controller;

import com.example.tppatientjee.service.LoginImpl;
import com.example.tppatientjee.service.LoginService;
import com.example.tppatientjee.util.Definition;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
//user?action=login
@WebServlet(name="user", value="/user")
public class UserServlet extends HttpServlet {
    private LoginService loginService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("action") != null && request.getParameter("action").equals("login")) {
            request.getRequestDispatcher(Definition.VIEW_PATH + "/login.jsp").forward(request, response);
        }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        loginService = new LoginImpl(request.getSession());
        if (request.getParameter("action") != null && request.getParameter("action").equals("login") && !request.getParameter("login").equals("") && !request.getParameter("password").equals("")) {
            if (loginService.login(request.getParameter("login"), request.getParameter("password"))) {
                response.sendRedirect(Definition.BASE_URL);
            } else {
                request.setAttribute("messageError", "Erreur de login");
                request.getRequestDispatcher(Definition.VIEW_PATH + "/login.jsp").forward(request, response);
            }

        }
    }
}