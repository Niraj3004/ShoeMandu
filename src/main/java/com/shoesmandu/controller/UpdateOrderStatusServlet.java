package com.shoesmandu.controller;

import java.io.IOException;

import com.shoesmandu.service.OrderService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * UpdateOrderStatusServlet handles updating the status of an order in the admin panel.
 *
 * This servlet is responsible for:
 * - Receiving orderId and new status from request
 * - Updating order status using service layer
 * - Setting success/error message in session
 * - Redirecting admin back to order management page
 */
@WebServlet("/admin/update-order-status")
public class UpdateOrderStatusServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Service layer object for order-related operations
    private OrderService orderService = new OrderService();

    /**
     * Handles POST request to update order status.
     *
     * @param req  contains orderId and status parameters
     * @param resp redirects back to admin orders page
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        // Get order ID from request
        int orderId = Integer.parseInt(req.getParameter("orderId"));

        // Get new status from request
        String status = req.getParameter("status");

        // Update order status in database
        boolean updated = orderService.updateOrderStatus(orderId, status);

        // Set feedback message in session based on update result
        if (updated) {
            req.getSession().setAttribute("success", "Order status updated successfully");
        } else {
            req.getSession().setAttribute("error", "Failed to update order status");
        }

        // Redirect back to admin orders page
        resp.sendRedirect(req.getContextPath() + "/admin/orders");
    }
}