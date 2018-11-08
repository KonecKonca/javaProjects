<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Login Page</title>
    <%--import bootstrap--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
    <script src="js/jquery.validation.min.js" type="text/javascript"></script>
    <script src="js/validation.js" type="text/javascript"></script>

    <link href="css/styles.css" rel="stylesheet" />

</head>
<body>

<div class="form">

    <br><br><br><br><br>
    <center><h1>Input registration parameters</h1></center>
    <br>
    <form action="/login" method="post" id="loginForm">

        <table align="center">
            <tr>
                <th align="right">Login:</th>
                <td><input type="text" name="login" placeholder="Login" class="form-control"/></td>
            </tr>
            <tr>
                <th align="right">Password:</th>
                <td><input type="password" name="password" placeholder="Password" class="form-control"/></td>
            </tr>
            <tr>
                <td colspan="2" align="right"><input type="submit" value="Log in" class="btn btn-primary"/></td>
            </tr>
        </table>


    </form>
</div>


</body>
</html>
