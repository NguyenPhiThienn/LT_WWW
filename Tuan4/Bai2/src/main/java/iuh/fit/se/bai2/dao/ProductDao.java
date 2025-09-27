package iuh.fit.se.bai2.dao;

import iuh.fit.se.bai2.models.Product;
import iuh.fit.se.bai2.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "select * from product";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                Product p = new Product(
                        rs.getString("id"),
                        rs.getString("model"),
                        rs.getString("description"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getString("imgURL")
                );
                list.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public Product getProductById(String id) {
        String sql = "select * from product where id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new Product(
                        rs.getString("id"),
                        rs.getString("model"),
                        rs.getString("description"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getString("imgURL")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}