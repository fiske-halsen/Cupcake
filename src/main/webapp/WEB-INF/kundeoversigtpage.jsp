<%--
  Created by IntelliJ IDEA.
  User: lukas
  Date: 21-03-2020
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../includes/header.inc"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="upcon">
    <img src="images/cupcakes.jpg" style="width:100%"/>
</div>

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


<form action="FrontController" method="post">
    <input type="hidden" name="taget" value="removeorderline"/>
    <div class="form-group">
        <label for="removeorder">Indtast nummeret på den cupcake du vil fjerne:</label>
        <input type="text" name="orderline_id" class="form-control" id="removeorder">
        <button type="submit" class="btn btn-primary btn-lg">Fjern</button>
    </div>
</form>


<%@include file="../includes/footer.inc"%>
