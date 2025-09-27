package iuh.fit.se.bai2.controller;

import iuh.fit.se.bai2.dao.ProductDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/DSSP")
public class ProductListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductDao dao = new ProductDao();
        req.setAttribute("ds", dao.getAllProducts());

        RequestDispatcher rd = req.getRequestDispatcher("ModelList.jsp");
        rd.forward(req, resp);
    }
}