package com.shoesmandu.controller;

import java.io.IOException;

import com.shoesmandu.model.UserModel;
import com.shoesmandu.util.SessionUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin-profile")
public class AdminprofileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        UserModel admin = (UserModel) SessionUtil.getAttribute(req, "user");

        // not logged in
        if (admin == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // not admin
        if (!"admin".equalsIgnoreCase(admin.getRole())) {
            resp.sendRedirect(req.getContextPath() + "/home");
            return;
        }

        req.setAttribute("admin", admin);
        req.getRequestDispatcher("/WEB-INF/pages/adminprofile.jsp")
           .forward(req, resp);
    }
}