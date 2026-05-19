package com.shoesmandu.service;

import java.util.List;

import com.shoesmandu.dao.ProductDAO;
import com.shoesmandu.model.ProductModel;

/**
 * ProductService acts as a service layer between
 * controllers and DAO for product-related operations.
 * 
 * It handles business logic for:
 * 1. Adding new products
 * 2. Retrieving all products
 * 3. Getting product by ID
 * 4. Updating product details
 * 5. Deleting products
 * 6. Searching products
 * 
 * This service communicates with ProductDAO
 * to perform database operations.
 */
public class ProductService {

    private ProductDAO dao = new ProductDAO();

    /**
     * Adds a new product to the system.
     * 
     * @param product ProductModel object
     * @return true if product added successfully
     */
    public boolean addProduct(ProductModel product) {

        return dao.insert(product);
    }

    /**
     * Retrieves all products.
     * 
     * @return List of ProductModel
     */
    public List<ProductModel> getAllProducts() {

        return dao.getAllProducts();
    }

    /**
     * Retrieves a product by ID.
     * 
     * @param productId product ID
     * @return ProductModel object
     */
    public ProductModel getProductById(int productId) {

        return dao.getProductById(productId);
    }

    /**
     * Updates product details.
     * 
     * @param product ProductModel object
     * @return true if update successful
     */
    public boolean updateProduct(ProductModel product) {

        return dao.updateProduct(product);
    }

    /**
     * Deletes a product by ID.
     * 
     * @param productId product ID
     * @return true if deletion successful
     */
    public boolean deleteProduct(int productId) {

        return dao.deleteProduct(productId);
    }

    /**
     * Searches products by keyword.
     * 
     * @param keyword search keyword
     * @return List of matching products
     */
    public List<ProductModel> searchProducts(String keyword) {

        return dao.searchProducts(keyword);
    }
}