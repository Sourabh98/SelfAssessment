<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Divider App</title>
</head>
<body>
<%!
public void jspInit()
{
	System.out.println("This init method is overriden from divide.jsp.");
}
%>
<%
int num1=Integer.parseInt(request.getParameter("num1"));
int num2=Integer.parseInt(request.getParameter("num2"));
%>
<b><h3>Division is: <%=num1/num2 %></h3></h3></b>
<jsp:include page="index.html"></jsp:include>
<%@page errorPage="errorHandler.jsp" %>
</body>
</html>