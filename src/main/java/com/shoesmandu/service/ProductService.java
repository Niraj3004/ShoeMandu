package com.shoesmandu.service;

import java.util.List;

import com.shoesmandu.dao.ProductDAO;
import com.shoesmandu.model.ProductModel;

public class ProductService {

	private ProductDAO dao = new ProductDAO();

	// ADD
	public boolean addProduct(ProductModel product) {

		return dao.insert(product);
	}

	// GET ALL
	public List<ProductModel> getAllProducts() {

		return dao.getAllProducts();
	}

	// GET BY ID
	public ProductModel getProductById(int id) {

		return dao.getProductById(id);
	}

	// UPDATE
	public boolean updateProduct(ProductModel product) {

		return dao.updateProduct(product);
	}

	// DELETE
	public boolean deleteProduct(int id) {

		return dao.deleteProduct(id);
	}

	// SEARCH PRODUCTS
	public List<ProductModel> searchProducts(String keyword) {

		return dao.searchProducts(keyword);
	}
}