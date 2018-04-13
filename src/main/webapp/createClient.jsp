<%--
  Created by IntelliJ IDEA.
  User: ermolaxe
  Date: 4/8/2018
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New client</title>
    <style type="text/css">
        tr{
            text-align: center;
        }
    </style>
</head>
<body>
<div>
    <form action="client" method="post">
        <table border="1px black">
            <tr>
                <td>username</td>
                <td>
                    <input type="text" name="username" required pattern="^[a-zA-Z]+$">
                </td>
            </tr>
            <tr>
                <td>password</td>
                <td>
                    <input type="password" name="password" required>
                </td>
            </tr>
            <tr>
                <td>account</td>
                <td>
                    <input type="number" name="account" required pattern="^[ 0-9]+$">
                </td>
            </tr>
            <tr>
                <td>money</td>
                <td>
                    <input type="number" name="money" required pattern="^[ 0-9]+$">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="submit">create</button>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button type="reset">Reset</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
