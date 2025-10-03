<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm điện thoại</title>
    <script>
        function validateForm() {
            const madt = document.forms["frm"]["madt"].value.trim();
            const tendt = document.forms["frm"]["tendt"].value.trim();
            const namsx = document.forms["frm"]["namsx"].value.trim();
            const cauhinh = document.forms["frm"]["cauhinh"].value.trim();
            if (!madt || !tendt || !namsx || !cauhinh) { alert("Các trường bắt buộc chưa nhập"); return false; }
            if (!/^\d{4}$/.test(namsx)) { alert("Năm sản xuất phải là 4 chữ số"); return false; }
            if (cauhinh.length > 255) { alert("Cấu hình quá 255 kí tự"); return false; }
            const f = document.forms["frm"]["hinhAnh"].value;
            if (f) {
                const ext = f.split('.').pop().toLowerCase();
                if (!['png','jpg','jpeg'].includes(ext)) { alert("Chỉ chấp nhận png/jpg/jpeg"); return false; }
            }
            return true;
        }
    </script>
</head>
<body>
<h2>Thêm điện thoại</h2>
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<form name="frm" action="dienthoai-form" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
    Mã ĐT: <input type="text" name="madt"/><br/>
    Tên ĐT: <input type="text" name="tendt"/><br/>
    Năm SX: <input type="text" name="namsx"/><br/>
    Cấu hình: <textarea name="cauhinh" maxlength="255"></textarea><br/>
    Nhà cung cấp:
    <select name="mancc">
        <option value="">--Chọn--</option>
        <c:forEach var="n" items="${requestScope.nccList}">
            <option value="${n.mancc}">${n.tennhacc}</option>
        </c:forEach>
    </select><br/>
    Ảnh: <input type="file" name="hinhAnh" accept=".png,.jpg,.jpeg"/><br/>
    <button type="submit">Thêm</button>
</form>
</body>
</html>