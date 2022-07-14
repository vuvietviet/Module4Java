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
<h2>Sandwich Condiments</h2>
<form action="/save" method="post">

        <input type="checkbox" value="Lettuce" name="Giavi">Lettuce
        <input type="checkbox" value="Tomato" name="Giavi">Tomato
        <input type="checkbox" value="Mustard" name="Giavi">Mustard
        <input type="checkbox" value="Sprouts" name="Giavi">Sprouts
        <hr/>
        <button type="submit" value="">Save</button>

</form>

</body>
</html>
