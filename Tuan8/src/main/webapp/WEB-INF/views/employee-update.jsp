<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
    <style>
        body { font-family: Arial, sans-serif; display: flex; justify-content: center; margin-top: 40px; }
        .container { width: 400px; border: 1px solid #ccc; padding: 30px; border-radius: 8px; }
        h2 { text-align: center; font-weight: bold; margin-bottom: 20px; }
        .form-group { margin-bottom: 12px; }
        label { display: block; margin-bottom: 4px; }
        input[type="text"], input[type="email"], input[type="date"] { width: 100%; padding: 6px; }
        .btn { padding: 8px 14px; border-radius: 4px; border: none; cursor: pointer; }
        .btn-primary { background-color: #1677ff; color: white; }
        .btn-secondary { background-color: #999; color: white; }
        .gender-group { display: flex; gap: 10px; align-items: center; }
    </style>
</head>
<body>
<div class="container">
    <h2>UPDATE EMPLOYEE</h2>
    <form:form action="${pageContext.request.contextPath}/employees/update" method="post" modelAttribute="employee">
        <form:hidden path="id"/>

        <div class="form-group">
            <label>First Name</label>
            <form:input path="firstName"/>
        </div>

        <div class="form-group">
            <label>Last Name</label>
            <form:input path="lastName"/>
        </div>

        <div class="form-group">
            <label>Email</label>
            <form:input path="email"/>
        </div>

        <div class="form-group">
            <label>Date of Birth</label>
            <form:input path="birth" type="date"/>
        </div>

        <div class="form-group">
            <label>Phone number</label>
            <form:input path="phone"/>
        </div>

        <div class="form-group">
            <label>Gender</label>
            <div class="gender-group">
                <form:radiobutton path="gender" value="Male"/> Male
                <form:radiobutton path="gender" value="Female"/> Female
            </div>
        </div>

        <div class="form-group">
            <label>Address</label>
            <form:input path="address"/>
        </div>

        <div style="text-align: center;">
            <a href="${pageContext.request.contextPath}/employees/list" class="btn btn-secondary">Back</a>
            <button type="submit" class="btn btn-primary">Register</button>
        </div>
    </form:form>
</div>
</body>
</html>
