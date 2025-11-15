package iuh.fit.se.be.controllers;

import iuh.fit.se.be.dtos.DienThoaiDTO;
import iuh.fit.se.be.services.DienThoaiService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dienthoai")
@CrossOrigin(origins = "*")
public class DienThoaiController {

    private final DienThoaiService service;

    public DienThoaiController(DienThoaiService service) {
        this.service = service;
    }

    @GetMapping
    public List<DienThoaiDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DienThoaiDTO getById(@PathVariable String id) {
        return service.findById(id);
    }

    @GetMapping("/ncc/{maNCC}")
    public List<DienThoaiDTO> getByNCC(@PathVariable String maNCC) {
        return service.findByNCC(maNCC);
    }

    @PostMapping
    public DienThoaiDTO create(@RequestBody DienThoaiDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public DienThoaiDTO update(@PathVariable String id, @RequestBody DienThoaiDTO dto) {
        dto.setMaDT(id);
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}