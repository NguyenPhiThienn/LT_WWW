package iuh.fit.se.bai1.daos;

import iuh.fit.se.bai1.entities.User;
import iuh.fit.se.bai1.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public void insertUser(User user) throws Exception {
        String sql = "INSERT INTO user(first_name, last_name, email, password, birthday, gender) VALUES (?,?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setDate(5, Date.valueOf(user.getBirthday()));
            ps.setString(6, user.getGender());
            ps.executeUpdate();
        }
    }

    public List<User> getAllUsers() throws Exception {
        List<User> list = new ArrayList<>();
        String sql = "SELECT id, first_name, last_name, email, birthday, gender FROM user";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                u.setEmail(rs.getString("email"));
                u.setBirthday(rs.getString("birthday"));
                u.setGender(rs.getString("gender"));
                list.add(u);
            }
        }
        return list;
    }
}
