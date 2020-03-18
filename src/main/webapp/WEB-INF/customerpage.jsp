<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/headernoback.inc" %>


<!-- Required meta tags -->

<!-- Kernen -->
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
        <!-- todo fix href -->
        <li><a href="#kurv">Kurv</a></li>
        <li><a class="active" href="#login">${sessionScope.email}</a></li>
    </ul>

    <h1 class="text-center mb-5">Velkommen til byens bedste cupcakes</h1>

    <div class="row">

        <div class="col-lg-4"></div>

        <div class="col-lg-1">

            <form action="FrontController" method="post">

                <!-- Radio button choice bund -->
                <div class="radio">
                    <label><input type="radio" name="buttomchoice" value="chocolate">Chocolate: 5 kr</label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="buttomchoice" value="vanilla">Vanilla: 5 kr.</label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="buttomchoice" value="nutmeg">Nutmeg: 5 kr.</label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="buttomchoice" value="pistacio">Pistacio: 6 kr.</label>
                </div>
                <div class="radio">
                    <label><input type="radio" name="buttomchoice" value="almond">Almond: 7 kr.</label>
                </div>

            </form>

        </div>


        <div class="col-lg-1">

        <form action="FrontController" method="post">


            <!-- Radio topping choice bund -->
            <div class="radio">
                <label><input type="radio" name="toppingchoice" value="chocolate">Chocolate: 5 kr</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="toppingchoice" value="blueberry">Blueberry: 5 kr.</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="toppingchoice" value="rasberry">Rasberry: 5 kr.</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="toppingchoice" value="crispy">Crispy: 6 kr.</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="toppingchoice" value="strawberry">Strawberry: 6 kr.</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="toppingchoice" value="gedeost">Gedeost: 7 kr.</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="toppingchoice" value="orange">Orange: 8 kr.</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="toppingchoice" value="lemon">Lemon: 8 kr.</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="toppingchoice" value="blue waffel">Blue waffel: 9 kr.</label>
            </div>


        </form>
        </div>

        <div class="col-lg-1">
        <form action="FrontController" method="post">

            <!-- Radio button choice bund -->
            <div class="radio">
                <label><input type="radio" name="antal" value="1">1 stk.</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="antal" value="2">2 stk.</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="antal" value="3">3 stk.</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="antal" value="4">4 stk.</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="antal" value="5">5 stk.</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="antal" value="6">6 stk.</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="antal" value="7">7 stk.</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="antal" value="8">8 stk.</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="antal" value="9">9 stk.</label>
            </div>
            <div class="radio">
                <label><input type="radio" name="antal" value="10">10 stk.</label>
            </div>

        </form>

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

        <div class="col-lg-2"></div>


    </div>


<%@include file="../includes/footer.inc" %>