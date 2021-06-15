<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/15/2021
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/convert" method="post">
    <table>
        <tr>
            <td>Nhap tien</td>
            <td>From</td>
            <td>To</td>
            <td>Convert</td>
            <td>Result</td>
        </tr>
        <tr>
            <td><input type="number" name="input"></td>
            <td>
                <select name="m1">
                <option value="22500">VND</option>
                <option value="1">USD</option>
            </select>
            </td>
            <td>
                <select name="m2">
                    <option value="22500">VND</option>
                    <option value="1">USD</option>
                </select>
            </td>
            <td><input type="submit" value="convert"></td>
            <td>${result}</td>
        </tr>
    </table>
</form>
</body>
</html>
