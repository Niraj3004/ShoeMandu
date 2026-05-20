package com.shoesmandu.controller;

import java.io.IOException;
import java.util.List;

import com.shoesmandu.model.UserModel;
import com.shoesmandu.model.WishlistModel;
import com.shoesmandu.service.WishlistService;
import com.shoesmandu.util.SessionUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * WishlistServlet handles displaying the user's wishlist page.
 *
 * This servlet is responsible for:
 * - Checking user authentication
 * - Retrieving wishlist items from service layer
 * - Forwarding wishlist data to JSP page
 */
@WebServlet("/wishlist")
public class WishlistServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Service layer object for wishlist operations
    private WishlistService wishlistService = new WishlistService();

    /**
     * Handles GET request to display wishlist page.
     *
     * @param req  used to get session user and set attributes
     * @param resp used to redirect or forward response
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

		// Retrieve wishlist items for logged-in user
		List<WishlistModel> wishlist = wishlistService.getWishlist(user.getUserID());

        // Set wishlist data for JSP view
        req.setAttribute("wishlist", wishlist);

        // Forward to wishlist page
        req.getRequestDispatcher("/WEB-INF/pages/Wishlist.jsp")
           .forward(req, resp);
    }
}