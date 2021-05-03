<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<p>You have successfully exited</p><br>
<%
session.invalidate();
%>
<h4>Try Again</h4>
<%@include file="index.html" %>
</body>
</html>