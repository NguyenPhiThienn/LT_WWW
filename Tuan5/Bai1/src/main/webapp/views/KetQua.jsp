<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><body>
<c:if test="${not empty message}">
  <p style="color:green">${message}</p>
</c:if>
<p><a href="/danh-sach">Quay về danh sách</a></p>
</body></html>