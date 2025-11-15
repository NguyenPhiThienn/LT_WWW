package iuh.fit.se.be.services;

import iuh.fit.se.be.dtos.NhaCungCapDTO;

import java.util.List;

public interface NhaCungCapService {
    List<NhaCungCapDTO> findAll();
    List<NhaCungCapDTO> search(String keyword);
    NhaCungCapDTO findById(String id);
}