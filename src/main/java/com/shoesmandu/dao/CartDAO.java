package com.shoesmandu.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.shoesmandu.model.CartModel;
import com.shoesmandu.util.DBconfig;

/**
 * CartDAO handles all database operations
 * related to the shopping cart in the
 * Shoesmandu system.
 * 
 * It provides functionalities such as:
 * 1. Adding products to the cart
 * 2. Retrieving cart items with product details
 * 3. Updating product quantity in the cart
 * 4. Deleting cart items
 * 
 * This DAO interacts with the cart and products
 * tables in the database.

 */
public class CartDAO {

	/**
	 * Adds a product to the cart.
	 * 
	 * This method inserts cart details into
	 * the cart table.
	 * 
	 * @param cart the CartModel object containing cart details
	 * @return true if product is added successfully,
	 *         otherwise false
	 */
	public boolean addToCart(CartModel cart) {

		String sql = "INSERT INTO cart(user_id, product_id, quantity) VALUES(?,?,?)";

		try (Connection con = DBconfig.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			// SET USER ID
			ps.setInt(1, cart.getUserId());

			// SET PRODUCT ID
			ps.setInt(2, cart.getProductId());

			// SET QUANTITY
			ps.setInt(3, cart.getQuantity());

			// EXECUTE INSERT
			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Retrieves all cart items of a user
	 * along with product details.
	 * 
	 * This method joins the cart table
	 * with the products table.
	 * 
	 * @param userId the ID of the user
	 * @return List<CartModel> containing cart items
	 */
	public List<CartModel> getCartItems(int userId) {

		List<CartModel> list = new ArrayList<>();

		String sql = "SELECT c.cart_id, c.user_id, c.product_id, c.quantity, "
				+ "p.product_name, p.description, p.price, p.image_url " + "FROM cart c "
				+ "JOIN products p ON c.product_id = p.product_id " + "WHERE c.user_id = ?";

		try (Connection con = DBconfig.getConnection(); 
				PreparedStatement ps = con.prepareStatement(sql)) {

			// SET USER ID
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			// LOOP THROUGH CART ITEMS
			while (rs.next()) {

				CartModel cart = new CartModel();

				cart.setCartId(rs.getInt("cart_id"));
				cart.setUserId(rs.getInt("user_id"));
				cart.setProductId(rs.getInt("product_id"));
				cart.setQuantity(rs.getInt("quantity"));

				cart.setProductName(rs.getString("product_name"));
				cart.setDescription(rs.getString("description"));
				cart.setPrice(rs.getDouble("price"));
				cart.setImageUrl(rs.getString("image_url"));

				// ADD ITEM TO LIST
				list.add(cart);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	/**
	 * Updates the quantity of a cart item.
	 * 
	 * @param cartId the cart ID
	 * @param quantity the new quantity
	 * @return true if update is successful,
	 *         otherwise false
	 */
	public boolean updateQuantity(int cartId, int quantity) {

		String sql = "UPDATE cart SET quantity=? WHERE cart_id=?";

		try (Connection con = DBconfig.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			// SET QUANTITY
			ps.setInt(1, quantity);

			// SET CART ID
			ps.setInt(2, cartId);

			// EXECUTE UPDATE
			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Deletes an item from the cart.
	 * 
	 * @param cartId the cart ID
	 * @return true if item is deleted successfully,
	 *         otherwise false
	 */
	public boolean deleteCartItem(int cartId) {

		String sql = "DELETE FROM cart WHERE cart_id=?";

		try (Connection con = DBconfig.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			// SET CART ID
			ps.setInt(1, cartId);

			// EXECUTE DELETE
			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}
}