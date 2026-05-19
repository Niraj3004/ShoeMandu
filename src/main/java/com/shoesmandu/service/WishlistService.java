package com.shoesmandu.service;

import java.util.List;

import com.shoesmandu.dao.WishlistDAO;
import com.shoesmandu.model.WishlistModel;

/**
 * WishlistService acts as a service layer between
 * controllers and DAO for wishlist-related operations.
 * 
 * It handles business logic for:
 * 1. Adding products to wishlist
 * 2. Retrieving user wishlist
 * 3. Removing products from wishlist
 * 
 * This service communicates with WishlistDAO
 * to perform database operations.
 */
public class WishlistService {

    private WishlistDAO dao = new WishlistDAO();

    /**
     * Adds a product to user's wishlist.
     * 
     * @param wishlist WishlistModel object containing data
     * @return true if added successfully
     */
    public boolean addToWishlist(WishlistModel wishlist) {
        return dao.addToWishlist(wishlist);
    }

    /**
     * Retrieves wishlist items of a user.
     * 
     * @param userId user ID
     * @return List of WishlistModel
     */
    public List<WishlistModel> getWishlist(int userId) {
        return dao.getWishlist(userId);
    }

    /**
     * Removes a product from wishlist.
     * 
     * @param productId product ID
     * @return true if removed successfully
     */
    public boolean removeFromWishlist(int productId) {
        return dao.removeFromWishlist(productId);
    }
}