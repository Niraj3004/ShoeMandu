package com.shoesmandu.controller;

import java.io.IOException;

import com.shoesmandu.model.UserModel;
import com.shoesmandu.util.SessionUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * AdminProfileServlet handles admin profile page requests.
 *
 * Responsibilities:
 * 1. Handles HTTP GET request for admin profile page
 * 2. Checks whether user is logged in
 * 3. Verifies if user has admin role
 * 4. Forwards admin data to profile JSP page
 */
@WebServlet("/admin-profile")
public class AdminprofileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Handles HTTP GET request
     * Loads admin profile page if user is authenticated and authorized
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Get logged-in user from session
        UserModel admin = (UserModel) SessionUtil.getAttribute(req, "user");

        // If user is not logged in, redirect to login page
        if (admin == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // If logged-in user is not admin, redirect to home page
        if (!"admin".equalsIgnoreCase(admin.getRole())) {
            resp.sendRedirect(req.getContextPath() + "/home");
            return;
        }

        // Set admin data for JSP view
        req.setAttribute("admin", admin);

        // Forward request to admin profile page
        req.getRequestDispatcher("/WEB-INF/pages/adminprofile.jsp")
                .forward(req, resp);
    }
}