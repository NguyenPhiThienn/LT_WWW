package iuh.fit.se.bai2.controller;

import iuh.fit.se.bai2.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private List<User> users = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("txtFirstName");
        String lastName = req.getParameter("txtLastName");
        String email = req.getParameter("txtEmail");
        String reEmail = req.getParameter("txtReEmail");
        String password = req.getParameter("txtPassword");
        String day = req.getParameter("day");
        String month = req.getParameter("month");
        String year = req.getParameter("year");
        String birthday = day + " " + month + " " + year;
        String gender = req.getParameter("gender");

        if (!email.equals(reEmail)) {
            req.setAttribute("error", "Emails do not match!");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
            return;
        }

        User user = new User(firstName, lastName, email, password, birthday, gender);
        users.add(user);

        req.setAttribute("users", users);
        req.getRequestDispatcher("listUsers.jsp").forward(req, resp);
    }
}
