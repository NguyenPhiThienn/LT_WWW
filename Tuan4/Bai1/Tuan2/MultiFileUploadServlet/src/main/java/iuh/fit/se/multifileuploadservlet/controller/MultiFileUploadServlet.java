package iuh.fit.se.multifileuploadservlet.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet("/upload")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,      // 1MB
        maxFileSize = 1024 * 1024 * 10,       // 10MB mỗi file
        maxRequestSize = 1024 * 1024 * 50     // 50MB tổng
)

public class MultiFileUploadServlet extends HttpServlet {
    private static final String UPLOAD_PATH =
            "C:\\LT_WWW\\Tuan2\\MultiFileUploadServlet\\uploads";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String uploadPath = UPLOAD_PATH;

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            boolean created = uploadDir.mkdirs();
            if (!created) {
                throw new IOException("Không thể tạo thư mục upload: " + uploadPath);
            }
        }

        StringBuilder message = new StringBuilder("Upload complete:<br>");

        for (Part part : req.getParts()) {
            if (part.getSubmittedFileName() != null && !part.getSubmittedFileName().isEmpty()) {
                String fileName = part.getSubmittedFileName();
                String filePath = uploadPath + File.separator + fileName;
                part.write(filePath);
                message.append("Đã lưu: ").append(fileName).append("<br>");
            }
        }

        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println(message.toString());
    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        if (contentDisp == null) return null;
        for (String cd : contentDisp.split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}
