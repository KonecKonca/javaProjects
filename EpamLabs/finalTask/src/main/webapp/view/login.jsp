<html>
<head>

    <title>Login Page</title>
    <%--import bootstrap--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
    <script src="js/jquery.validation.min.js" type="text/javascript"></script>
    <script src="js/validation.js" type="text/javascript"></script>

</head>
<body>

<style>
    .error{
        color: red;
        font-size: 19px;
        font-style: italic;
        text-shadow: white 0 0 15px;
    }
    .form{
        background: url(image/phone.jpg) top right no-repeat;
        /*background-image: url("https://s1.1zoom.ru/big3/158/354748-admin.jpg");*/

        -moz-background-size: 100%; /* Firefox 3.6+ */
        -webkit-background-size: 100%; /* Safari 3.1+ и Chrome 4.0+ */
        -o-background-size: 100%; /* Opera 9.6+ */
        background-size: 100%; /* Современные браузеры */

        opacity: 0.9;
        height: 100%;

        text-shadow: white 2px 2px 15px;
    }

</style>


<%--<div class="container-fluid"></div>--%>

<div class="form">
    <%--input for logout--%>
    <%--<form action="/logout" method="post">--%>
    <%--<input type="submit" value="Log out" class="btn btn-primary"/>--%>
    <%--</form>--%>

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
