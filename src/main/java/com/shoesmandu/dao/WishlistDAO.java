package com.shoesmandu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shoesmandu.model.WishlistModel;
import com.shoesmandu.util.DBconfig;

public class WishlistDAO {

    // ADD TO WISHLIST
    public boolean addToWishlist(WishlistModel wishlist) {

        String sql = "INSERT INTO wishlist(user_id, product_id) VALUES(?,?)";

        try (Connection con = DBconfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, wishlist.getUserId());
            ps.setInt(2, wishlist.getProductId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // GET WISHLIST
    public List<WishlistModel> getWishlist(int userId) {

        List<WishlistModel> list = new ArrayList<>();

        String sql = "SELECT * FROM wishlist WHERE user_id=?";

        try (Connection con = DBconfig.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                WishlistModel w = new WishlistModel();

                w.setWishlistId(rs.getInt("wishlist_id"));
                w.setUserId(rs.getInt("user_id"));
                w.setProductId(rs.getInt("product_id"));

                list.add(w);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}