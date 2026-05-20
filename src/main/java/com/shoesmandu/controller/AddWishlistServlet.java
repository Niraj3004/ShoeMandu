package com.shoesmandu.controller;

import java.io.IOException;

import com.shoesmandu.model.UserModel;
import com.shoesmandu.model.WishlistModel;
import com.shoesmandu.service.WishlistService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * AddWishlistServlet handles adding products
 * to the user's wishlist in the Shoesmandu system.
 * 
 * It performs:
 * 1. User authentication check
 * 2. Product ID retrieval from request
 * 3. Wishlist object creation
 * 4. Saving wishlist via service layer
 * 5. Redirecting user with success/error message
 */
@WebServlet("/add-to-wishlist")
public class AddWishlistServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private WishlistService wishlistService = new WishlistService();

    public AddWishlistServlet() {
        super();
    }

    /**
     * Handles POST request to add product to wishlist.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        // GET LOGGED-IN USER FROM SESSION
        UserModel user = (UserModel) req.getSession().getAttribute("user");

        // CHECK LOGIN STATUS
        if (user == null) {

            req.getSession().setAttribute("error", "Please login first");
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // CLEAR OLD MESSAGES
        req.getSession().removeAttribute("error");
        req.getSession().removeAttribute("success");

        try {

            // GET PRODUCT ID
            int productId = Integer.parseInt(req.getParameter("productId"));

            // CREATE WISHLIST OBJECT
            WishlistModel wishlist = new WishlistModel();
            wishlist.setUserId(user.getUserID());
            wishlist.setProductId(productId);

            // ADD TO DATABASE
            boolean added = wishlistService.addToWishlist(wishlist);

            if (added) {
                req.getSession().setAttribute("success", "Added to wishlist");
            } else {
                req.getSession().setAttribute("error", "Failed to add wishlist");
            }

            resp.sendRedirect(req.getContextPath() + "/wishlist");

        } catch (Exception e) {

            e.printStackTrace();
            req.getSession().setAttribute("error", "Something went wrong");

            resp.sendRedirect(req.getContextPath() + "/wishlist");
        }
    }
}