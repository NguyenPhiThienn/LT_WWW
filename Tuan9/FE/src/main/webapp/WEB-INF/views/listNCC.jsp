<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Danh sách nhà cung cấp</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"/>
</head>
<body class="container mt-4">
<h3 class="text-center fw-bold">DANH SÁCH NHÀ CUNG CẤP</h3>

<form method="get" action="/nhacungcap" class="d-flex mb-3">
    <input type="text" name="keyword" value="${keyword}" class="form-control me-2"
           placeholder="Nhập mã, tên, địa chỉ hoặc SĐT...">
    <button class="btn btn-secondary">Tìm kiếm</button>
</form>

<table class="table table-bordered text-center align-middle">
    <thead class="table-light">
    <tr>
        <th>Mã NCC</th>
        <th>Tên nhà cung cấp</th>
        <th>Địa chỉ</th>
        <th>Số điện thoại</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ncc" items="${dsNCC}">
        <tr>
            <td>${ncc.maNCC}</td>
            <td>${ncc.tenNhaCC}</td>
            <td>${ncc.diaChi}</td>
            <td>${ncc.soDienThoai}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/dienthoai" class="btn btn-primary">Xem danh sách điện thoại</a>
</body>
</html>