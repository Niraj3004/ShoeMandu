package com.shoesmandu.controller;

import java.io.IOException;

import com.shoesmandu.service.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/admin/delete-product")
public class AdminDeleteProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ProductService productService = new ProductService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        productService.deleteProduct(id);

        resp.sendRedirect(req.getContextPath() + "/admin-manageproduct");
    }
}