package com.shoesmandu.controller;

import java.io.IOException;

import com.shoesmandu.model.ProductModel;
import com.shoesmandu.service.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * ProductDetailServlet handles the product detail page request.
 *
 * This servlet is responsible for:
 * - Receiving product ID from request
 * - Fetching product details from database via service layer
 * - Sending product data to JSP for display
 * - Handling errors and redirecting if needed
 */
@WebServlet("/product-detail")
public class ProductDetailServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Service layer object used to access product business logic
    private ProductService productService = new ProductService();

    /**
     * Handles HTTP GET request for product detail page.
     *
     * @param req  HttpServletRequest object that contains client request data
     *              - Expected parameter: "id" (product ID)
     *
     * @param resp HttpServletResponse object used to send response or redirect
     *
     * @throws ServletException if servlet processing fails
     * @throws IOException      if input/output error occurs during request handling
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {

            // Get product ID from request parameter "id"
            // Example URL: /product-detail?id=5
            int productId = Integer.parseInt(req.getParameter("id"));

            // Fetch product details from service layer using product ID
            ProductModel product = productService.getProductById(productId);

            // Set product object into request scope for JSP access
            // JSP can access it using ${product}
            req.setAttribute("product", product);

            // Forward request to product details JSP page
            req.getRequestDispatcher("/WEB-INF/pages/productdetails.jsp")
                    .forward(req, resp);

        } catch (Exception e) {

            // Print error in console for debugging purposes
            e.printStackTrace();

            // Redirect user to product listing page if any error occurs
            resp.sendRedirect(req.getContextPath() + "/product");
        }
    }
}