<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Letter - Simple Sign Up Form</title>

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400">  <!-- Google web font "Open Sans" -->
    <link rel="stylesheet" href="css/index/common/font-awesome.min.css">
    <link rel="stylesheet" href="css/index/common/bootstrap.min.css">

    <link rel="stylesheet" href="css/index/common/demo.css" />
    <link rel="stylesheet" href="css/index/common/templatemo-style.css">

    <script type="text/javascript" src="js/index/modernizr.custom.86080.js"></script>

</head>

<body>

<div id="particles-js"></div>

<ul class="cb-slideshow">
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
</ul>

<div class="container-fluid">
    <div class="row cb-slideshow-text-container ">
        <div class= "tm-content col-xl-6 col-sm-8 col-xs-8 ml-auto section">
            <header class="mb-5"><h1>Welcome to PUFAR</h1></header>
            <P class="mb-5"> ${accessRight} Thank you for visiting our site dear ${currentUser.login}!</P>

            <form action="/login" method="get" class="subscribe-form">
                <div class="row form-section">

                    <%--nice input field--%>
                    <%--<div class="col-md-7 col-sm-7 col-xs-7">--%>
                        <%--<input name="email" type="text" class="form-control" id="contact_email" placeholder="Your Email..." required/>--%>
                    <%--</div>--%>

                    <div class="col-md-5 col-sm-5 col-xs-5">
                        <button type="submit" value="Login" class="tm-btn-subscribe">Login</button>
                    </div>

                </div>
            </form>

            <div class="tm-social-icons-container text-xs-center">
                <a href="" class="tm-social-link"><i class="fa fa-facebook"></i></a>
                <a href="" class="tm-social-link"><i class="fa fa-google-plus"></i></a>
                <a href="" class="tm-social-link"><i class="fa fa-twitter"></i></a>
                <a href="" class="tm-social-link"><i class="fa fa-linkedin"></i></a>
            </div>

        </div>
    </div>
    <div class="footer-link">
        <p>© 2018 Pufar Company

            - Design: <a rel="nofollow" href="https://vk.com/akozitsky" target="_parent">Andrei Kozitski</a></p>
    </div>
</div>
</body>

<script type="text/javascript" src="js/index/particles.js"></script>
<script type="text/javascript" src="js/index/app.js"></script>
</html>