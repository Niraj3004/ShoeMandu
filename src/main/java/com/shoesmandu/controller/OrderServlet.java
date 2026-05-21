package com.shoesmandu.controller;

import java.io.IOException;
import java.util.List;

import com.shoesmandu.model.OrderModel;
import com.shoesmandu.model.UserModel;
import com.shoesmandu.service.OrderService;
import com.shoesmandu.util.SessionUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * OrderServlet handles displaying user orders.
 *
 * Responsibilities:
 * 1. Handles HTTP GET request for orders page
 * 2. Checks user authentication
 * 3. Fetches orders for logged-in user
 * 4. Forwards data to orders JSP page
 */
@WebServlet("/orders")
public class OrderServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private OrderService orderService = new OrderService();

    /**
     * Handles HTTP GET request to load user orders page
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Get logged-in user from session
        UserModel user = (UserModel) SessionUtil.getAttribute(req, "user");

        // Redirect to login if user is not authenticated
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // Fetch orders for the logged-in user
        List<OrderModel> orders = orderService.getOrdersByUser(user.getUserID());

        // Set orders to request scope for JSP
        req.setAttribute("orders", orders);

        // Forward to orders page
        req.getRequestDispatcher("/WEB-INF/pages/orders.jsp")
                .forward(req, resp);
    }
}