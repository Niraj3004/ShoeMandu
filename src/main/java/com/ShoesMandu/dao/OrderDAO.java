package com.shoesmandu.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.shoesmandu.model.OrderModel;
import com.shoesmandu.util.DBconfig;

/**
 * OrderDAO handles all database operations
 * related to orders in the Shoesmandu system.
 * 
 * It provides functionalities such as:
 * 1. Placing customer orders
 * 2. Retrieving user order history
 * 3. Retrieving all orders for admin
 * 4. Updating order status
 * 
 * This DAO interacts with:
 * - orders table
 * - order_items table
 * - products table
 * - user table

 */
public class OrderDAO {

	/**
	 * Places an order for the user.
	 * 
	 * This method performs the following steps:
	 * 1. Retrieves cart items
	 * 2. Calculates total amount
	 * 3. Creates a new order
	 * 4. Inserts order items
	 * 5. Clears the cart after successful checkout
	 * 
	 * @param userId the ID of the user placing the order
	 * @return true if order is placed successfully,
	 *         otherwise false
	 */
	public boolean placeOrder(int userId) {

		try (Connection con = DBconfig.getConnection()) {

			// 1. GET CART ITEMS WITH PRICE
			String cartSql = "SELECT c.product_id, c.quantity, p.price " + "FROM cart c "
					+ "JOIN products p ON c.product_id = p.product_id " + "WHERE c.user_id=?";

			PreparedStatement cartPs = con.prepareStatement(cartSql);

			cartPs.setInt(1, userId);

			ResultSet rs = cartPs.executeQuery();

			// CHECK IF CART IS EMPTY
			if (!rs.isBeforeFirst()) {
				return false;
			}

			List<int[]> items = new ArrayList<>();

			double totalAmount = 0;

			// CALCULATE TOTAL AMOUNT
			while (rs.next()) {

				int productId = rs.getInt("product_id");
				int qty = rs.getInt("quantity");
				double price = rs.getDouble("price");

				totalAmount += qty * price;

				items.add(new int[] { productId, qty });
			}

			// 2. CREATE ORDER
			String orderSql = "INSERT INTO orders(user_id, total_amount, order_status, shipping_address) "
					+ "VALUES(?,?,?,?)";

			PreparedStatement orderPs = con.prepareStatement(orderSql,
					Statement.RETURN_GENERATED_KEYS);

			orderPs.setInt(1, userId);
			orderPs.setDouble(2, totalAmount);
			orderPs.setString(3, "PENDING");
			orderPs.setString(4, "Kathmandu");

			orderPs.executeUpdate();

			ResultSet keys = orderPs.getGeneratedKeys();

			int orderId = 0;

			if (keys.next()) {

				orderId = keys.getInt(1);
			}

			// 3. INSERT ORDER ITEMS
			String itemSql = "INSERT INTO order_items(order_id, product_id, quantity, price) "
					+ "VALUES(?,?,?,?)";

			PreparedStatement itemPs = con.prepareStatement(itemSql);

			for (int[] item : items) {

				int productId = item[0];
				int qty = item[1];

				PreparedStatement pricePs = con.prepareStatement(
						"SELECT price FROM products WHERE product_id=?");

				pricePs.setInt(1, productId);

				ResultSet pr = pricePs.executeQuery();

				double price = 0;

				if (pr.next()) {

					price = pr.getDouble("price");
				}

				itemPs.setInt(1, orderId);
				itemPs.setInt(2, productId);
				itemPs.setInt(3, qty);
				itemPs.setDouble(4, price);

				itemPs.executeUpdate();
			}

			// 4. CLEAR CART
			PreparedStatement clear = con.prepareStatement(
					"DELETE FROM cart WHERE user_id=?");

			clear.setInt(1, userId);

			clear.executeUpdate();

			return true;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Retrieves all orders placed by a specific user.
	 * 
	 * This method joins orders, order_items,
	 * and products tables to display
	 * complete order details.
	 * 
	 * @param userId the ID of the user
	 * @return List<OrderModel> containing user orders
	 */
	public List<OrderModel> getOrdersByUser(int userId) {

		List<OrderModel> list = new ArrayList<>();

		String sql = "SELECT o.order_id, o.user_id, o.total_amount, o.order_status, o.shipping_address, "
				+ "oi.order_item_id, oi.product_id, oi.quantity, oi.price, "
				+ "p.product_name, p.description, p.image_url " + "FROM orders o "
				+ "JOIN order_items oi ON o.order_id = oi.order_id "
				+ "JOIN products p ON oi.product_id = p.product_id " + "WHERE o.user_id=? ORDER BY o.order_id DESC";

		try (Connection con = DBconfig.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			// SET USER ID
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			// LOOP THROUGH ORDERS
			while (rs.next()) {

				OrderModel order = new OrderModel();

				order.setOrderId(rs.getInt("order_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setTotalAmount(rs.getDouble("total_amount"));
				order.setOrderStatus(rs.getString("order_status"));
				order.setShippingAddress(rs.getString("shipping_address"));

				order.setOrderItemId(rs.getInt("order_item_id"));
				order.setProductId(rs.getInt("product_id"));
				order.setQuantity(rs.getInt("quantity"));
				order.setPrice(rs.getDouble("price"));

				order.setProductName(rs.getString("product_name"));
				order.setDescription(rs.getString("description"));
				order.setImageUrl(rs.getString("image_url"));

				// ADD ORDER TO LIST
				list.add(order);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	/**
	 * Retrieves all orders for the admin panel.
	 * 
	 * This method joins orders, order_items,
	 * products, and user tables to display
	 * complete order information.
	 * 
	 * @return List<OrderModel> containing all orders
	 */
	public List<OrderModel> getAllOrders() {

		List<OrderModel> list = new ArrayList<>();

		String sql = "SELECT o.order_id, o.user_id, o.total_amount, o.order_status, o.shipping_address, "
				+ "oi.quantity, oi.price, " + "p.product_name, p.image_url, " + "u.user_first_name, u.user_email "
				+ "FROM orders o " + "JOIN order_items oi ON o.order_id = oi.order_id "
				+ "JOIN products p ON oi.product_id = p.product_id " + "JOIN user u ON o.user_id = u.user_id "
				+ "ORDER BY o.order_id DESC";

		try (Connection con = DBconfig.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();

			// LOOP THROUGH ALL ORDERS
			while (rs.next()) {

				OrderModel order = new OrderModel();

				order.setOrderId(rs.getInt("order_id"));
				order.setUserId(rs.getInt("user_id"));
				order.setTotalAmount(rs.getDouble("total_amount"));
				order.setOrderStatus(rs.getString("order_status"));
				order.setShippingAddress(rs.getString("shipping_address"));

				order.setQuantity(rs.getInt("quantity"));
				order.setPrice(rs.getDouble("price"));

				order.setProductName(rs.getString("product_name"));
				order.setImageUrl(rs.getString("image_url"));

				order.setCustomerName(rs.getString("user_first_name"));
				order.setCustomerEmail(rs.getString("user_email"));

				// ADD ORDER TO LIST
				list.add(order);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;
	}

	/**
	 * Updates the status of an order.
	 * 
	 * This method is used by admin
	 * to manage order progress.
	 * 
	 * @param orderId the order ID
	 * @param status the new order status
	 * @return true if status is updated successfully,
	 *         otherwise false
	 */
	public boolean updateOrderStatus(int orderId, String status) {

		String sql = "UPDATE orders SET order_status=? WHERE order_id=?";

		try (Connection con = DBconfig.getConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {

			// SET STATUS
			ps.setString(1, status);

			// SET ORDER ID
			ps.setInt(2, orderId);

			// EXECUTE UPDATE
			return ps.executeUpdate() > 0;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return false;
	}
}