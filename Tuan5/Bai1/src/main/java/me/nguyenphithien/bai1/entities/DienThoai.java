package me.nguyenphithien.bai1.entities;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DienThoai {
    private String madt;
    private String tendt;
    private int namSanXuat;
    private String cauHinh;
    private String mancc;
    private String hinhAnh;
}
