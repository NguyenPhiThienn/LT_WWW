package fit.se.filterdemo;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class AuthenticationFilter extends HttpFilter implements Filter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String username = this.getFilterConfig().getInitParameter("username");
        String password = this.getFilterConfig().getInitParameter("password");

        String usernameFilter = req.getParameter("username");
        String passwordFilter = req.getParameter("password");

        PrintWriter writer = res.getWriter();
        if (username.equals(usernameFilter) && password.equals(passwordFilter)){
            writer.println("Nhap dung thong tin!");
            writer.close();
        } else {
            writer.println("Nhap sai thong tin!!!!");
            writer.close();
        }
    }
}
