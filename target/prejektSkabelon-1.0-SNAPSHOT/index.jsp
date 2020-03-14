<%--
  Created by IntelliJ IDEA.
  User: Sebastian
  Date: 14/03/2020
  Time: 10.23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.inc"%>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Cupcake Webshop</title>

    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            border: 1px solid #e7e7e7;
            background-color: #f3f3f3;
        }

        li a {
            float: left;
        }

        li b {
            float: right;
        }

        li a {
            display: block;
            color: #666;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li b {
            display: block;
            color: #666;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover:not(.active) {
            background-color: #ddd;
        }

        li b:hover:not(.active) {
            background-color: #ddd;
        }

        li a.active {
            color: white;
            background-color: #4CAF50;
        }

        li b.active {
            color: white;
            background-color: #4CAF50;
        }

        .dropbtn {
            background-color: #4CAF50;
            color: white;
            padding: 16px;
            font-size: 16px;
            border: none;
        }

        .dropdown {
            position: relative;
            display: inline-block;
            margin-right: 15px;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f1f1f1;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        .dropdown-content a:hover {background-color: #ddd;}

        .dropdown:hover .dropdown-content {display: block;}

        .dropdown:hover .dropbtn {background-color: aqua;}

    </style>
</head>
<body>

<div class="container-fluid">

    <div class="upcon">
    <img src="images/cupcakes.jpg" style="width:100%"/>
    </div>

    <ul class="mb-5">
        <li><a href="#opretbruger">Opret bruger</a></li>
        <li><a href="#galleri">Galleri</a></li>
        <li><b class="active" href="#login">Login</b></li>
        <li><b href="#kurv">Kurv</b></li>
    </ul>

    <h1 class="text-center mb-5">Velkommen til byens bedste cupcakes</h1>

    <div class="row">

        <div class="col-lg-4"></div>


        <div class="col-lg-6">

            <div class="dropdown mt-5">
                <button class="dropbtn">Bund</button>
                <div class="dropdown-content">
                    <a href="#">Link 1</a>
                    <a href="#">Link 2</a>
                    <a href="#">Link 3</a>
                </div>
            </div>

            <div class="dropdown">
                <button class="dropbtn">Topping</button>
                <div class="dropdown-content">
                    <a href="#">Link 1</a>
                    <a href="#">Link 2</a>
                    <a href="#">Link 3</a>
                </div>
            </div>

            <div class="dropdown">
                <button class="dropbtn">Dropdown</button>
                <div class="dropdown-content">
                    <a href="#">Link 1</a>
                    <a href="#">Link 2</a>
                    <a href="#">Link 3</a>
                </div>
            </div>

            <!--
            TODO: ændrer value så det passer til java classen der bliver lavet
            -->
            <div class="dropdown">
                <form action="FrontController" method="post">
                    <input type="hidden" name="taget" value="tilføj">
                    <button type="submit" class="btn btn-primary btn-lg">Tilføj til kurv</button>
                </form>
            </div>

        </div>

        <div class="col-lg-2"></div>

    </div>

</div>

<%@include file="includes/footer.inc"%>
