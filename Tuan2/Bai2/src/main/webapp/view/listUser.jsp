<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 07/09/2025
  Time: 9:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<h2>Registered Users</h2>
<table border="1" cellpadding="5">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Birthday</th>
        <th>Gender</th>
    </tr>
    <c:forEach var="u" items="${users}">
        <tr>
            <td>${u.firstName}</td>
            <td>${u.lastName}</td>
            <td>${u.email}</td>
            <td>${u.birthday}</td>
            <td>${u.gender}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
