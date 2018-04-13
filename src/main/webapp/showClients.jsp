<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clients</title>
</head>
<body>
<div>
    <table border="1px black">
        <thead>
            <th width="50px">id</th>
            <th width="150px">login</th>
            <th width="150px">password</th>
            <th width="150px">account</th>
            <th width="50px">money</th>
        </thead>
        <tbody>
            <c:forEach var="item" items="${clients}">
                <tr>
                    <td>${item.getIdNumber()}</td>
                    <td>${item.getUsername()}</td>
                    <td>${item.getPassword()}</td>
                    <td>${item.getAccountOfBank()}</td>
                    <td>${item.getMoney()}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<div>
    <button type="submit">
        <a href="/servletapi/createClient.jsp">Add new client</a>
    </button>
</div>

</body>
</html>
