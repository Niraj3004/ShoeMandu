package com.shoesmandu.controller;

import java.io.IOException;
import com.shoesmandu.dao.AdminuserDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/user-status")
public class UserStatusController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private AdminuserDAO dao = new AdminuserDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        int userId = Integer.parseInt(req.getParameter("userId"));
        String action = req.getParameter("action");

        if ("approve".equals(action)) {

            dao.updateUserStatus(userId, "active");

        } else if ("reject".equals(action)) {

            dao.updateUserStatus(userId, "inactive");

        } else if ("delete".equals(action)) {

            dao.updateUserStatus(userId, "deleted"); 
        }

        resp.sendRedirect(req.getContextPath() + "/dashboard");
    }
}