<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 16-03-2020
  Time: 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc"%>


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
        <!-- todo: fix href -->
        <li><a class="active" >${sessionScope.email}</a></li>
        <li><a href="#kurv">Kurv</a></li>
        <li><a href="FrontController?taget=customer">Shop</a></li>
    </ul>

    <h1 class="text-center mb-5">Velkommen til byens bedste cupcakes billeder</h1>

    <!-- todo fix billed position -->
    <div class="container-fluid">
        <div class="upcon">
            <img src="images/cupcakes.jpg" style="width:100%"/>
        </div>
        <div class="">
            <img src="images/cupcakes.jpg" style="width:100%"/>
        </div>
        <div class="">
            <img src="images/cupcakes.jpg" style="width:100%"/>
        </div>
        <div class="">
            <img src="images/cupcakes.jpg" style="width:100%"/>
        </div>



    </div>



</div>



<%@include file="../includes/footer.inc"%>
