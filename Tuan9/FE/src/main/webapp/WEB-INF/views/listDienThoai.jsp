<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Danh sách điện thoại</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"/>
</head>
<body class="container mt-4">

<h3 class="text-center fw-bold mb-4">DANH SÁCH ĐIỆN THOẠI</h3>

<div class="d-flex justify-content-between mb-3">
    <a href="/dienthoai/add" class="btn btn-success">➕ Thêm mới điện thoại</a>
    <a href="/nhacungcap" class="btn btn-secondary">🏢 Xem danh sách nhà cung cấp</a>
</div>

<table class="table table-bordered text-center align-middle">
    <thead class="table-light">
    <tr>
        <th>Mã ĐT</th>
        <th>Tên điện thoại</th>
        <th>Năm sản xuất</th>
        <th>Cấu hình</th>
        <th>Nhà cung cấp</th>
        <th>Hình ảnh</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="dt" items="${dsDienThoai}">
        <tr>
            <td>${dt.maDT}</td>
            <td>${dt.tenDT}</td>
            <td>${dt.namSanXuat}</td>
            <td class="text-start">${dt.cauHinh}</td>
            <td>${dt.nhaCungCap.tenNhaCC}</td>
            <td>
                <c:if test="${not empty dt.hinhAnh}">
                    <img src="/images/${dt.hinhAnh}" width="80" height="80" class="rounded"/>
                </c:if>
            </td>
            <td>
                <a href="/dienthoai/delete/${dt.maDT}"
                   class="btn btn-sm btn-outline-danger"
                   onclick="return confirm('Bạn có chắc muốn xóa điện thoại này?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${empty dsDienThoai}">
        <tr><td colspan="7" class="text-muted">Chưa có dữ liệu điện thoại</td></tr>
    </c:if>
    </tbody>
</table>

</body>
</html>