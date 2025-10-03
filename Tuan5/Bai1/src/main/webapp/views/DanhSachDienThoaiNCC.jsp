<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Danh sách điện thoại</title></head>
<body>
<h2>Danh sách điện thoại theo nhà cung cấp</h2>

<form method="get" action="danh-sach">
  <label>Chọn NCC:
    <select name="mancc">
      <option value="">--Chọn--</option>
      <c:forEach var="n" items="${nccList}">
        <option value="${n.mancc}" ${param.mancc == n.mancc ? 'selected' : ''}>${n.tennhacc}</option>
      </c:forEach>
    </select>
  </label>
  <button type="submit">Xem</button>
</form>

<form method="get" action="danh-sach">
  <input type="text" name="q" placeholder="Tìm NCC..." value="${param.q}"/>
  <button type="submit">Tìm</button>
</form>

<c:if test="${not empty dienThoaiList}">
  <table border="1">
    <tr><th>Mã</th><th>Tên</th><th>Năm</th><th>Cấu hình</th><th>Ảnh</th><th>Hành động</th></tr>
    <c:forEach var="dt" items="${dienThoaiList}">
      <tr>
        <td>${dt.madt}</td>
        <td>${dt.tendt}</td>
        <td>${dt.namSanXuat}</td>
        <td>${dt.cauHinh}</td>
        <td>
          <c:if test="${not empty dt.hinhAnh}">
            <img src="${pageContext.request.contextPath}/${dt.hinhAnh}" width="100"/>
          </c:if>
        </td>
        <td>
          <form action="quan-ly" method="post" onsubmit="return confirm('Bạn chắc chứ?');">
            <input type="hidden" name="madt" value="${dt.madt}"/>
            <button type="submit">Xóa</button>
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
</c:if>

<p><a href="dienthoai-form">Thêm điện thoại mới</a></p>

</body>
</html>