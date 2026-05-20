package com.shoesmandu.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.shoesmandu.service.CartService;

/**
 * UpdateCartServlet handles updating product quantity in the shopping cart.
 *
 * This servlet is responsible for:
 * - Receiving cartId and quantity from request
 * - Updating cart item quantity via service layer
 * - Redirecting user back to cart page
 */
@WebServlet("/UpdateCart")
public class UpdateCartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Service layer object to handle cart operations
    private CartService service = new CartService();

    /**
     * Handles POST request to update cart quantity.
     *
     * @param req  contains cartId and quantity parameters
     * @param resp redirects user after updating cart
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        // Get cart ID from request
        int cartId = Integer.parseInt(req.getParameter("cartId"));

        // Get updated quantity from request
        int qty = Integer.parseInt(req.getParameter("quantity"));

        // Update cart quantity in database
        service.updateQuantity(cartId, qty);

        // Redirect back to cart page
        resp.sendRedirect(req.getContextPath() + "/cart");
    }
}