package com.shoesmandu.service;

import java.util.List;

import com.shoesmandu.dao.OrderDAO;
import com.shoesmandu.model.OrderModel;

/**
 * OrderService acts as a service layer between
 * controllers and DAO for order-related operations.
 * 
 * It handles business logic for:
 * 1. Placing orders (checkout)
 * 2. Retrieving user order history
 * 3. Retrieving all orders (admin)
 * 4. Updating order status
 * 
 * This service communicates with OrderDAO
 * to perform database operations.
 */
public class OrderService {

    private OrderDAO dao = new OrderDAO();

    /**
     * Retrieves all orders for a specific user.
     * 
     * @param userId user ID
     * @return List of OrderModel
     */
    public List<OrderModel> getOrdersByUser(int userId) {
        return dao.getOrdersByUser(userId);
    }

    /**
     * Retrieves all orders for admin dashboard.
     * 
     * @return List of all orders
     */
    public List<OrderModel> getAllOrders() {
        return dao.getAllOrders();
    }

    /**
     * Places an order for the given user.
     * 
     * @param userId user ID
     * @return true if order placed successfully
     */
    public boolean placeOrder(int userId) {
        return dao.placeOrder(userId);
    }

    /**
     * Updates order status (admin operation).
     * 
     * @param orderId order ID
     * @param status new order status
     * @return true if update successful
     */
    public boolean updateOrderStatus(int orderId, String status) {
        return dao.updateOrderStatus(orderId, status);
    }
}