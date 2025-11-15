package iuh.fit.se.fe.services;

import iuh.fit.se.fe.entities.NhaCungCap;
import java.util.List;

public interface NhaCungCapService {
    List<NhaCungCap> findAll();
    List<NhaCungCap> search(String keyword);
}