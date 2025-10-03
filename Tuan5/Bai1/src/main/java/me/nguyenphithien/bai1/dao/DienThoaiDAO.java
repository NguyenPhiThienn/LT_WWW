package me.nguyenphithien.bai1.dao;

import me.nguyenphithien.bai1.entities.DienThoai;
import me.nguyenphithien.bai1.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DienThoaiDAO {
    public List<DienThoai> getByNCC(String mancc) throws Exception {
        List<DienThoai> list = new ArrayList<>();
        String sql = "SELECT * FROM DIENTHOAI WHERE MANCC = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, mancc);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DienThoai d = new DienThoai(
                            rs.getString("MADT"),
                            rs.getString("TENDT"),
                            rs.getInt("NAMSANXUAT"),
                            rs.getString("CAUHINH"),
                            rs.getString("MANCC"),
                            rs.getString("HINHANH"));
                    list.add(d);
                }
            }
        }
        return list;
    }

    public void insert(DienThoai d) throws Exception {
        String sql = "INSERT INTO DIENTHOAI (MADT,TENDT,NAMSANXUAT,CAUHINH,MANCC,HINHANH) VALUES (?,?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, d.getMadt());
            ps.setString(2, d.getTendt());
            ps.setInt(3, d.getNamSanXuat());
            ps.setString(4, d.getCauHinh());
            ps.setString(5, d.getMancc());
            ps.setString(6, d.getHinhAnh());
            ps.executeUpdate();
        }
    }

    public void delete(String madt) throws Exception {
        String sql = "DELETE FROM DIENTHOAI WHERE MADT = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, madt);
            ps.executeUpdate();
        }
    }
}
