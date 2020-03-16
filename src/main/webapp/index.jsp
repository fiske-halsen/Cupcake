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
    <link rel="stylesheet" type="text/css" href="CSS/style.css">
    <title>Cupcake Webshop</title>


</head>
<body>

<div class="container-fluid">

    <div class="upcon">
        <img src="images/cupcakes.jpg" style="width:100%"/>
    </div>

    <ul class="mb-5">
        <li><a href="#opretbruger">Opret bruger</a></li>
        <li><a href="#galleri">Galleri</a></li>
        <!-- todo: fix href -->
        <li><a class="active" href="WEB-INF/loginpage.jsp">Login</a></li>
        <li><a href="#kurv">Kurv</a></li>
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



            <div class="col-lg-4"></div>

        </div>


    </div>

    <div class="mt-5">
        <footer class="page-footer font-small blue">

            <!-- Copyright -->
            <div class="footer-copyright text-center py-3">© 2020 Copyright:
                <a href="https://mdbootstrap.com/"> Kernen </a>
            </div>
            <!-- Copyright -->

        </footer>
    </div>
</div>



<%@include file="includes/footer.inc"%>
