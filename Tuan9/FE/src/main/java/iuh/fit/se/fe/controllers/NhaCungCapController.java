package iuh.fit.se.fe.controllers;

import iuh.fit.se.fe.entities.NhaCungCap;
import iuh.fit.se.fe.services.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/nhacungcap")
public class NhaCungCapController {

    private final NhaCungCapService nhaCungCapService;

    @Autowired
    public NhaCungCapController(NhaCungCapService nhaCungCapService) {
        this.nhaCungCapService = nhaCungCapService;
    }

    @GetMapping
    public ModelAndView list(@RequestParam(value = "keyword", required = false) String keyword) {
        List<NhaCungCap> dsNCC = (keyword != null && !keyword.isEmpty())
                ? nhaCungCapService.search(keyword)
                : nhaCungCapService.findAll();

        ModelAndView mv = new ModelAndView("listNCC");
        mv.addObject("dsNCC", dsNCC);
        mv.addObject("keyword", keyword);
        return mv;
    }
}