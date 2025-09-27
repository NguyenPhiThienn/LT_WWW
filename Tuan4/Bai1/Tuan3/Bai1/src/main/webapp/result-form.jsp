<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07/09/2025
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="iuh.fit.se.bai1.entities.Student" %>

<html>
<head>
    <title>Result Submit</title>
</head>
<body>
<%
    Student student = new Student();
    student = (Student)request.getAttribute("student");
    out.println(
            "First name: " + student.getFirstName()
                    + "<br/> Last name: " + student.getLastName()
                    + "<br/> Email: " + student.getEmail()
                    + "<br/> Gender: " + student.getGender()
                    + "<br/> Birthday: " + student.getBirthday()
    );
%>
</body>
</html>
