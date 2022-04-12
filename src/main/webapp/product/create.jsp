<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 4/12/2022
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Management</title>
</head>
<body>
<center>
    <h1>Product Management</h1>
    <h2>
        <a href="products?action=classes">List of product</a>
    </h2>
</center>
<div align="center">
    <form action="" method="post">
        <table border="1px" cellpadding="5px">
            <caption>
                <h2>Add new product</h2>
            </caption>
            <tr>
                <th>name:</th>
                <td>
                    <input type="text" name="name", id="name", size="50"/>
                </td>
            </tr>
            <tr>
                <th>price:</th>
                <td>
                    <input type="text" name="price", id="price", size="50"/>
                </td>
            </tr>
            <tr>
                <th>number:</th>
                <td>
                    <input type="text" name="number", id="number", size="50"/>
                </td>
            </tr>
            <tr>
                <th>color:</th>
                <td>
                    <input type="text" name="color", id="color", size="50"/>
                </td>
            </tr>
            <tr>
                <th>description</th>
                <td>
                    <input type="text" name="description", id="description", size="50"/>
                </td>
            </tr>
            <tr>
                <th>category</th>
                <td>
                    <select name="categories" id="categories">
                        <c:forEach var="c" items="${categories}">
                            <option value="${c.id}">${c.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
