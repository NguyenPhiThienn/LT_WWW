<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; text-align: center; }
        h2 { margin-bottom: 20px; }
        table { width: 100%; border-collapse: collapse; margin-top: 15px; }
        th, td { border: 1px solid #ccc; padding: 10px; }
        th { background: #f5f5f5; }
        .top-bar { display: flex; justify-content: space-between; margin-bottom: 10px; }
        .btn { background-color: #1677ff; color: white; padding: 6px 12px; border: none; border-radius: 4px; text-decoration: none; }
        .btn:hover { background-color: #0056d2; }
        input[type="text"] { padding: 6px; width: 200px; }
    </style>
</head>
<body>
<h2>EMPLOYEE LIST</h2>

<div class="top-bar">
    <form action="${pageContext.request.contextPath}/employees/search" method="get">
        <input type="text" name="keyword" placeholder="Search"/>
        <button type="submit" class="btn">Search</button>
    </form>
    <a href="${pageContext.request.contextPath}/employees/show-form" class="btn">Add Employee</a>
</div>

<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Gender</th>
        <th>Date of birth</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Action</th>
    </tr>
    <c:forEach var="emp" items="${employees}">
        <tr>
            <td>${emp.firstName}</td>
            <td>${emp.lastName}</td>
            <td>${emp.gender}</td>
            <td>${emp.birth}</td>
            <td>${emp.email}</td>
            <td>${emp.phone}</td>
            <td>
                <a href="${pageContext.request.contextPath}/employees/show-form-update?employeeId=${emp.id}">Update</a> |
                <a href="${pageContext.request.contextPath}/employees/delete?employeeId=${emp.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
