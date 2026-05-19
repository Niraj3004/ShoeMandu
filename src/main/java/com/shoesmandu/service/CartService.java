package com.shoesmandu.service;

import java.util.List;

import com.shoesmandu.dao.CartDAO;
import com.shoesmandu.model.CartModel;

/**
 * CartService acts as a service layer between
 * controllers and DAO for cart-related operations.
 * 
 * It handles business logic for:
 * 1. Adding items to cart
 * 2. Retrieving cart items
 * 3. Updating item quantity
 * 4. Removing items from cart
 * 
 * This service communicates with CartDAO
 * to perform database operations.
 */
public class CartService {

    private CartDAO dao = new CartDAO();

    /**
     * Adds a product to the cart.
     * 
     * @param cart CartModel object containing cart data
     * @return true if item is added successfully
     */
    public boolean addToCart(CartModel cart) {
        return dao.addToCart(cart);
    }

    /**
     * Retrieves all cart items for a user.
     * 
     * @param userId user ID
     * @return List<CartModel> containing cart items
     */
    public List<CartModel> getCartItems(int userId) {
        return dao.getCartItems(userId);
    }

    /**
     * Updates quantity of a cart item.
     * 
     * @param cartId cart item ID
     * @param qty new quantity
     * @return true if update is successful
     */
    public boolean updateQuantity(int cartId, int qty) {
        return dao.updateQuantity(cartId, qty);
    }

    /**
     * Deletes a cart item.
     * 
     * @param cartId cart item ID
     * @return true if deletion is successful
     */
    public boolean deleteCartItem(int cartId) {
        return dao.deleteCartItem(cartId);
    }
}