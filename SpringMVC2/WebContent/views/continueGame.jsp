<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<div>
<!--will display whatever message we have set in the scope, $ this attribute selector can fetch the value from any of the scope i.e. from the request, session or context scope so first the value
of this variable will get searched in the request scope if not found then in the session scope and if not found in the session as well then will be search in the context scope.   -->
<h3>${message}</h3>
<!-- here we are including the numberform.html page this is the stand alone page which we are using in different JSPs  -->
<jsp:include page="numberForm.html"></jsp:include><hr>
<!-- Here we are showing the attempts that has been made by the user to guess the number, attempt is in session so this time the attribute selector will fetch the variable value from the session   -->
<h3>Attempts: ${attempt}</h3>
</div>
</html>