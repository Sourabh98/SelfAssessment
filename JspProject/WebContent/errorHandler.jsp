<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<!--so as we learned here we are using the page directive to declare this as a centralised error handler page and we can refer this jsp in
any of our other jsps to handle the exception   -->
<body>
<%@page isErrorPage="true" %>
<%
if(exception instanceof NumberFormatException)
{
	out.println("<p> Exception occured while converting the request parameter to the primitive type int.</p>");
}
else if(exception instanceof ArithmeticException)
{
	out.println("<p> Exception occured while performing the division, divider shouldn't be zero..</p>");
}
else
{
	out.println(exception.getMessage());
}
%>
</body>
</html>