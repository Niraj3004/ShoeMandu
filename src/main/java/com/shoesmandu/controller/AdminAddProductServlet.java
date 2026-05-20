package com.shoesmandu.controller;

import java.io.IOException;

import com.shoesmandu.model.ProductModel;
import com.shoesmandu.service.ProductService;
import com.shoesmandu.util.ImageUtil;
import com.shoesmandu.util.ValidationUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * AdminAddProductServlet handles product creation
 * in the Shoesmandu admin panel.
 * 
 * It provides:
 * 1. Product form page (GET request)
 * 2. Product creation with validation (POST request)
 * 3. Image upload handling
 * 4. Saving product via service layer
 */
@WebServlet("/adminadd-product")
@MultipartConfig
public class AdminAddProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ProductService productService = new ProductService();

    /**
     * Loads the Add Product page.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/pages/adminaddproduct.jsp")
           .forward(req, resp);
    }

    /**
     * Handles product creation request.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // GET FORM DATA
        String productName = req.getParameter("productName");
        String brand = req.getParameter("brand");
        String category = req.getParameter("category");
        String description = req.getParameter("description");

        String priceStr = req.getParameter("price");
        String stockStr = req.getParameter("stock");

        // VALIDATION
        if (ValidationUtil.isNullOrEmpty(productName) ||
            ValidationUtil.isNullOrEmpty(brand) ||
            ValidationUtil.isNullOrEmpty(category) ||
            ValidationUtil.isNullOrEmpty(priceStr) ||
            ValidationUtil.isNullOrEmpty(stockStr)) {

            req.setAttribute("error", "All fields are required");

            req.getRequestDispatcher("/WEB-INF/pages/adminaddproduct.jsp")
               .forward(req, resp);

            return;
        }

        double price;
        int stock;

        try {
            price = Double.parseDouble(priceStr);
            stock = Integer.parseInt(stockStr);
        } catch (Exception e) {

            req.setAttribute("error", "Invalid price or stock value");

            req.getRequestDispatcher("/WEB-INF/pages/adminaddproduct.jsp")
               .forward(req, resp);

            return;
        }

        // IMAGE UPLOAD
        Part filePart = req.getPart("image");

        String imagePath = null;

        if (filePart != null && filePart.getSize() > 0) {

            ImageUtil imageUtil = new ImageUtil();

            String fileName = imageUtil.getImageNameFromPart(filePart);

            String uploadPath =
                getServletContext().getRealPath("/")
                + "resources/images/product";

            // UPLOAD IMAGE
            imageUtil.uploadImage(filePart, uploadPath, "");

            imagePath = "resources/images/product/" + fileName;
        }

        // SET MODEL
        ProductModel product = new ProductModel();

        product.setProductName(productName.trim());
        product.setBrand(brand.trim());
        product.setCategory(category.trim());
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock);
        product.setImageUrl(imagePath);

        // SAVE PRODUCT
        boolean added = productService.addProduct(product);

        if (added) {

            resp.sendRedirect(req.getContextPath() + "/admin-manageproduct");

        } else {

            req.setAttribute("error", "Failed to add product");

            req.getRequestDispatcher("/WEB-INF/pages/adminaddproduct.jsp")
               .forward(req, resp);
        }
    }
}