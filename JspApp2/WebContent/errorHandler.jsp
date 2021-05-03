<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
</head>
<%@page isErrorPage="true" %>
<%@page contentType="text/html; charset=ISO-8859-1" %>
<body>
<%
if(exception instanceof NumberFormatException)
{
	out.println("<b>Exception occured while trying to convert request parameter into int primitive type..</b>");
}

else
{
	out.println("Exception occured:"+exception.getMessage());
}
%>

</body>
</html>