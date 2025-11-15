package iuh.fit.se.be.services.impl;

import iuh.fit.se.be.dtos.DienThoaiDTO;
import iuh.fit.se.be.entities.DienThoai;
import iuh.fit.se.be.mappers.DienThoaiMapper;
import iuh.fit.se.be.repositories.DienThoaiRepository;
import iuh.fit.se.be.services.DienThoaiService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DienThoaiServiceImpl implements DienThoaiService {

    private final DienThoaiRepository repo;
    private final DienThoaiMapper mapper;

    public DienThoaiServiceImpl(DienThoaiRepository repo, DienThoaiMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public List<DienThoaiDTO> findAll() {
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<DienThoaiDTO> findByNCC(String maNCC) {
        return repo.findByNhaCungCap_MaNCC(maNCC).stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public DienThoaiDTO findById(String id) {
        return repo.findById(id).map(mapper::toDTO).orElse(null);
    }

    @Override
    public DienThoaiDTO save(DienThoaiDTO dto) {
        DienThoai entity = mapper.toEntity(dto);
        return mapper.toDTO(repo.save(entity));
    }

    @Override
    public void delete(String id) {
        repo.deleteById(id);
    }
}