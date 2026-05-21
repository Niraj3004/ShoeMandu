package com.shoesmandu.controller;

import java.io.IOException;

import com.shoesmandu.service.WishlistService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * DeleteWishlistServlet handles removal of products from user wishlist.
 *
 * Responsibilities:
 * 1. Handles HTTP GET request to remove wishlist item
 * 2. Retrieves product ID from request parameter
 * 3. Calls WishlistService to delete item from database
 * 4. Redirects user back to wishlist page
 */

@WebServlet("/remove-wishlist")
public class DeleteWishlistServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private WishlistService service = new WishlistService();
    

    /**
     * Handles HTTP GET request to remove a product from wishlist
     */

    public DeleteWishlistServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        try {
        	
            // Get product ID from request parameter

            int productId = Integer.parseInt(req.getParameter("id"));
            
            // Remove product from wishlist
            
            service.removeFromWishlist(productId);

            resp.sendRedirect(req.getContextPath() + "/wishlist");

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/wishlist");
        }
    }
}