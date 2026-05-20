package com.shoesmandu.controller;

import java.io.IOException;

import com.shoesmandu.model.CartModel;
import com.shoesmandu.model.UserModel;
import com.shoesmandu.service.CartService;
import com.shoesmandu.util.SessionUtil;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * AddToCartServlet handles adding products to the user's shopping cart.
 *
 * This servlet is responsible for:
 * - Checking user authentication
 * - Retrieving product ID from request
 * - Creating cart model object
 * - Adding product to cart via service layer
 * - Handling success and error messages
 * - Redirecting user to cart page
 */
@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Service layer object for cart operations
    private CartService service = new CartService();

    public AddToCartServlet() {
        super();
    }

    /**
     * Handles POST request for adding product to cart.
     *
     * @param req  contains productId from form submission
     * @param resp used for redirecting user after operation
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        // Get logged-in user from session
        UserModel user = (UserModel) SessionUtil.getAttribute(req, "user");

        // If user is not logged in, redirect to login page
        if (user == null) {
            SessionUtil.setAttribute(req, "error", "Please login first");
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        try {

            // Get product ID from request
            int productId = Integer.parseInt(req.getParameter("productId"));

            // Create cart object
            CartModel cart = new CartModel();
            cart.setUserId(user.getUserID());
            cart.setProductId(productId);
            cart.setQuantity(1);

            // Add product to cart using service layer
            boolean added = service.addToCart(cart);

            // Set success or error message
            if (added) {
                SessionUtil.setAttribute(req, "success", "Product added to cart");
            } else {
                SessionUtil.setAttribute(req, "error", "Failed to add product to cart");
            }

            // Redirect to cart page
            resp.sendRedirect(req.getContextPath() + "/cart");

        } catch (Exception e) {

            e.printStackTrace();

            SessionUtil.setAttribute(req, "error", "Something went wrong");

            resp.sendRedirect(req.getContextPath() + "/cart");
        }
    }
}