<%@page import="resources.Rectangle"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<%--
<%
Rectangle rectangle=(Rectangle)session.getAttribute("rectangle");
%>
<b>Length:</b><%=rectangle.getLength() %><br>
<b>Breadth:</b><%=rectangle.getBreadth() %><br>
<b>Area: </b><%=rectangle.getArea() %><br>--%>
<%-- So instead of above code we can write the code as below which is more simplified 
first we will use the useBean tag and will keep the same name of the bean as we have 
used in the rect.jsp as we know when we use this tag first the bean would be searched
in the given scope if not found then it creates the new bean--%>
<jsp:useBean id="rectangle" class="resources.Rectangle" scope="session"/>
<%-- Now we can use the getProperty action directly on the rectangle bean to populate the 
length, breadth and area which we have calculated in rect.jsp, remember this tag writes the data to the output stream so you 
don't have to write anything manually to the response--%>
<b>Length: </b><jsp:getProperty property="length" name="rectangle"/><br>
<b>Breadth: </b><jsp:getProperty property="breadth" name="rectangle"/><br>
<b>Area: </b><jsp:getProperty property="area" name="rectangle"/><br>
<a href="exit.jsp">Exit</a>
</body>
</html>