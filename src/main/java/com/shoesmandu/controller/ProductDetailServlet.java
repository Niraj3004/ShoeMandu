package com.shoesmandu.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.shoesmandu.model.ProductModel;
import com.shoesmandu.service.ProductService;

@WebServlet("/ProductDetail")
public class ProductDetailServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        ProductModel product = productService.getProductById(id);

        if (product == null) {
            resp.sendRedirect(req.getContextPath() + "/product");
            return;
        }

        req.setAttribute("product", product);

        req.getRequestDispatcher("/WEB-INF/pages/productdetails.jsp")
                .forward(req, resp);
    }
}