<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TCS assignment</title>
</head>
<body style="background-color: green; ">

<style>
h1 {text-align: center;}
p {text-align: center;}
div {text-align: center;}
form{
	background-color: #89f5ee;
	width: 500px;
	height: 450 px;
	border-style: solid;
	border-color: blue;
	padding: 10px;
}
</style>


<div>
	<form action="/reguser" method="post">
		<div><h2>Registration Page</h2></div>
		<div><br></div>
		<div>UserId : <input type="number" name="userid" value=""><br></div>
		<div><br></div>
		<div>UserName : <input type="text" name="username" value=""></div>
		<div><br></div>
		<div>Password : <input type="text" name="password" value=""></div>
		<div><br></div>
		<div><input type="submit" value="Sign Up" style="background-color:lime;"></div>
	</form>
</div>
</body>
</html>