package com.shoesmandu.controller;

import java.io.IOException;

import com.shoesmandu.model.UserModel;
import com.shoesmandu.util.SessionUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Get user from session using utility
        UserModel user = (UserModel) SessionUtil.getAttribute(req, "user");

        // If not logged in  redirect login
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // If admin  redirect dashboard
        if ("admin".equalsIgnoreCase(user.getRole())) {
            resp.sendRedirect(req.getContextPath() + "/dashboard");
            return;
        }

        // Pass user to JSP
        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(req, resp);
    }
}