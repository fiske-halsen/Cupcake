<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 16-03-2020
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>

<!-- Kernen sumit dey34qf34qfq34f -->


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc" %>

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
        <li><a href="#galleri">Galleri</a></li>
        <!-- todo: fix href -->
        <li><a class="active" href="WEB-INF/login.jsp">Login</a></li>
    </ul>

    <h1 class="text-center mb-5">Velkommen til byens bedste cupcakes login side</h1>


    <div class="row">

        <div class="col-lg-4"></div>

        <div class="col-lg-4">


            <!-- todo ændre value til en command class -->
            <h1> Login </h1>
            <form action="FrontController" method="post">
                <input type="hidden" name="taget" value="resultat"/>
                <div class="form-group">
                    <label for="brugernavn">Brugernavn</label>
                    <input type="text" name="brugernavn" class="form-control" id="brugernavn1" aria-describedby="heightHelp">
                </div>
                <div class="form-group">
                    <label for="password1">Indtast password</label>
                    <input type="text" name="password1" class="form-control" id="password">

                </div>

                <button type="submit" class="btn btn-primary">Login</button>
            </form>

            <h1> Register </h1>
            <form action="FrontController" method="post">
                <input type="hidden" name="taget" value="resultat"/>
                <div class="form-group">
                    <label for="brugernavn">Brugernavn</label>
                    <input type="text" name="brugernavn" class="form-control" id="brugernavn" aria-describedby="heightHelp">
                </div>
                <div class="form-group">
                    <label for="password1">Indtast password</label>
                    <input type="text" name="password1" class="form-control" id="password1">
                    <label for="password2">Gentag password</label>
                    <input type="text" name="password2" class="form-control" id="password2">
                </div>

                <button type="submit" class="btn btn-primary">Opret bruger</button>
            </form>
        </div>

        <div class="col-lg-4"></div>


    </div> <!-- row -->


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


<%@include file="../includes/footer.inc" %>
