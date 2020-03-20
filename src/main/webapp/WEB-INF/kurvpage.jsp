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
<title>Cupcake Webshop</title>


</head>
<body>
<div class="upcon">
    <img src="images/cupcakes.jpg" style="width:100%"/>
</div>

<ul class="mb-2">
    <li><a href="FrontController?taget=galleri">Galleri</a></li>
    <!-- todo fix href -->
    <li><a href="FrontController?taget=sekurv">Kurv</a></li>
    <li><a href="FrontController?taget=customer">Shop</a></li>
    <li><a class="active" href="#login">${sessionScope.email}</a></li>
    <li><a class="active" href="#saldo">${sessionScope.saldo}</a></li>
</ul>

<sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://188.166.61.197:3306/cupcake"
                   user="tue"  password="MitPassword1234/"/>

<sql:query dataSource="${myDS}" var="Orderline">
Select b.BottomName, t.ToppingName, o.Total_Price, o.quantity from Orderline as o
INNER JOIN Buttom as b ON o.buttom_id = b.buttom_id
INNER JOIN Topping as t ON o.Topping_id = t.Topping_id WHERE o.Is_Active=TRUE AND Customer_ID= ${sessionScope.customer_id};
</sql:query>
<table border="1">
    <c:forEach var="row" items="${Orderline.rows}">
        <tr>
            <td><c:out value="${row.BottomName}"/></td>
            <td><c:out value="${row.ToppingName}"/></td>
            <td><c:out value="${row.quantity}"/></td>
            <td><c:out value="${row.Total_Price}"/></td>
        </tr>
    </c:forEach>
    ${sessionScope.totalprice}
</table>

<form action="FrontController" method="post">
    <input type="hidden" name="taget" value="makeorder">
    <button type="submit" class="btn btn-primary btn-lg">Køb</button>
</form>

<%@include file="../includes/footer.inc"%>