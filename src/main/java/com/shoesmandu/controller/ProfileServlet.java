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
 * ProfileServlet handles user profile page access.
 *
 * This controller is responsible for:
 * 1. Checking user login session
 * 2. Restricting access for unauthenticated users
 * 3. Redirecting admin users to dashboard
 * 4. Displaying profile page for normal users
 *
 * URL: /profile
 */
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Handles HTTP GET request for user profile page.
     *
     * @param req  contains session data and request information
     * @param resp sends response or redirects user
     *
     * @throws ServletException if servlet processing fails
     * @throws IOException if input/output error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // GET USER FROM SESSION
        UserModel user = (UserModel) SessionUtil.getAttribute(req, "user");

        // REDIRECT IF NOT LOGGED IN
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // REDIRECT ADMIN USERS TO DASHBOARD
        if ("admin".equalsIgnoreCase(user.getRole())) {
            resp.sendRedirect(req.getContextPath() + "/dashboard");
            return;
        }

        // PASS USER DATA TO JSP PAGE
        req.setAttribute("user", user);

        // FORWARD TO PROFILE VIEW PAGE
        req.getRequestDispatcher("/WEB-INF/pages/profile.jsp")
           .forward(req, resp);
    }
}