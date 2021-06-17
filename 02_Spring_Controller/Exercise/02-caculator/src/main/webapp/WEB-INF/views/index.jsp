<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/16/2021
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculator" method="post">
    <h3>Calculator</h3>
    <label>
        <input type="number" name="num1" placeholder="input first number">
    </label>
    <label>
        <input type="number" name="num2" placeholder="input second number ">
    </label>
    <div>
        <button type="submit" value="+" name="calculator">Addition</button>
        <button type="submit" value="-" name="calculator">Subtraction</button>
        <button type="submit" value="*" name="calculator">Multiplication</button>
        <button type="submit" value="/" name="calculator">Division</button>
        <span>Result ${result}</span>
    </div>
</form>
</body>
</html>
