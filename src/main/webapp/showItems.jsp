<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 16.04.2018
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <a href="createItem.jsp">Add item</a>
    |
    <a href="showItems">Show all items</a>
</div>
<br>
<table border="1px black">
    <thead>
    <th width="50px"><h3>ID</h3></th>
    <th width="150px"><h3>NAME</h3></th>
    <th width="150px"><h3>MONEY</h3></th>
    </thead>
    <tbody>
    <c:forEach var="item" items="${items}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.money}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
