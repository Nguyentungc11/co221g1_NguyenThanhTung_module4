<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/16/2021
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Please choose condiment for your Sandwich </h1>

<form action="/save">
    <div style="display: flex">
        <input type="checkbox" name="condiment" value="Lettuce">
        <p>Lettuce</p>
        <input type="checkbox" name="condiment" value="Tomato">
        <p>Tomato</p>
        <input type="checkbox" name="condiment" value="Mustard">
        <p>Mustard</p>
        <input type="checkbox" name="condiment" value="Sprouts">
        <p>Sprouts</p>
        <input type="submit" value="Save">
    </div>
</form>
</body>
</html>