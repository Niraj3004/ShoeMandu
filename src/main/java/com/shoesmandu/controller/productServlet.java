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

@WebServlet("/product")
public class productServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ProductService productService = new ProductService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// GET PARAMETERS

		String category = request.getParameter("category");
		String brand = request.getParameter("brand");
		String minPriceStr = request.getParameter("minPrice");
		String maxPriceStr = request.getParameter("maxPrice");
		String keyword = request.getParameter("keyword");

		// GET ALL PRODUCTS FIRST

		List<ProductModel> products = productService.getAllProducts();

		// SEARCH FILTER

		if (keyword != null && !keyword.trim().isEmpty()) {

			String search = keyword.toLowerCase();

			products = products.stream()
					.filter(p -> p.getProductName() != null && p.getProductName().toLowerCase().contains(search))
					.toList();
		}

		// CATEGORY FILTER

		if (category != null && !category.trim().isEmpty()) {

			products = products.stream()
					.filter(p -> p.getCategory() != null && p.getCategory().equalsIgnoreCase(category)).toList();
		}

		
		// BRAND FILTER
		
		if (brand != null && !brand.trim().isEmpty()) {

			products = products.stream().filter(p -> p.getBrand() != null && p.getBrand().equalsIgnoreCase(brand))
					.toList();
		}

	
		// PRICE FILTER
		
		double minPrice = 0;
		double maxPrice = Double.MAX_VALUE;

		if (minPriceStr != null && !minPriceStr.isEmpty()) {
			try {
				minPrice = Double.parseDouble(minPriceStr);
			} catch (Exception e) {
				minPrice = 0;
			}
		}

		if (maxPriceStr != null && !maxPriceStr.isEmpty()) {
			try {
				maxPrice = Double.parseDouble(maxPriceStr);
			} catch (Exception e) {
				maxPrice = Double.MAX_VALUE;
			}
		}

		double finalMinPrice = minPrice;
		double finalMaxPrice = maxPrice;

		products = products.stream().filter(p -> p.getPrice() >= finalMinPrice && p.getPrice() <= finalMaxPrice)
				.toList();

	
		// SEND TO JSP
	
		request.setAttribute("products", products);
		request.setAttribute("keyword", keyword);

		request.getRequestDispatcher("/WEB-INF/pages/product.jsp").forward(request, response);
	}
}