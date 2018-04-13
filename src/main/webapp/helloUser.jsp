<%--
  Created by IntelliJ IDEA.
  User: Pavel
  Date: 08.04.2018
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello!</title>
    <style type="text/css">
        table{
            text-align: center;
        }
        p{
            font-size: 20pt;
            font-family: "Times New Roman";
        }
    </style>
</head>
<body>
    <p>Hello, user! What you want?</p>
    <table border="1" cellpadding="2" cellspacing="0">
        <thead>
            <th>Show All Clients</th>
            <th>Add New Client</th>
        </thead>
        <tbody>
            <tr>
                <td>
                    <form action="clients" method="get">
                        <button type="submit">Show Clients</button>
                    </form>
                </td>
                <td>
                    <form action="createClient.jsp">
                        <button type="submit">Add Client</button>
                    </form>
                </td>
            </tr>
        </tbody>
    </table>
</body>
</html>
