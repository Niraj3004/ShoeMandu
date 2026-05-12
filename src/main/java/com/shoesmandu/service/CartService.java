package com.shoesmandu.service;

import java.util.List;

import com.shoesmandu.dao.CartDAO;
import com.shoesmandu.model.CartModel;

public class CartService {

    private CartDAO dao = new CartDAO();

    public boolean addToCart(CartModel cart) {
        return dao.addToCart(cart);
    }

    public List<CartModel> getCartItems(int userId) {
        return dao.getCartItems(userId);
    }
}