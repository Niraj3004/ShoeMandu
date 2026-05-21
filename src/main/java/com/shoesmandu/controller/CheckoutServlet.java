package com.shoesmandu.controller;

import java.io.IOException;

import com.shoesmandu.model.UserModel;
import com.shoesmandu.service.OrderService;
import com.shoesmandu.util.SessionUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * CheckoutServlet handles order placement from the cart.
 *
 * Responsibilities:
 * 1. Handles HTTP POST request for checkout
 * 2. Checks user authentication
 * 3. Calls OrderService to place order
 * 4. Handles success and failure responses
 */
@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private OrderService orderService = new OrderService();

    /**
     * Handles HTTP POST request for checkout process
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Get logged-in user from session
        UserModel user = (UserModel) SessionUtil.getAttribute(req, "user");

        // Redirect to login if user is not authenticated
        if (user == null) {
            SessionUtil.setAttribute(req, "error", "Please login first");
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        try {

            // Call service layer to place order
            boolean success = orderService.placeOrder(user.getUserID());

            // Handle checkout result
            if (success) {
                SessionUtil.setAttribute(req, "success", "Order placed successfully!");
                resp.sendRedirect(req.getContextPath() + "/orders");
            } else {
                SessionUtil.setAttribute(req, "error", "Cart is empty or checkout failed");
                resp.sendRedirect(req.getContextPath() + "/cart");
            }

        } catch (Exception e) {
            e.printStackTrace();

            // Handle unexpected errors during checkout
            SessionUtil.setAttribute(req, "error", "Something went wrong during checkout");
            resp.sendRedirect(req.getContextPath() + "/cart");
        }
    }
}