package com.shoesmandu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoesmandu.model.ProductModel;
import com.shoesmandu.util.DBconfig;

public class ProductDAO {

	// ADD PRODUCT
	public boolean insert(ProductModel product) {

		String sql = "INSERT INTO products(product_name, brand, category, description, price, stock, image_url) VALUES(?,?,?,?,?,?,?)";

		try (Connection con = DBconfig.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, product.getProductName());
			ps.setString(2, product.getBrand());
			ps.setString(3, product.getCategory());
			ps.setString(4, product.getDescription());
			ps.setDouble(5, product.getPrice());
			ps.setInt(6, product.getStock());
			ps.setString(7, product.getImageUrl());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// GET ALL PRODUCTS
	public List<ProductModel> getAllProducts() {

		List<ProductModel> list = new ArrayList<>();

		String sql = "SELECT * FROM products";

		try (Connection con = DBconfig.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

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

				list.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// GET PRODUCT BY ID
	public ProductModel getProductById(int id) {

		String sql = "SELECT * FROM products WHERE product_id=?";

		try (Connection con = DBconfig.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				ProductModel product = new ProductModel();

				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
				product.setBrand(rs.getString("brand"));
				product.setCategory(rs.getString("category"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setStock(rs.getInt("stock"));
				product.setImageUrl(rs.getString("image_url"));

				return product;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// UPDATE PRODUCT
	public boolean updateProduct(ProductModel product) {

		String sql = "UPDATE products SET product_name=?, brand=?, category=?, description=?, price=?, stock=?, image_url=? WHERE product_id=?";

		try (Connection con = DBconfig.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, product.getProductName());
			ps.setString(2, product.getBrand());
			ps.setString(3, product.getCategory());
			ps.setString(4, product.getDescription());
			ps.setDouble(5, product.getPrice());
			ps.setInt(6, product.getStock());
			ps.setString(7, product.getImageUrl());
			ps.setInt(8, product.getProductId());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// DELETE PRODUCT
	public boolean deleteProduct(int id) {

		String sql = "DELETE FROM products WHERE product_id=?";

		try (Connection con = DBconfig.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// SEARCH PRODUCT
	public List<ProductModel> searchProducts(String keyword) {

	    List<ProductModel> list = new ArrayList<>();

	    String sql = "SELECT * FROM products WHERE product_name LIKE ?";

	    try (Connection con = DBconfig.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, "%" + keyword + "%");

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {

	            ProductModel p = new ProductModel();

	            p.setProductId(rs.getInt("product_id"));
	            p.setProductName(rs.getString("product_name"));
	            p.setBrand(rs.getString("brand"));
	            p.setCategory(rs.getString("category"));
	            p.setDescription(rs.getString("description"));
	            p.setPrice(rs.getDouble("price"));
	            p.setStock(rs.getInt("stock"));
	            p.setImageUrl(rs.getString("image_url"));

	            list.add(p);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
}