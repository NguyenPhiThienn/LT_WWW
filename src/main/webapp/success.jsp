<%@ page import="java.util.List" %>
<%@ page import="iuh.fit.se.bai1.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Danh sách User</title></head>
<body>
<h2>Danh sách tài khoản</h2>
<table border="1">
  <tr>
    <th>ID</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Birthday</th><th>Gender</th>
  </tr>
  <%
    List<User> users = (List<User>) request.getAttribute("users");
    if (users != null) {
      for (User u : users) {
  %>
  <tr>
    <td><%=u.getId()%></td>
    <td><%=u.getFirstName()%></td>
    <td><%=u.getLastName()%></td>
    <td><%=u.getEmail()%></td>
    <td><%=u.getBirthday()%></td>
    <td><%=u.getGender()%></td>
  </tr>
  <% } } %>
</table>
</body>
</html>
