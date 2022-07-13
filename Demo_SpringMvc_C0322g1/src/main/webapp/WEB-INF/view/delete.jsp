<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 7/13/2022
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Are you sure?</h3>
<form action="/delete" method="post">
    <table>
        <tr><td><input value="${product.id}" readonly name="id"></td></tr>
        <tr><td><input value="${product.name}"  readonly name="name"></td></tr>
        <tr><td><input value="${product.price}" readonly name="price"></td></tr>
        <tr><td><input value="${product.img}" readonly name="img"></td></tr>
    </table>
    <tr><td><input type="submit" value="Delete"></td></tr>
    <tr><td><a href="/home">Cancel</a></td></tr>
</form>
</body>
</html>
