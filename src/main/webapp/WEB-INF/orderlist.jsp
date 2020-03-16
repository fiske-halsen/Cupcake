<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 16-03-2020
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc"%>

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
        <li><a href="#ordreoversigt">Ordreoversigt</a></li>
        <li><a href="#kundeoversigt">Kundeoversigt</a></li>
        <!-- todo: fix href -->
        <li><a class="active" href="WEB-INF/login.jsp">${sessionScope.email}</a></li>
    </ul>

    <h1 class="text-center mb-5">Liste over ordrer</h1>


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



<%@include file="../includes/footer.inc"%>
