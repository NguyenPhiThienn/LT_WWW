<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Thêm điện thoại mới</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"/>
    <script>
        function validateForm() {
            const year = document.getElementById("namSanXuat").value;
            const cauHinh = document.getElementById("cauHinh").value;
            const file = document.getElementById("imageFile").value;

            const regexYear = /^[0-9]{4}$/;
            const regexCauHinh = /^.{1,255}$/;
            const regexImg = /\.(jpg|jpeg|png)$/i;

            if (!regexYear.test(year)) {
                alert("Năm sản xuất phải là số nguyên 4 chữ số!");
                return false;
            }
            if (!regexCauHinh.test(cauHinh)) {
                alert("Cấu hình không được vượt quá 255 ký tự!");
                return false;
            }
            if (file && !regexImg.test(file)) {
                alert("Hình ảnh chỉ chấp nhận định dạng JPG, JPEG, PNG!");
                return false;
            }
            return true;
        }
    </script>
</head>
<body class="container mt-4">
<h3 class="text-center fw-bold mb-4">THÊM ĐIỆN THOẠI MỚI</h3>

<form action="/dienthoai/save" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
    <div class="mb-3">
        <label class="form-label fw-semibold">Mã điện thoại</label>
        <input type="text" name="maDT" class="form-control" required>
    </div>

    <div class="mb-3">
        <label class="form-label fw-semibold">Tên điện thoại</label>
        <input type="text" name="tenDT" class="form-control" required>
    </div>

    <div class="mb-3">
        <label class="form-label fw-semibold">Năm sản xuất</label>
        <input type="text" id="namSanXuat" name="namSanXuat" class="form-control" placeholder="VD: 2023" required>
    </div>

    <div class="mb-3">
        <label class="form-label fw-semibold">Cấu hình</label>
        <textarea id="cauHinh" name="cauHinh" class="form-control" rows="3" required></textarea>
    </div>

    <div class="mb-3">
        <label class="form-label fw-semibold">Nhà cung cấp</label>
        <select name="nhaCungCap.maNCC" class="form-select" required>
            <option value="">-- Chọn nhà cung cấp --</option>
            <c:forEach var="ncc" items="${dsNCC}">
                <option value="${ncc.maNCC}">${ncc.tenNhaCC}</option>
            </c:forEach>
        </select>
    </div>

    <div class="mb-3">
        <label class="form-label fw-semibold">Hình ảnh</label>
        <input type="file" id="imageFile" name="imageFile" class="form-control" accept=".png,.jpg,.jpeg">
        <div class="form-text text-muted">Chỉ chấp nhận .png, .jpg, .jpeg</div>
    </div>

    <div class="text-end">
        <button type="submit" class="btn btn-primary">Lưu</button>
        <a href="/dienthoai" class="btn btn-secondary">Hủy</a>
    </div>
</form>
</body>
</html>