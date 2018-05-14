<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create item</title>
</head>
<body>
<div>
    <a href="createItem.jsp">Add item</a>
    |
    <a href="showItems">Show all items</a>
</div>
<br>
<form action="addItem" method="post">
    <table border="1px black">
        <tr>
            <td width="100px">NAME</td>
            <td width="100px">
                <input type="text" name="name" placeholder="Enter name">
            </td>
        </tr>
        <tr>
            <td width="100px">MONEY</td>
            <td width="100px">
                <input type="number" name="money" placeholder="Enter money">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">ADD</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
