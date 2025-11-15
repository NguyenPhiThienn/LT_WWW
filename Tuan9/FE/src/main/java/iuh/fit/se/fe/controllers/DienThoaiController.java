package iuh.fit.se.fe.controllers;

import iuh.fit.se.fe.entities.DienThoai;
import iuh.fit.se.fe.entities.NhaCungCap;
import iuh.fit.se.fe.services.DienThoaiService;
import iuh.fit.se.fe.services.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

@Controller
@RequestMapping("/dienthoai")
public class DienThoaiController {

    private final DienThoaiService dienThoaiService;
    private final NhaCungCapService nhaCungCapService;

    @Autowired
    public DienThoaiController(DienThoaiService dienThoaiService, NhaCungCapService nhaCungCapService) {
        this.dienThoaiService = dienThoaiService;
        this.nhaCungCapService = nhaCungCapService;
    }

    @GetMapping
    public ModelAndView list() {
        List<DienThoai> dsDienThoai = dienThoaiService.findAll();
        ModelAndView mv = new ModelAndView("listDienThoai");
        mv.addObject("dsDienThoai", dsDienThoai);
        return mv;
    }

    @GetMapping("/add")
    public ModelAndView addForm() {
        ModelAndView mv = new ModelAndView("addDienThoai");
        mv.addObject("dienThoai", new DienThoai());
        mv.addObject("dsNCC", nhaCungCapService.findAll());
        return mv;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute DienThoai dt,
                       @RequestParam("imageFile") MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            String filename = file.getOriginalFilename();
            Path uploadDir = Paths.get("src/main/webapp/images");
            if (!Files.exists(uploadDir)) Files.createDirectories(uploadDir);
            Files.copy(file.getInputStream(), uploadDir.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
            dt.setHinhAnh(filename);
        }

        dienThoaiService.save(dt);
        return "redirect:/dienthoai";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        dienThoaiService.delete(id);
        return "redirect:/dienthoai";
    }
}