<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Email configuration</title>
</head>
<body>
<h2>Settings</h2>
<form:form method="POST" action="mailConfig/create" modelAttribute="mailConfig">
   Languages: <form:select path="language" items="${languagesArray}"/><br/>
   Page Size: <label>Show</label><form:select path="pageSize" items="${pageSizesArray}"/><label>emails per page</label><br/>
   Spams Filter: <form:checkbox path="spamsFilter"/><label>Enable spams filter</label><br/>
   Signature:  <form:textarea path="signature"/><br/>
    <button type="submit">Update</button>
    <button type="button"><a href="/mailConfig">Cancel</a></button>
</form:form>
</body>
</html>