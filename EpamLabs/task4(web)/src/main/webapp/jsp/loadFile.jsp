<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Load File</title>
</head>
<body>

    <center>

        <p> You choise <h2>${parser}</h2> parser</p>
        <p> Download Image </p>

        <FORM action="/upload" enctype="multipart/form-data" method="POST">
            Upload File:
            <INPUT type="file" name="content">
            <INPUT type="submit" value="Upload File">
        </FORM>

    </center>


</body>
</html>
