package com.shoesmandu.controller;

import java.io.IOException;

import com.shoesmandu.dao.AdminuserDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * UserStatusController handles user account status management in admin panel.
 *
 * This servlet is responsible for:
 * - Approving users (set status to active)
 * - Rejecting users (set status to inactive)
 * - Deleting users (set status to deleted)
 * - Redirecting back to admin dashboard after action
 */
@WebServlet("/admin/user-status")
public class UserStatusController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // DAO object for updating user status in database
    private AdminuserDAO dao = new AdminuserDAO();

    /**
     * Handles POST request for user status actions.
     *
     * @param req  contains userId and action (approve/reject/delete)
     * @param resp redirects back to dashboard after processing
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        // Get user ID from request
        int userId = Integer.parseInt(req.getParameter("userId"));

        // Get action type from request
        String action = req.getParameter("action");

        // Perform action based on admin request
        if ("approve".equals(action)) {

            // Activate user account
            dao.updateUserStatus(userId, "active");

        } else if ("reject".equals(action)) {

            // Deactivate user account
            dao.updateUserStatus(userId, "inactive");

        } else if ("delete".equals(action)) {

            // Mark user as deleted
            dao.updateUserStatus(userId, "deleted");
        }

        // Redirect back to admin dashboard
        resp.sendRedirect(req.getContextPath() + "/dashboard");
    }
}