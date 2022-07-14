<%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 13/07/2022
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Calculator</h2>
<form action="/save" method="post">

        <input type="text" value="" name="num1" size="100">
        <input type="text" value="" name="num2" size="100"><br/>

        <button type="submit" value="+" name="cal">Add(+)</button>
        <button type="submit" value="-" name="cal">Sub(-)</button>
        <button type="submit" value="*" name="cal">Mul(*)</button>
        <button type="submit" value="/" name="cal">Div(/)</button>
        <br/>
        Result:<label>${str} :${result}</label>

</form>

</body>
</html>
