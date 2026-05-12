package com.shoesmandu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoesmandu.model.CartModel;
import com.shoesmandu.util.DBconfig;

public class CartDAO {

    // ADD TO CART
    public boolean addToCart(CartModel cart) {

        String sql = "INSERT INTO cart(user_id, product_id, quantity) VALUES(?,?,?)";

        try (Connection con = DBconfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cart.getUserId());
            ps.setInt(2, cart.getProductId());
            ps.setInt(3, cart.getQuantity());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // GET CART ITEMS
    public List<CartModel> getCartItems(int userId) {

        List<CartModel> list = new ArrayList<>();

        String sql = "SELECT * FROM cart WHERE user_id=?";

        try (Connection con = DBconfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                CartModel c = new CartModel();

                c.setCartId(rs.getInt("cart_id"));
                c.setUserId(rs.getInt("user_id"));
                c.setProductId(rs.getInt("product_id"));
                c.setQuantity(rs.getInt("quantity"));

                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}