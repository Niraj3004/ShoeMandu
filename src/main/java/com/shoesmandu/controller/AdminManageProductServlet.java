package com.shoesmandu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.shoesmandu.model.ProductModel;
import com.shoesmandu.service.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * AdminManageProductServlet
 *
 * This servlet is responsible for:
 * 1. Handling HTTP GET requests from admin product management page
 * 2. Fetching all products from database
 * 3. Searching products based on keyword (if provided)
 * 4. Sending product data to JSP page for display
 */
@WebServlet("/admin-manageproduct")
public class AdminManageProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Service layer object used to communicate with DAO layer
    private ProductService productService = new ProductService();

    /**
     * doGet() method is triggered when user opens admin-manageproduct page
     * or performs a search request.
     *
     * HTTP GET is used because we are only retrieving data (not inserting/updating).
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Get search keyword from request URL (if user searched something)
        String keyword = req.getParameter("keyword");

        // List to store products retrieved from database
        List<ProductModel> products;

        try {

            // If keyword is provided, perform search operation
            // Otherwise load all products
            if (keyword != null && !keyword.trim().isEmpty()) {

                // Search products using keyword (name, brand, category, etc.)
                products = productService.searchProducts(keyword);

            } else {

                // Fetch all products from database
                products = productService.getAllProducts();
            }

        } catch (Exception e) {

            // If any error occurs during database operation,
            // print error in console for debugging
            e.printStackTrace();

            // Initialize empty list to avoid JSP null pointer error
            products = new ArrayList<>();

            // Send error message to JSP page
            req.setAttribute("error", "Failed to load products");
        }

        // Set product list into request scope so JSP can access it
        req.setAttribute("products", products);

        // Forward request to JSP page (admin product management UI)
        // Forward means URL will not change, request is internally passed
        req.getRequestDispatcher("/WEB-INF/pages/adminmanageproduct.jsp")
           .forward(req, resp);
    }
}