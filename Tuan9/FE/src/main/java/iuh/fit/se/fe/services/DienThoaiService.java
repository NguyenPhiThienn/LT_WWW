package iuh.fit.se.fe.services;

import iuh.fit.se.fe.entities.DienThoai;
import java.util.List;

public interface DienThoaiService {
    List<DienThoai> findAll();
    void delete(String id);
    void save(DienThoai dienThoai);
}