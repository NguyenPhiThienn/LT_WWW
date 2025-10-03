package me.nguyenphithien.bai1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import me.nguyenphithien.bai1.dao.DienThoaiDAO;
import me.nguyenphithien.bai1.entities.DienThoai;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@WebServlet("/dienthoai-form")
@MultipartConfig(fileSizeThreshold = 1024*1024, // 1MB
        maxFileSize = 5*1024*1024,      // 5MB
        maxRequestSize = 20*1024*1024)
public class DienThoaiFormServlet extends HttpServlet {
    private DienThoaiDAO dao = new DienThoaiDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/DienThoaiForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");

            String madt = req.getParameter("madt");
            String tendt = req.getParameter("tendt");
            String namStr = req.getParameter("namsx");
            String cauhinh = req.getParameter("cauhinh");
            String mancc = req.getParameter("mancc");

            String error = null;
            if (madt == null || madt.isBlank() || tendt == null || tendt.isBlank() || namStr == null || namStr.isBlank() || cauhinh == null || cauhinh.isBlank()) {
                error = "Các trường bắt buộc chưa nhập.";
            }
            if (error == null) {
                if (!namStr.matches("\\d{4}")) error = "Năm sản xuất phải là 4 chữ số.";
                if (cauhinh.length() > 255) error = "Thông tin cấu hình quá 255 ký tự.";
            }

            Part filePart = req.getPart("hinhAnh");
            String fileName = null;
            if (filePart != null && filePart.getSize() > 0) {
                String submitted = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                String ext = submitted.substring(submitted.lastIndexOf('.')+1).toLowerCase();
                if (!ext.matches("png|jpg|jpeg")) {
                    error = "Chỉ chấp nhận file png/jpg/jpeg.";
                } else {
                    // lưu file vào folder uploads trong webapp
                    String uploadsPath = req.getServletContext().getRealPath("") + File.separator + "uploads";
                    Files.createDirectories(Paths.get(uploadsPath));
                    fileName = madt + "_" + System.currentTimeMillis() + "." + ext;
                    Path filePath = Paths.get(uploadsPath, fileName);
                    try (InputStream in = filePart.getInputStream()) {
                        Files.copy(in, filePath, StandardCopyOption.REPLACE_EXISTING);
                    }
                }
            }

            if (error != null) {
                req.setAttribute("error", error);
                req.getRequestDispatcher("/views/DienThoaiForm.jsp").forward(req, resp);
                return;
            }

            int namsx = Integer.parseInt(namStr);
            String hinh = (fileName != null) ? "uploads/" + fileName : null;

            DienThoai d = new DienThoai(madt, tendt, namsx, cauhinh, mancc, hinh);
            dao.insert(d);

            req.setAttribute("message", "Thêm điện thoại thành công.");
            req.getRequestDispatcher("/views/KetQua.jsp").forward(req, resp);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
