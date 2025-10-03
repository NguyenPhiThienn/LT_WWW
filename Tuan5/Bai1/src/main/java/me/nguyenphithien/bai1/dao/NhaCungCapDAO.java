package me.nguyenphithien.bai1.dao;

import me.nguyenphithien.bai1.entities.NhaCungCap;
import me.nguyenphithien.bai1.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAO {
    public List<NhaCungCap> search(String keyword) throws Exception {
        List<NhaCungCap> list = new ArrayList<>();
        String sql = "SELECT * FROM NHACUNGCAP WHERE MANCC LIKE ? OR TENNHACC LIKE ? OR DIACHI LIKE ? OR SODIENTHOAI LIKE ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            String k = "%" + (keyword == null ? "" : keyword) + "%";
            for (int i = 1; i <= 4; i++) ps.setString(i, k);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new NhaCungCap(rs.getString("MANCC"), rs.getString("TENNHACC"), rs.getString("DIACHI"), rs.getString("SODIENTHOAI")));
                }
            }
        }
        return list;
    }

    public List<NhaCungCap> findAll() throws Exception {
        List<NhaCungCap> list = new ArrayList<>();
        String sql = "SELECT * FROM NHACUNGCAP";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new NhaCungCap(rs.getString("MANCC"), rs.getString("TENNHACC"), rs.getString("DIACHI"), rs.getString("SODIENTHOAI")));
            }
        }
        return list;
    }
}