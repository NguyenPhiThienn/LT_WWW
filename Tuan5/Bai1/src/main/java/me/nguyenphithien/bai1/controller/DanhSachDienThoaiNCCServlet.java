package me.nguyenphithien.bai1.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.nguyenphithien.bai1.dao.DienThoaiDAO;
import me.nguyenphithien.bai1.dao.NhaCungCapDAO;
import me.nguyenphithien.bai1.entities.DienThoai;

import java.io.IOException;
import java.util.List;

@WebServlet("/danh-sach")
public class DanhSachDienThoaiNCCServlet extends HttpServlet {
    private NhaCungCapDAO nccDao = new NhaCungCapDAO();
    private DienThoaiDAO dtDao = new DienThoaiDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action = req.getParameter("action");
            String mancc = req.getParameter("mancc");
            String q = req.getParameter("q");

            req.setAttribute("nccList", nccDao.findAll());

            if (q != null && !q.trim().isEmpty()) {
                req.setAttribute("nccSearch", nccDao.search(q));
            }

            if (mancc != null && !mancc.isEmpty()) {
                List<DienThoai> ds = dtDao.getByNCC(mancc);
                req.setAttribute("dienThoaiList", ds);
            }

            req.getRequestDispatcher("/views/DanhSachDienThoaiNCC.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
