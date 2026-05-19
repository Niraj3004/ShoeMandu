package com.shoesmandu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoesmandu.model.WishlistModel;
import com.shoesmandu.util.DBconfig;

/**
 * WishlistDAO handles all database operations
 * related to the wishlist feature in the
 * Shoesmandu system.
 * 
 * It provides functionalities such as:
 * 1. Adding products to wishlist
 * 2. Retrieving user wishlist with product details
 * 3. Removing items from wishlist
 * 
 * This DAO interacts with:
 * - wishlist table
 * - products table (for join operations)
 */
public class WishlistDAO {

	/**
	 * Adds a product to the user's wishlist.
	 * 
	 * @param wishlist WishlistModel object containing user and product IDs
	 * @return true if product is added successfully,
	 *         otherwise false
	 */
	public boolean addToWishlist(WishlistModel wishlist) {

		String sql = "INSERT INTO wishlist(user_id, product_id) VALUES(?, ?)";

		try (Connection con = DBconfig.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			// SET USER ID
			ps.setInt(1, wishlist.getUserId());

			// SET PRODUCT ID
			ps.setInt(2, wishlist.getProductId());

			// EXECUTE INSERT
			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Retrieves wishlist items of a user
	 * along with product details.
	 * 
	 * This method joins wishlist and products table.
	 * 
	 * @param userId the ID of the user
	 * @return List<WishlistModel> containing wishlist items
	 */
	public List<WishlistModel> getWishlist(int userId) {

		List<WishlistModel> list = new ArrayList<>();

		String sql = "SELECT w.wishlist_id, w.user_id, w.product_id, "
				+ "p.product_name, p.description, "
				+ "p.price, p.image_url "
				+ "FROM wishlist w "
				+ "JOIN products p ON w.product_id = p.product_id "
				+ "WHERE w.user_id = ?";

		try (Connection con = DBconfig.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			// SET USER ID
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			// LOOP THROUGH WISHLIST ITEMS
			while (rs.next()) {

				WishlistModel wishlist = new WishlistModel();

				wishlist.setWishlistId(rs.getInt("wishlist_id"));
				wishlist.setUserId(rs.getInt("user_id"));
				wishlist.setProductId(rs.getInt("product_id"));

				wishlist.setProductName(rs.getString("product_name"));
				wishlist.setDescription(rs.getString("description"));
				wishlist.setPrice(rs.getDouble("price"));
				wishlist.setImageUrl(rs.getString("image_url"));

				// ADD TO LIST
				list.add(wishlist);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	/**
	 * Removes a product from wishlist.
	 * 
	 * @param productId the product ID to remove
	 * @return true if deletion is successful,
	 *         otherwise false
	 */
	public boolean removeFromWishlist(int productId) {

		String sql = "DELETE FROM wishlist WHERE product_id=?";

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
}