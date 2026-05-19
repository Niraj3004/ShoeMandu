package com.shoesmandu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoesmandu.model.ProductModel;
import com.shoesmandu.util.DBconfig;

/**
 * ProductDAO handles all database operations
 * related to products in the Shoesmandu system.
 * 
 * It provides functionalities such as:
 * 1. Inserting new products
 * 2. Retrieving all products
 * 3. Retrieving a product by ID
 * 4. Updating product details
 * 5. Deleting products
 * 6. Searching products
 * 
 * This DAO interacts with the products
 * table in the database.

 */
public class ProductDAO {

	/**
	 * Inserts a new product into the database.
	 * 
	 * @param product the ProductModel object containing product details
	 * @return true if product is inserted successfully,
	 *         otherwise false
	 */
	public boolean insert(ProductModel product) {

		String sql = "INSERT INTO products "
				+ "(product_name, brand, category, description, "
				+ "price, stock, image_url) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (Connection con = DBconfig.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			// SET PRODUCT NAME
			ps.setString(1, product.getProductName());

			// SET BRAND
			ps.setString(2, product.getBrand());

			// SET CATEGORY
			ps.setString(3, product.getCategory());

			// SET DESCRIPTION
			ps.setString(4, product.getDescription());

			// SET PRICE
			ps.setDouble(5, product.getPrice());

			// SET STOCK
			ps.setInt(6, product.getStock());

			// SET IMAGE URL
			ps.setString(7, product.getImageUrl());

			// EXECUTE INSERT
			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Retrieves all products from the database.
	 * 
	 * Products are ordered by product ID
	 * in descending order.
	 * 
	 * @return List<ProductModel> containing all products
	 */
	public List<ProductModel> getAllProducts() {

		List<ProductModel> list = new ArrayList<>();

		String sql = "SELECT * FROM products ORDER BY product_id DESC";

		try (Connection con = DBconfig.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			// LOOP THROUGH ALL PRODUCTS
			while (rs.next()) {

				ProductModel product = new ProductModel();

				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setBrand(rs.getString("brand"));
				product.setCategory(rs.getString("category"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setStock(rs.getInt("stock"));
				product.setImageUrl(rs.getString("image_url"));

				// ADD PRODUCT TO LIST
				list.add(product);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	/**
	 * Retrieves a product by its ID.
	 * 
	 * @param productId the product ID
	 * @return ProductModel containing product details
	 */
	public ProductModel getProductById(int productId) {

		ProductModel product = null;

		String sql = "SELECT * FROM products WHERE product_id = ?";

		try (Connection con = DBconfig.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			// SET PRODUCT ID
			ps.setInt(1, productId);

			ResultSet rs = ps.executeQuery();

			// CHECK IF PRODUCT EXISTS
			if (rs.next()) {

				product = new ProductModel();

				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setBrand(rs.getString("brand"));
				product.setCategory(rs.getString("category"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setStock(rs.getInt("stock"));
				product.setImageUrl(rs.getString("image_url"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return product;
	}

	/**
	 * Updates product information in the database.
	 * 
	 * @param product the ProductModel object containing updated details
	 * @return true if product is updated successfully,
	 *         otherwise false
	 */
	public boolean updateProduct(ProductModel product) {

		String sql = "UPDATE products SET " + "product_name=?, " + "brand=?, " + "category=?, " + "description=?, "
				+ "price=?, " + "stock=?, " + "image_url=? " + "WHERE product_id=?";

		try (Connection con = DBconfig.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			// SET PRODUCT DETAILS
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getBrand());
			ps.setString(3, product.getCategory());
			ps.setString(4, product.getDescription());
			ps.setDouble(5, product.getPrice());
			ps.setInt(6, product.getStock());
			ps.setString(7, product.getImageUrl());

			// SET PRODUCT ID
			ps.setInt(8, product.getProductId());

			// EXECUTE UPDATE
			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Deletes a product from the database.
	 * 
	 * @param productId the product ID
	 * @return true if product is deleted successfully,
	 *         otherwise false
	 */
	public boolean deleteProduct(int productId) {

		String sql = "DELETE FROM products WHERE product_id=?";

		try (Connection con = DBconfig.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			// SET PRODUCT ID
			ps.setInt(1, productId);

			// EXECUTE DELETE
			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Searches products based on keyword.
	 * 
	 * This method searches by:
	 * - Product name
	 * - Brand
	 * - Category
	 * - Description
	 * 
	 * @param keyword the search keyword
	 * @return List<ProductModel> containing matching products
	 */
	public List<ProductModel> searchProducts(String keyword) {

		List<ProductModel> list = new ArrayList<>();

		String sql = "SELECT * FROM products " + "WHERE product_name LIKE ? " + "OR brand LIKE ? "
				+ "OR category LIKE ? " + "OR description LIKE ? " + "ORDER BY product_id DESC";

		try (Connection con = DBconfig.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			String key = "%" + keyword + "%";

			// SET SEARCH KEYWORDS
			ps.setString(1, key);
			ps.setString(2, key);
			ps.setString(3, key);
			ps.setString(4, key);

			ResultSet rs = ps.executeQuery();

			// LOOP THROUGH SEARCH RESULTS
			while (rs.next()) {

				ProductModel product = new ProductModel();

				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setBrand(rs.getString("brand"));
				product.setCategory(rs.getString("category"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setStock(rs.getInt("stock"));
				product.setImageUrl(rs.getString("image_url"));

				// ADD PRODUCT TO LIST
				list.add(product);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}
}