<#macro page>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <style type="text/css">
        body{
            background-image: url("http://bigbucks.com.ua/wp-content/uploads/2016/09/ideabank.jpg");
            -moz-background-size: 100%;
            -webkit-background-size: 100%;
            -o-background-size: 100%;
            background-size: 100%;
            opacity: 0.9;
            /*-webkit-text-stroke: 0.4px cornflowerblue;*/
        }
        table {
            margin: auto;
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
            font-size: 14px;
            border-radius: 10px;
            border-spacing: 0;
            text-align: center;
        }
        th {
            background: #0EB0D9;
            color: white;
            text-shadow: 0 1px 1px #2D2020;
            padding: 30px 40px;
        }
        th, td {
            border-style: solid;
            border-width: 0 1px 1px 0;
            border-color: white;
        }
        th:first-child, td:first-child {
            text-align: left;
        }
        th:first-child {
            border-top-left-radius: 10px;
        }
        th:last-child {
            border-top-right-radius: 10px;
            border-right: none;
        }
        td {
            padding: 10px 20px;
            background: #F8E391;
        }
        tr:last-child td:first-child {
            border-radius: 0 0 0 10px;
        }
        tr:last-child td:last-child {
            border-radius: 0 0 10px 0;
        }
        tr td:last-child {
            border-right: none;
        }
        button {
            width: 500px;
            height: 170px;
            border: 1px solid #0a3c59;
            background: #3e779d;
            background: -webkit-gradient(linear, left top, left bottom, from(#3a70d7), to(#3e779d));
            background: -webkit-linear-gradient(top, #65a9d7, #3e779d);
            background: -moz-linear-gradient(top, #65a9d7, #3e779d);
            background: -ms-linear-gradient(top, #65a9d7, #3e779d);
            background: -o-linear-gradient(top, #65a9d7, #3e779d);
            background-image: -ms-linear-gradient(top, #65a9d7 0%, #3e779d 100%);
            /*padding: 12px 24px;*/
            -webkit-border-radius: 6px;
            -moz-border-radius: 6px;
            border-radius: 6px;
            -webkit-box-shadow: rgba(255,255,255,0.4) 0 1px 0, inset rgba(255,255,255,0.4) 0 1px 0;
            -moz-box-shadow: rgba(255,255,255,0.4) 0 1px 0, inset rgba(255,255,255,0.4) 0 1px 0;
            box-shadow: rgba(255,255,255,0.4) 0 1px 0, inset rgba(255,255,255,0.4) 0 1px 0;
            text-shadow: #7ea4bd 0 1px 0;
            color: #eff1f2;
            font-size: 17px;
            font-family: helvetica, serif;
            text-decoration: none;
            vertical-align: middle;
        }
        h2{
            font: 58px "Monotype Corsiva";
            text-shadow: white 0 0 4px;
            color: #013BBC;
        }
        a{
            color: #FFE3B9;
        }

    </style>

</head>
<body>

<#include "navbar.ftl">
    <div class="container mt-5">

        <#nested>

    </div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>


</body>
</html>


</#macro>


