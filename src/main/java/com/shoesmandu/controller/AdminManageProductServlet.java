package com.shoesmandu.controller;

import java.io.IOException;
import java.util.List;

import com.shoesmandu.model.ProductModel;
import com.shoesmandu.service.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin-manageproduct")
public class AdminManageProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ProductService productService = new ProductService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String keyword = req.getParameter("keyword");

		List<ProductModel> products;

		if (keyword != null && !keyword.trim().isEmpty()) {

			products = productService.searchProducts(keyword);

		} else {

			products = productService.getAllProducts();
		}

		req.setAttribute("products", products);

		req.getRequestDispatcher("/WEB-INF/pages/adminproduct.jsp").forward(req, resp);
	}
}