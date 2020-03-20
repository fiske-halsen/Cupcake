<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 16-03-2020
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>

<!-- Kernen -->


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc" %>


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
        <li><a href="FrontController?taget=galleri">Galleri</a></li>
    </ul>

    <h1 class="text-center mb-5">Velkommen til byens bedste cupcakes login side</h1>


    <div class="row">

        <div class="col-lg-4"></div>

        <div class="col-lg-4 mt-5">


            <!-- todo ændre value til en command class -->
            <h1> Login </h1>
            <form action="FrontController" method="post">
                <input type="hidden" name="taget" value="loginuser"/>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="text" name="email" class="form-control" id="email">
                </div>
                <div class="form-group">
                    <label for="password">Indtast password</label>
                    <input type="password" name="password" class="form-control" id="password">

                </div>

                <button type="submit" class="btn btn-primary mb-5">Login</button>
            </form>

            <h1> Or Register </h1>
            <form action="FrontController" method="post">
                <input type="hidden" name="taget" value="register"/>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="text" name="email" class="form-control">
                </div>
                <div class="form-group">
                    <label for="password1">Indtast password</label>
                    <input type="password" name="password1" class="form-control" id="password1">
                    <label for="password2">Gentag password</label>
                    <input type="password" name="password2" class="form-control" id="password2">
                </div>

                <button type="submit" class="btn btn-primary">Opret bruger</button>
            </form>
        </div>

        <div class="col-lg-4"></div>


    </div> <!-- row -->



</div>

<c:if test = "${requestScope.error!= null}" >

<h2>Error ! </h2>
    ${requestScope.error}

</c:if>

<%@include file="../includes/footerindex.inc" %>
