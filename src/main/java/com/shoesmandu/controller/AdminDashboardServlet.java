package com.shoesmandu.controller;

import java.io.IOException;

import com.shoesmandu.dao.AdminuserDAO;
import com.shoesmandu.service.ProductService;
import com.shoesmandu.service.OrderService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dashboard")
public class AdminDashboardServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private AdminuserDAO userDAO = new AdminuserDAO();
	private ProductService productService = new ProductService();
	private OrderService orderService = new OrderService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			// USERS
			req.setAttribute("users", userDAO.getAllUsers());

			// PRODUCTS
			req.setAttribute("products", productService.getAllProducts());

			// ORDERS (ADMIN VIEW)
			req.setAttribute("orders", orderService.getAllOrders());

		} catch (Exception e) {
			e.printStackTrace();

			req.setAttribute("users", new java.util.ArrayList<>());
			req.setAttribute("products", new java.util.ArrayList<>());
			req.setAttribute("orders", new java.util.ArrayList<>());
		}

		req.getRequestDispatcher("/WEB-INF/pages/admindashboard.jsp").forward(req, resp);
	}
}