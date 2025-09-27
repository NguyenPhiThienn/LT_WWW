package iuh.fit.se.bai1.controller;

import iuh.fit.se.bai1.entities.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serializable;

@WebServlet("/registration-form")
public class RegistrationForm extends HttpServlet implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet
     */
    public RegistrationForm() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Served at: ").append(req.getContextPath());

        //Get data from Form
        String fname = req.getParameter("txtFName");
        String lname = req.getParameter("txtLName");
        String day = req.getParameter("day");
        String month = req.getParameter("month");
        String year = req.getParameter("year");
        String email = req.getParameter("txtEmail");
        String mobileNumber = req.getParameter("txtMobileNumber");
        String gender = req.getParameter("gender");
        String address = req.getParameter("txtAddress");
        String city = req.getParameter("txtCity");
        String pinCode = req.getParameter("txtPinCode");
        String state = req.getParameter("txtState");
        String country = req.getParameter("txtCountry");
        String hobbies = req.getParameter("chkHobbies");
        String course = req.getParameter("txtCourse");
        String birthday = day + " " + month + " " + year;

        //Set data to student
        Student sv = new Student();
        sv.setFirstName(fname);
        sv.setLastName(lname);
        sv.setEmail(email);
        sv.setGender(gender);
        sv.setBirthday(birthday);

        //Set object student to request object
        req.setAttribute("student", sv);

        //Forward to result-form.jsp
        RequestDispatcher rd = req.getRequestDispatcher("result-form.jsp");
        rd.forward(req, resp);
    }
}
