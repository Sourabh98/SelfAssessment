<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<body>
<div>
<!--SHOWING THE MESSAGE AGAIN WHICH WE HAVE PUT IN THE REQUEST SCOPE   -->
<h3>${message}</h3>
<!--providing the link for index.jsp if user wanted to play again.   -->
<a href="index.jsp">Play Again</a>
<!--This time the counter attribute value is getting fetched from the context scope as we have put this attribute in the context scope.   -->
<h3>The game is played ${counter} times so far</h3>
</div>
</body>
</html>