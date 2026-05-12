package com.shoesmandu.service;

import java.util.List;

import com.shoesmandu.dao.WishlistDAO;
import com.shoesmandu.model.WishlistModel;

public class WishlistService {

    private WishlistDAO dao = new WishlistDAO();

    public boolean addToWishlist(WishlistModel wishlist) {
        return dao.addToWishlist(wishlist);
    }

    public List<WishlistModel> getWishlist(int userId) {
        return dao.getWishlist(userId);
    }
}