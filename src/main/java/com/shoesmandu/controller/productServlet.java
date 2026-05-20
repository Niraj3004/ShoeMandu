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

/**
 * ProductServlet handles product listing page.
 *
 * This controller is responsible for: 1. Loading all products from database 2.
 * Filtering products by category, brand, price, keyword 3. Sorting products
 * (low/high/new) 4. Sending final product list to JSP page
 *
 * URL: /product
 */
@WebServlet("/product")
public class productServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private ProductService productService = new ProductService();

	public productServlet() {
		super();
	}

	/**
	 * Handles HTTP GET request for product listing page.
	 *
	 * @param request  contains query parameters: category → filter by product
	 *                 category brand → filter by brand name minPrice → minimum
	 *                 price filter maxPrice → maximum price filter keyword → search
	 *                 keyword for product name sort → sorting option (low, high,
	 *                 new)
	 *
	 * @param response sends response back to browser
	 *
	 * @throws ServletException if servlet processing fails
	 * @throws IOException      if input/output error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// GET QUERY PARAMETERS FROM URL
		String category = request.getParameter("category");
		String brand = request.getParameter("brand");
		String minPriceStr = request.getParameter("minPrice");
		String maxPriceStr = request.getParameter("maxPrice");
		String keyword = request.getParameter("keyword");
		String sort = request.getParameter("sort");

		// LOAD ALL PRODUCTS FROM DATABASE
		List<ProductModel> products = productService.getAllProducts();

		// SEARCH BY KEYWORD (PRODUCT NAME MATCH)
		if (keyword != null && !keyword.trim().isEmpty()) {

			String search = keyword.toLowerCase();

			products = products.stream()
					.filter(p -> p.getProductName() != null && p.getProductName().toLowerCase().contains(search))
					.toList();
		}

		// FILTER BY CATEGORY
		if (category != null && !category.trim().isEmpty()) {

			products = products.stream()
					.filter(p -> p.getCategory() != null && p.getCategory().equalsIgnoreCase(category)).toList();
		}

		// FILTER BY BRAND
		if (brand != null && !brand.trim().isEmpty()) {

			products = products.stream().filter(p -> p.getBrand() != null && p.getBrand().equalsIgnoreCase(brand))
					.toList();
		}

		// PRICE FILTER SETUP (DEFAULT RANGE)
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

		// APPLY PRICE FILTER
		products = products.stream().filter(p -> p.getPrice() >= finalMinPrice && p.getPrice() <= finalMaxPrice)
				.toList();

		// SORT PRODUCTS BASED ON USER SELECTION
		if (sort != null && !sort.isEmpty()) {

			switch (sort) {

			// LOW TO HIGH PRICE
			case "low":
				products = products.stream().sorted((a, b) -> Double.compare(a.getPrice(), b.getPrice())).toList();
				break;

			// HIGH TO LOW PRICE
			case "high":
				products = products.stream().sorted((a, b) -> Double.compare(b.getPrice(), a.getPrice())).toList();
				break;

			// NEWEST FIRST (HIGHER ID FIRST)
			case "new":
				products = products.stream().sorted((a, b) -> Integer.compare(b.getProductId(), a.getProductId()))
						.toList();
				break;

			default:
				break;
			}
		}

		// SET DATA FOR JSP VIEW
		request.setAttribute("products", products);
		request.setAttribute("keyword", keyword);
		request.setAttribute("sort", sort);

		// FORWARD TO PRODUCT PAGE
		request.getRequestDispatcher("/WEB-INF/pages/product.jsp").forward(request, response);
	}
}