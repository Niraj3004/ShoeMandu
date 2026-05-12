package com.shoesmandu.controller;

import java.io.IOException;

import com.shoesmandu.model.UserModel;
import com.shoesmandu.model.WishlistModel;
import com.shoesmandu.service.WishlistService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add-to-wishlist")
public class AddWishlistServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;

    private WishlistService wishlistService = new WishlistService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        UserModel user = (UserModel) req.getSession().getAttribute("user");

        if (user == null) {
            req.getSession().setAttribute("error", "Please login first to add wishlist");
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        int productId = Integer.parseInt(req.getParameter("productId"));

        WishlistModel w = new WishlistModel();
        w.setUserId(user.getUserID());
        w.setProductId(productId);

        wishlistService.addToWishlist(w);

        req.getSession().setAttribute("success", "Added to wishlist");

        resp.sendRedirect(req.getContextPath() + "/product");
    }
}