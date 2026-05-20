package com.shoesmandu.controller;

import java.io.File;
import java.io.IOException;

import com.shoesmandu.model.ProductModel;
import com.shoesmandu.service.ProductService;
import com.shoesmandu.util.ImageUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * AdminEditProductServlet handles product update functionality.
 * It allows admin to load existing product data and update it.
 */
@WebServlet("/admin/edit-product")
@MultipartConfig
public class AdminEditProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private ProductService productService = new ProductService();

    /**
     * Loads product data into edit form.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // GET PRODUCT ID
        int id = Integer.parseInt(req.getParameter("id"));

        // FETCH PRODUCT DETAILS
        ProductModel product = productService.getProductById(id);

        // SET ATTRIBUTE FOR JSP
        req.setAttribute("product", product);

        // FORWARD TO EDIT PAGE
        req.getRequestDispatcher("/WEB-INF/pages/editproduct.jsp")
           .forward(req, resp);
    }

    /**
     * Handles product update request.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // GET FORM DATA
        int productId = Integer.parseInt(req.getParameter("productId"));
        String productName = req.getParameter("productName");
        String brand = req.getParameter("brand");
        String category = req.getParameter("category");
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        int stock = Integer.parseInt(req.getParameter("stock"));

        // FETCH EXISTING PRODUCT
        ProductModel product = productService.getProductById(productId);

        // UPDATE VALUES
        product.setProductName(productName);
        product.setBrand(brand);
        product.setCategory(category);
        product.setDescription(description);
        product.setPrice(price);
        product.setStock(stock);

        // IMAGE UPLOAD (IF NEW IMAGE PROVIDED)
        Part filePart = req.getPart("image");

        if (filePart != null && filePart.getSize() > 0) {

            ImageUtil imageUtil = new ImageUtil();

            String fileName = imageUtil.getImageNameFromPart(filePart);

            String uploadPath = getServletContext().getRealPath("")
                    + File.separator + "uploads";

            imageUtil.uploadImage(filePart, uploadPath, "");

            product.setImageUrl("uploads/" + fileName);
        }

        // UPDATE PRODUCT IN DATABASE
        boolean updated = productService.updateProduct(product);

        if (updated) {

            resp.sendRedirect(req.getContextPath() + "/admin-manageproduct");

        } else {

            req.setAttribute("error", "Update failed");
            req.setAttribute("product", product);

            req.getRequestDispatcher("/WEB-INF/pages/editproduct.jsp")
               .forward(req, resp);
        }
    }
}