<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/15/2021
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/translate" method="post">
    <p>Nhap tu</p>
    <input type="text" name="nhap" placeholder="Nhap">
    <input type="submit"  value="translate">
    <input type="text" value="${result}">

</form>
</body>
</html>
