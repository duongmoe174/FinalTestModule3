<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 4/12/2022
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<center>
    <h1>Product Management</h1>
    <h2>
        <a href="products?action=create">Add new product</a>
    </h2>
</center>

<div align="center">
    <table border="1px" cellpadding="5">
        <caption><h2>List of prodcut</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Number</th>
            <th>Color</th>
            <th>Description</th>
            <th>Category</th>
            <th>Action</th>
        </tr>
        <c:forEach var="p" items="${products}">
            <tr>
                <td><c:out value="${p.id}"/></td>
                <td><c:out value="${p.name}"/></td>
                <td><c:out value="${p.price}"/></td>
                <td><c:out value="${p.number}"/></td>
                <td><c:out value="${p.color}"/></td>
                <td><c:out value="${p.description}"/></td>
                <td><c:out value="${p.category.name}"/></td>
                <td>
                    <a href="products?action=edit&id=${p.id}">Edit</a>
                    <a href="products?action=delete&id=${p.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
