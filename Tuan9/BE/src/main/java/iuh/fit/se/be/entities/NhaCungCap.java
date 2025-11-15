package iuh.fit.se.be.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "nhacungcap")
public class NhaCungCap {
    @Id
    @Column(length = 10)
    private String maNCC;

    private String tenNhaCC;
    private String diaChi;
    private String soDienThoai;

    @OneToMany(mappedBy = "nhaCungCap", cascade = CascadeType.ALL)
    private List<DienThoai> dienThoais;

    public NhaCungCap() {
    }

    public NhaCungCap(String maNCC, String tenNhaCC, String diaChi, String soDienThoai, List<DienThoai> dienThoais) {
        this.maNCC = maNCC;
        this.tenNhaCC = tenNhaCC;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.dienThoais = dienThoais;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public String getTenNhaCC() {
        return tenNhaCC;
    }

    public void setTenNhaCC(String tenNhaCC) {
        this.tenNhaCC = tenNhaCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public List<DienThoai> getDienThoais() {
        return dienThoais;
    }

    public void setDienThoais(List<DienThoai> dienThoais) {
        this.dienThoais = dienThoais;
    }
}