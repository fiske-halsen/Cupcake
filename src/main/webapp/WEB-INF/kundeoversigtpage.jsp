<%--
  Created by IntelliJ IDEA.
  User: Sebastian
  Date: 14/03/2020
  Time: 10.23
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
<title>Kundeoversigt</title>


</head>
<body>

<div class="upcon">
    <img src="images/cupcakes.jpg" style="width:100%"/>
</div>

<ul class="mb-2">
    <li><a href="FrontController?taget=seecustomers">Kundeoversigt</a></li>
    <li><a href="FrontController?taget=seeorders">Ordreoversigtpage</a></li>
    <li><a class="active" href="#login">${sessionScope.email}</a></li>
        <li><a href="FrontController?taget=logout" class="bg-danger text-white">Logout</a></li>
</ul>

<div>
    <h3 class="align-content-center"> Liste af brugere:</h3>
    <div>
        <sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://188.166.61.197:3306/cupcake"
                           user="tue"  password="MitPassword1234/"/>

        <sql:query dataSource="${myDS}" var="Customers">
            SELECT Customer_ID, Email, Saldo FROM User
        </sql:query>
        <table border="1">
            <c:forEach var="row" items="${Customers.rows}">
                <tr>
                    <td><c:out value="${row.Customer_ID}"/></td>
                    <td><c:out value="${row.Email}"/></td>
                    <td><c:out value="${row.Saldo}"/></td>

                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<h3>Slet en kunde</h3>

<form action="FrontController" method="post">
    <input type="hidden" name="taget" value="removecustomer"/>
    <div class="form-group">
        <label for="removecustomer">Indtast nummer på den kunde du vil slette:</label>
        <input type="text" name="customerId" class="form-control" id="removecustomer">
        <button type="submit" class="btn btn-primary btn-lg">Fjern</button>
    </div>
</form>

<h3>Opdater saldo</h3>

<form action="FrontController" method="post">
    <input type="hidden" name="taget" value="updatecustomersaldo"/>
    <div class="form-group">
        <label for="customerId">Indtast nummer på den kunde du vil rette saldo for:</label>
        <input type="text" name="customerId" class="form-control" id="customerId">
        <label for="customerSaldo">Indtast den nye saldo til kunden:</label>
        <input type="text" name="customerSaldo" class="form-control" id="customerSaldo">
        <button type="submit" class="btn btn-primary btn-lg">Opdater</button>
    </div>
</form>

<%@include file="../includes/footer.inc"%>