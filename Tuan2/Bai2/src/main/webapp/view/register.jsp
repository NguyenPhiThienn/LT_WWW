<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>User Registration Form</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background: #f2f2f2;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    .container {
      background: #fff;
      padding: 20px;
      border-radius: 4px;
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
      width: 300px;
    }
    h2 {
      text-align: center;
      margin-bottom: 15px;
    }
    .form-row {
      display: flex;
      gap: 5px;
      margin-bottom: 10px;
    }
    input, select {
      width: 100%;
      padding: 8px;
      border: 1px solid #ccc;
      font-size: 14px;
    }
    .birthday-row {
      display: flex;
      gap: 5px;
    }
    .gender-row {
      display: flex;
      gap: 20px;
      align-items: center; /* canh giữa theo chiều dọc */
      margin: 10px 0;
    }

    .gender-row label {
      display: flex;
      align-items: center;
      gap: 5px; /* khoảng cách giữa nút và chữ */
      cursor: pointer;
    }

    .btn {
      background: #1d5bbf;
      color: white;
      padding: 10px;
      width: 100%;
      border: none;
      cursor: pointer;
      font-size: 16px;
    }
    .btn:hover {
      background: #144a94;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>User Registration Form</h2>
  <form action="register" method="post">

    <!-- First & Last Name -->
    <div class="form-row">
      <input type="text" name="txtFirstName" placeholder="First Name" required>
      <input type="text" name="txtLastName" placeholder="Last Name" required>
    </div>

    <!-- Email -->
    <input type="email" name="txtEmail" placeholder="Your Email" required style="margin-bottom:10px;">

    <!-- Re-enter Email -->
    <input type="email" name="txtReEmail" placeholder="Re-enter Email" required style="margin-bottom:10px;">

    <!-- Password -->
    <input type="password" name="txtPassword" placeholder="New Password" required style="margin-bottom:10px;">

    <!-- Birthday -->
    <label>Birthday</label>
    <div class="birthday-row">
      <select name="month" required>
        <option value="">Month</option>
        <% for(int i=1;i<=12;i++){ %>
        <option value="<%=i%>"><%=i%></option>
        <% } %>
      </select>
      <select name="day" required>
        <option value="">Day</option>
        <% for(int i=1;i<=31;i++){ %>
        <option value="<%=i%>"><%=i%></option>
        <% } %>
      </select>
      <select name="year" required>
        <option value="">Year</option>
        <% for(int i=1950;i<=2025;i++){ %>
        <option value="<%=i%>"><%=i%></option>
        <% } %>
      </select>
    </div>

    <!-- Gender -->
    <div class="gender-row">
      <label><input type="radio" name="gender" value="Female" required> Female</label>
      <label><input type="radio" name="gender" value="Male" required> Male</label>
    </div>


    <!-- Submit -->
    <button type="submit" class="btn">Sign Up</button>
  </form>
</div>
</body>
</html>
