package com.shoesmandu.controller;

import java.io.IOException;

import com.shoesmandu.service.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * AdminDeleteProductServlet handles product deletion from admin panel.
 * It deletes a product based on product ID and redirects to manage page.
 */
@WebServlet("/admin/delete-product")
public class AdminDeleteProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ProductService productService = new ProductService();

    /**
     * Handles GET request to delete a product.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // GET PRODUCT ID
        int id = Integer.parseInt(req.getParameter("id"));

        // DELETE PRODUCT
        productService.deleteProduct(id);

        // REDIRECT TO MANAGE PRODUCT PAGE
        resp.sendRedirect(req.getContextPath() + "/admin-manageproduct");
    }
}