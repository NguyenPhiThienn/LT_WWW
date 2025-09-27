package iuh.fit.se.baitap1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "registerServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>Register Data</h1>");
        writer.println("<h1>First Name: " + req.getParameter("First" ) +"</h1>");
        writer.println("<h1>Last Name: " + req.getParameter("Last" ) +"</h1>");
        writer.println("<h1>Username: " + req.getParameter("Username") +"</h1>");
        writer.println("<h1>email: " + req.getParameter("email") +"</h1>");
        writer.println("<h1>Password: " + req.getParameter("Password") +"</h1>");
        writer.println("<h1>Facebook: " + req.getParameter("Facebook") +"</h1>");
        writer.println("<h1>Bio: " + req.getParameter("Bio") +"</h1>");
        writer.println("</body></html>");
        writer.close();
    }
}