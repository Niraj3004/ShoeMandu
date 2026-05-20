package com.shoesmandu.controller;

import java.io.IOException;
import java.util.List;

import com.shoesmandu.model.OrderModel;
import com.shoesmandu.service.OrderService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * AdminOrderServlet
 *
 * This servlet is responsible for:
 * 1. Handling HTTP GET requests for admin orders page
 * 2. Checking whether admin user is logged in or not
 * 3. Fetching all orders from the database
 * 4. Forwarding order data to JSP for display
 */
@WebServlet("/admin/orders")
public class AdminOrderServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Service layer object used to communicate with order database logic
    private OrderService orderService = new OrderService();

    /**
     * doGet() is triggered when admin opens the orders page.
     *
     * This method:
     * - Validates user session
     * - Loads all orders from database
     * - Sends data to JSP page
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Get current HTTP session
        HttpSession session = req.getSession();

        // Retrieve logged-in user object from session
        Object user = session.getAttribute("user");

        // If user is not logged in, redirect to login page
        if (user == null) {

            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // Fetch all orders from service layer (database)
        List<OrderModel> orders = orderService.getAllOrders();

        // Set order list into request scope so JSP can display it
        req.setAttribute("orders", orders);

        // Forward request to admin orders JSP page
        // Forward keeps same URL but loads JSP view internally
        req.getRequestDispatcher("/WEB-INF/pages/admin-orders.jsp")
           .forward(req, resp);
    }
}