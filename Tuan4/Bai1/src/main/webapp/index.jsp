<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27/09/2025
  Time: 5:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Register</title></head>
<body>
<h2>Đăng ký tài khoản</h2>

<form action="register" method="post">
  First name: <input type="text" name="firstName" required><br>
  Last name: <input type="text" name="lastName" required><br>
  Your Email: <input type="email" name="email" required><br>
  Re-enter Email: <input type="email" name="reEmail" required><br>
  New Password: <input type="password" name="password" required><br>

  Birthday:
  <select name="day"><% for(int i=1;i<=31;i++){ %><option><%=i%></option><% } %></select>
  <select name="month"><% for(int i=1;i<=12;i++){ %><option><%=i%></option><% } %></select>
  <select name="year"><% for(int i=1950;i<=2025;i++){ %><option><%=i%></option><% } %></select>
  <br>

  Gender:
  <input type="radio" name="gender" value="Male" required> Male
  <input type="radio" name="gender" value="Female" required> Female
  <br><br>

  <button type="submit">Đăng ký</button>
</form>

<form action="listUsers" method="get">
  <button type="submit">Xem danh sách</button>
</form>

<% String error = (String) request.getAttribute("error");
  if (error != null) { %>
<p style="color:red;"><%=error%></p>
<% } %>
</body>
</html>
