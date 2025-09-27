<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Registration Form</title>
  <style>
    body {
      background-color: #ffffff;
      font-family: Arial, sans-serif;
    }

    form {
      background-color: #e6faff;
      border: 1px solid #0099cc;
      padding: 20px;
      width: 800px;
      margin: 30px auto;
      box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
    }

    table {
      width: 100%;
      border-collapse: collapse;
    }

    td {
      padding: 5px;
      vertical-align: middle;
    }

    input[type="text"], input[type="email"], select, textarea {
      padding: 4px;
      border: 1px solid #999;
      border-radius: 0;
      width: 180px;
    }

    select {
      width: auto;
    }

    textarea {
      resize: none;
      width: 180px;
    }

    input[type="radio"], input[type="checkbox"] {
      margin-right: 3px;
    }


    .qual-table {
      width: 100%;
      border: 1px solid #0066cc;
      margin-top: 5px;
    }

    .qual-table th, .qual-table td {
      border: 1px solid #0066cc;
      padding: 4px;
      text-align: center;
    }

    .qual-table input {
      width: 95%;
      padding: 3px;
      border: 1px solid #999;
      border-radius: 0;
    }


    input[type="submit"], input[type="reset"] {
      padding: 6px 15px;
      background-color: #00aaff;
      color: white;
      border: none;
      cursor: pointer;
      margin: 5px;
    }

    input[type="submit"]:hover, input[type="reset"]:hover {
      background-color: #0088cc;
    }


    .note {
      margin-left: 5px;
      font-size: 12px;
      color: #333;
    }
  </style>
</head>
<body>
<form action="registration-form" name="formDangKy" method="GET">
  <table>
    <tr>
      <td>First Name:</td>
      <td>
        <input type="text" name="txtFName" required>
        <span class="note">(max 30 characters a-z and A-Z)</span>
      </td>
    </tr>
    <tr>
      <td>Last Name:</td>
      <td>
        <input type="text" name="txtLName" required>
        <span class="note">(max 30 characters a-z and A-Z)</span>
      </td>
    </tr>
    <tr>
      <td>Date of Birth:</td>
      <td>
        <select name="day">
          <option value="" selected disabled>Day</option>
          <% for (int i = 1; i <= 31; i++) { %>
          <option value="<%=i%>"><%=i%></option>
          <% } %>
        </select>
        <select name="month">
          <option value="" selected disabled>Month</option>
          <option>Jan</option><option>Feb</option><option>Mar</option>
          <option>Apr</option><option>May</option><option>Jun</option>
          <option>Jul</option><option>Aug</option><option>Sep</option>
          <option>Oct</option><option>Nov</option><option>Dec</option>
        </select>
        <select name="year">
          <option value="" selected disabled>Year</option>
          <% for (int i = 1980; i <= 2025; i++) { %>
          <option value="<%=i%>"><%=i%></option>
          <% } %>
        </select>
      </td>
    </tr>
    <tr>
      <td>Email:</td>
      <td><input type="email" name="txtEmail" required></td>
    </tr>
    <tr>
      <td>Mobile number:</td>
      <td>
        <input type="text" name="txtMobileNumber">
        <span class="note">(10 digit number)</span>
      </td>
    </tr>
    <tr>
      <td>Gender:</td>
      <td>
        <input type="radio" name="gender" value="Male"> Male
        <input type="radio" name="gender" value="Female"> Female
      </td>
    </tr>
    <tr>
      <td>Address:</td>
      <td><textarea name="txtAddress" rows="3"></textarea></td>
    </tr>
    <tr>
      <td>City:</td>
      <td>
        <input type="text" name="txtCity">
        <span class="note">(max 30 characters a-z and A-Z)</span>
      </td>
    </tr>
    <tr>
      <td>Pin code:</td>
      <td>
        <input type="text" name="txtPinCode">
        <span class="note">(6 digit number)</span>
      </td>
    </tr>
    <tr>
      <td>State:</td>
      <td>
        <input type="text" name="txtState">
        <span class="note">(max 30 characters a-z and A-Z)</span>
      </td>
    </tr>
    <tr>
      <td>Country:</td>
      <td><input type="text" name="txtCountry" value="Viet Nam"></td>
    </tr>
    <tr>
      <td>Hobbies:</td>
      <td>
        <input type="checkbox" name="chkHobbies" value="Drawing"> Drawing
        <input type="checkbox" name="chkHobbies" value="Singing"> Singing
        <input type="checkbox" name="chkHobbies" value="Dancing"> Dancing
        <input type="checkbox" name="chkHobbies" value="Sketching"> Sketching
        <input type="checkbox" name="chkHobbies" value="Others"> Others
        <input type="text" name="hobbyOthers">
      </td>
    </tr>
    <tr>
      <td>Qualification:</td>
      <td>
        <table class="qual-table">
          <tr>
            <th>Sl.No.</th>
            <th>Examination</th>
            <th>Board</th>
            <th>Percentage</th>
            <th>Year of Passing</th>
          </tr>
          <tr>
            <td>1</td><td>Class X</td>
            <td><input type="text" maxlength="10"></td>
            <td><input type="text" maxlength="5"></td>
            <td><input type="text" maxlength="4"></td>
          </tr>
          <tr>
            <td>2</td><td>Class XII</td>
            <td><input type="text" maxlength="10"></td>
            <td><input type="text" maxlength="5"></td>
            <td><input type="text" maxlength="4"></td>
          </tr>
          <tr>
            <td>3</td><td>Graduation</td>
            <td><input type="text" maxlength="10"></td>
            <td><input type="text" maxlength="5"></td>
            <td><input type="text" maxlength="4"></td>
          </tr>
          <tr>
            <td>4</td><td>Masters</td>
            <td><input type="text" maxlength="10"></td>
            <td><input type="text" maxlength="5"></td>
            <td><input type="text" maxlength="4"></td>
          </tr>
        </table>
      </td>
    </tr>
    <tr>
      <td>Course applies for:</td>
      <td>
        <input type="radio" name="txtCourse" value="BCA"> BCA
        <input type="radio" name="txtCourse" value="B.Com"> B.Com
        <input type="radio" name="txtCourse" value="B.Sc"> B.Sc
        <input type="radio" name="txtCourse" value="B.A"> B.A
      </td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
      </td>
    </tr>
  </table>
</form>
</body>
</html>
