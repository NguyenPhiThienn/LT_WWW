package iuh.fit.se.be.dtos;

public class NhaCungCapDTO {
    private String maNCC;
    private String tenNhaCC;
    private String diaChi;
    private String soDienThoai;

    public NhaCungCapDTO() {
    }

    public NhaCungCapDTO(String maNCC, String tenNhaCC, String diaChi, String soDienThoai) {
        this.maNCC = maNCC;
        this.tenNhaCC = tenNhaCC;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
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
}