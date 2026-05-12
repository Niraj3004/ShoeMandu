package com.shoesmandu.controller;

import java.io.IOException;

import com.shoesmandu.model.CartModel;
import com.shoesmandu.model.UserModel;
import com.shoesmandu.service.CartService;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add-to-cart")
public class AddToCartServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;

    private CartService cartService = new CartService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        UserModel user = (UserModel) req.getSession().getAttribute("user");

        if (user == null) {
            req.getSession().setAttribute("error", "Please login first to add to cart");
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        int productId = Integer.parseInt(req.getParameter("productId"));

        CartModel cart = new CartModel();
        cart.setUserId(user.getUserID());
        cart.setProductId(productId);
        cart.setQuantity(1);

        cartService.addToCart(cart);

        req.getSession().setAttribute("success", "Added to cart successfully");

        resp.sendRedirect(req.getContextPath() + "/product");
    }
}