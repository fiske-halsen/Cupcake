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




<div>
    <h3 class="align-content-center">Liste over Ordrer: </h3>
    <sql:setDataSource var="myDS" driver="com.mysql.jdbc.Driver"
                       url="jdbc:mysql://188.166.61.197:3306/cupcake"
                       user="tue"  password="MitPassword1234/"/>

    <sql:query dataSource="${myDS}" var="Orders">
        SELECT o.Order_ID, o.Date, o.Customer_ID, u.Email FROM Orders as o
        INNER JOIN User as u ON o.Customer_ID = u.Customer_ID
    </sql:query>
    <table border="1">
        <c:forEach var="row" items="${Orders.rows}">
            <tr>
                <td><c:out value="${row.Order_ID}"/></td>
                <td><c:out value="${row.Date}"/></td>
                <td><c:out value="${row.Customer_ID}"/></td>
                <td><c:out value="${row.Email}"/></td>

            </tr>
        </c:forEach>
    </table>
</div>


<%@include file="../includes/footer.inc"%>
