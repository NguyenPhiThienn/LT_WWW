package iuh.fit.se.bai1.controllers;

import iuh.fit.se.bai1.daos.UserDao;
import iuh.fit.se.bai1.entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class UserController extends HttpServlet {
    private UserDao dao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String reEmail = req.getParameter("reEmail");
        String password = req.getParameter("password");
        String day = req.getParameter("day");
        String month = req.getParameter("month");
        String year = req.getParameter("year");
        String gender = req.getParameter("gender");

        // Kiểm tra email nhập lại
        if (!email.equals(reEmail)) {
            req.setAttribute("error", "Email nhập lại không khớp!");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            return;
        }

        // Birthday = yyyy-MM-dd
        String birthday = year + "-" + month + "-" + day;

        User user = new User(0, firstName, lastName, email, password, birthday, gender);

        try {
            dao.insertUser(user);
            req.setAttribute("users", dao.getAllUsers());
            req.getRequestDispatcher("success.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Lỗi khi đăng ký: " + e.getMessage());
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
