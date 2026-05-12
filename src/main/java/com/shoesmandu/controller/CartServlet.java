package com.shoesmandu.controller;

import java.io.IOException;
import java.util.List;

import com.shoesmandu.model.CartModel;
import com.shoesmandu.model.UserModel;
import com.shoesmandu.service.CartService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CartService cartService = new CartService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		UserModel user = (UserModel) session.getAttribute("user");

		if (user == null) {

			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		List<CartModel> cartItems = cartService.getCartItems(user.getUserID());

		req.setAttribute("cartItems", cartItems);

		req.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(req, resp);
	}
}