<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"/>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">QUẢN LÝ ĐIỆN THOẠI</a>
        <div class="navbar-nav">
            <a class="nav-link" href="/nhacungcap">Nhà cung cấp</a>
            <a class="nav-link" href="/dienthoai">Điện thoại</a>
        </div>
    </div>
</nav>
<div class="container mt-4">
    <jsp:include page="${bodyPage}" />
</div>
</body>
</html>