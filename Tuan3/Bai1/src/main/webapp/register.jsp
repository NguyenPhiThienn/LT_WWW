<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #a9e0f0;
        }
        .container {
            width: 700px;
            margin: 20px auto;
            background: #c2ebf7;
            padding: 20px;
            border-radius: 10px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        td {
            padding: 8px;
        }
        input[type="text"], input[type="email"], input[type="number"], textarea, select {
            width: 90%;
            padding: 6px;
        }
        textarea {
            height: 60px;
        }
        .buttons {
            text-align: center;
            margin-top: 15px;
        }
        .buttons input {
            padding: 8px 20px;
            margin: 5px;
        }
        .qualification {
            border: 2px solid #666;
            margin-top: 15px;
            padding: 10px;
        }
        .qualification table, .qualification th, .qualification td {
            border: 1px solid #666;
        }
        .qualification th, .qualification td {
            padding: 5px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <form>
        <table>
            <tr>
                <td>First name</td>
                <td><input type="text" name="fname" maxlength="30">(max 30 characters a-z and A-Z)</td>
            </tr>
            <tr>
                <td>Last name</td>
                <td><input type="text" name="lname" maxlength="30">(max 30 characters a-z and A-Z)</td>
            </tr>
            <tr>
                <td>Date of Birth</td>
                <td>
                    <select name="day">
                        <option>Day:</option>
                        <!-- loop days -->
                        <script>
                            for (let i=1;i<=31;i++) {
                                document.write('<option>'+i+'</option>');
                            }
                        </script>
                    </select>
                    <select name="month">
                        <option>Month:</option>
                        <option>Jan</option><option>Feb</option><option>Mar</option>
                        <option>Apr</option><option>May</option><option>Jun</option>
                        <option>Jul</option><option>Aug</option><option>Sep</option>
                        <option>Oct</option><option>Nov</option><option>Dec</option>
                    </select>
                    <select name="year">
                        <option>Year:</option>
                        <script>
                            for (let y=1980;y<=2025;y++) {
                                document.write('<option>'+y+'</option>');
                            }
                        </script>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="email" name="email"></td>
            </tr>
            <tr>
                <td>Mobile Number</td>
                <td><input type="text" name="mobile" maxlength="10">(10 digit number)</td>
            </tr>
            <tr>
                <td>Gender</td>
                <td>
                    <input type="radio" name="gender" value="male">Male
                    <input type="radio" name="gender" value="female">Female
                </td>
            </tr>
            <tr>
                <td>Address</td>
                <td><textarea name="address"></textarea></td>
            </tr>
            <tr>
                <td>City</td>
                <td><input type="text" name="city" maxlength="30">(max 30 characters a-z and A-Z)</td>
            </tr>
            <tr>
                <td>Pin Code</td>
                <td><input type="text" name="pincode" maxlength="6">(6 digit number)</td>
            </tr>
            <tr>
                <td>State</td>
                <td><input type="text" name="state" maxlength="30">(max 30 characters a-z and A-Z)</td>
            </tr>
            <tr>
                <td>Country</td>
                <td><input type="text" value="India" readonly></td>
            </tr>
            <tr>
                <td>Hobbies</td>
                <td>
                    <input type="checkbox" name="hobbies" value="drawing">Drawing
                    <input type="checkbox" name="hobbies" value="singing">Singing
                    <input type="checkbox" name="hobbies" value="dancing">Dancing
                    <input type="checkbox" name="hobbies" value="sketching">Sketching
                    <input type="checkbox" name="hobbies" value="others">Others
                    <input type="text" name="other_hobby">
                </td>
            </tr>
        </table>

        <div class="qualification">
            <table>
                <tr>
                    <th>Sl.No.</th>
                    <th>Examination</th>
                    <th>Board</th>
                    <th>Percentage</th>
                    <th>Year of Passing</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>Class X</td>
                    <td><input type="text"></td>
                    <td><input type="text"></td>
                    <td><input type="text"></td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Class XII</td>
                    <td><input type="text"></td>
                    <td><input type="text"></td>
                    <td><input type="text"></td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Graduation</td>
                    <td><input type="text"></td>
                    <td><input type="text"></td>
                    <td><input type="text"></td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>Masters</td>
                    <td><input type="text"></td>
                    <td><input type="text"></td>
                    <td><input type="text"></td>
                </tr>
            </table>
        </div>

        <table>
            <tr>
                <td>Course applies for</td>
                <td>
                    <input type="radio" name="course" value="BCA">BCA
                    <input type="radio" name="course" value="B.Com">B.Com
                    <input type="radio" name="course" value="B.Sc">B.Sc
                    <input type="radio" name="course" value="BA">B.A
                </td>
            </tr>
        </table>

        <div class="buttons">
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </div>
    </form>
</div>
</body>
</html>

