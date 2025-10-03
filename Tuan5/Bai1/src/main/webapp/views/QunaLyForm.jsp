<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Quản lý điện thoại</title>
  <style>
    table { border-collapse: collapse; width: 100%; }
    th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
    th { background:#f5f5f5; }
    img { max-width:120px; max-height:80px; }
    .actions { white-space:nowrap; }
    .msg { padding:8px; margin-bottom:10px; border-radius:4px; }
    .msg-success { background:#e6ffed; color:#065f2d; }
    .msg-error { background:#ffe6e6; color:#8b0d0d; }
  </style>

  <script>
    // toggle tất cả checkbox
    function toggleAll(source) {
      const checks = document.querySelectorAll('input[type="checkbox"][data-role="chk-item"]');
      checks.forEach(c => c.checked = source.checked);
    }

    // gửi bulk delete: tạo form tạm thời và submit
    function submitBulkDelete() {
      const checks = Array.from(document.querySelectorAll('input[type="checkbox"][data-role="chk-item"]:checked'));
      if (checks.length === 0) {
        alert('Vui lòng chọn ít nhất 1 mục để xóa.');
        return;
      }
      if (!confirm('Bạn chắc chắn muốn xóa ' + checks.length + ' mục đã chọn?')) return;

      // tạo form tạm
      const form = document.createElement('form');
      form.method = 'post';
      form.action = '${pageContext.request.contextPath}/quan-ly';

      // thêm inputs cho mỗi madt
      checks.forEach(chk => {
        const input = document.createElement('input');
        input.type = 'hidden';
        input.name = 'madt'; // gửi nhiều tham số cùng tên
        input.value = chk.value;
        form.appendChild(input);
      });

      document.body.appendChild(form);
      form.submit();
    }
  </script>
</head>
<body>
<h2>Quản lý điện thoại</h2>

<c:if test="${not empty message}">
  <div class="msg msg-success">${message}</div>
</c:if>
<c:if test="${not empty error}">
  <div class="msg msg-error">${error}</div>
</c:if>

<p>
  <a href="${pageContext.request.contextPath}/danh-sach">Về danh sách</a> |
  <a href="${pageContext.request.contextPath}/dienthoai-form">Thêm điện thoại mới</a>
</p>

<table>
  <thead>
  <tr>
    <th><input type="checkbox" onclick="toggleAll(this)" title="Chọn tất cả"></th>
    <th>Mã ĐT</th>
    <th>Tên</th>
    <th>Năm SX</th>
    <th>Cấu hình</th>
    <th>Nhà cung cấp</th>
    <th>Ảnh</th>
    <th>Hành động</th>
  </tr>
  </thead>
  <tbody>
  <c:choose>
    <c:when test="${not empty dienThoaiList}">
      <c:forEach var="dt" items="${dienThoaiList}">
        <tr>
          <td><input type="checkbox" data-role="chk-item" value="${dt.madt}"></td>
          <td>${dt.madt}</td>
          <td>${dt.tendt}</td>
          <td>${dt.namSanXuat}</td>
          <td><c:out value="${dt.cauHinh}" /></td>
          <td><c:out value="${dt.mancc}" /></td>
          <td>
            <c:if test="${not empty dt.hinhAnh}">
              <img src="${pageContext.request.contextPath}/${dt.hinhAnh}" alt="${dt.tendt}" />
            </c:if>
          </td>
          <td class="actions">
            <!-- Form xóa từng bản ghi (mỗi form riêng, tránh nested form) -->
            <form action="${pageContext.request.contextPath}/quan-ly" method="post" onsubmit="return confirm('Bạn có chắc muốn xóa ${dt.madt} ?');" style="display:inline">
              <input type="hidden" name="madt" value="${dt.madt}" />
              <button type="submit">Xóa</button>
            </form>
            &nbsp;
            <!-- Bạn có thể thêm nút sửa ở đây nếu cần -->
            <!-- <a href="sua?madt=${dt.madt}">Sửa</a> -->
          </td>
        </tr>
      </c:forEach>
    </c:when>
    <c:otherwise>
      <tr><td colspan="8">Không có bản ghi nào.</td></tr>
    </c:otherwise>
  </c:choose>
  </tbody>
</table>

<p style="margin-top:10px;">
  <button type="button" onclick="submitBulkDelete()">Xóa đã chọn</button>
</p>

</body>
</html>