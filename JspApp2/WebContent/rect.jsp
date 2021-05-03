<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<b>Your rectangle is successfully created.</b>
<%-- here id is the bean id, scope is where we want to put this bean so that this
can be shared in multiple requests.
property is the name of the datamember which is defined in the rectangle class
in the name attribute when we are using getProperty or the setProperty action
we provide the name of the bean whose property we are referring to
Now in the param you define the name of the request parameter and translator generates the code
to fetch the value of the request parameter and will invoke the setter method of the Rectangle bean
to set that value in that bean, so you will have to define the setter methods in the Rectangle bean
which would be used by the translator if you won't define the setter method properly then you will get
an exception like "Can't find a method to write property 'length' of type 'int' in a bean of type 'resources.Rectangle" --%>
<jsp:useBean id="rectangle" class="resources.Rectangle"  scope="session"/>
<jsp:setProperty property="length" param="length" name="rectangle"/>
<jsp:setProperty property="breadth" param="breadth" name="rectangle"/>
<%
rectangle.calculateArea();
%>
<br>
<a href="viewDetails.jsp">View Details</a><br>
<a href="exit.jsp">Exit</a>
<%@page errorPage="errorHandler.jsp" %>
</body>
</html>