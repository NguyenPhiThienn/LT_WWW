<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Upload Multiple Files</title>
</head>
<body>
<h2>Upload Multiple Files</h2>
<form action="upload" method="post" enctype="multipart/form-data">
    <label>File #1</label>
    <input type="file" name="file" multiple><br>
    <label>File #2</label>
    <input type="file" name="file" multiple><br>
    <label>File #3</label>
    <input type="file" name="file" multiple><br>
    <label>File #4</label>
    <input type="file" name="file" multiple><br>
    <label>File #5</label>
    <input type="file" name="file" multiple><br>
    <button type="submit">Upload</button>
    <button type="reset">Reset</button>
</form>
</body>
</html>