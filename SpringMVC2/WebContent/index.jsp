<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<!--In this app user will enter his Name first time and will submit the request then we will pick a random number in between 0 to 100 and will put that number in the user's session 
then will tell the user that we have picked a number for you and you will have to guess that number then user will guess the number and we will count the number of attempts that user took to guess 
the number then we will tell user that in so many attempts you guessed the number right, if number is guessed right then we tell the user this is the right number, if the number guesses by user is small
then will tell the user that try with the big number and if the number is big then will tell user that try with the smaller number and at the end when user will guess it right we will tell the number
of attempts as we mentioned above as well     -->
<head>
<meta charset="ISO-8859-1">
<title>Number guessing Web app</title>
</head>
<body>
<form action="startGame.spring">
<p>To Play the game enter your name</p>
Name: <input type="text" name="name"><br>
<input type="submit" value="Start Game">
</form>
</body>
</html>