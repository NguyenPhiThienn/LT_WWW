package iuh.fit.se.baitap1;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.*;

@WebServlet(name = "indexServlet", value = "/index-servlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Index Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Welcome to Index Servlet</h1>");
        out.println("<p>This is a response in text/html format.</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
