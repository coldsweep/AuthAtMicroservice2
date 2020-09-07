<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TCS assignment</title>
</head>
<body style="background-color: dodgerblue; ">
<style>
h1 {text-align: center;}
p {text-align: center;}
div {text-align: center;}
form{
	background-color: #34ebcc;
	width: 500px;
	height: 450 px;
	border-style: solid;
	border-color: red;
	padding: 10px;
}
</style>


<div>
	<form action="/login" method="post">
		<div><h2>Login Page</h2></div>
		<div><br></div>
		<c:if test="${not empty error}">
			<div style="color: red;"><h3>${error}</h3></div>
			<div><br></div>
		</c:if>
		<c:if test="${not empty registerSuccess}">
			<div style="color:yellow;"><h3>${registerSuccess}</h3></div>
			<div><br></div>
		</c:if>
		<c:if test="${not empty registrationError}">
			<div style="color:red;"><h3>${registrationError}</h3></div>
			<div><br></div>
		</c:if>
		<div>UserID : <input type="number" name="userid" value=""><br></div>
		<div><br></div>
		<div>Password : <input type="text" name="password" value=""></div>
		<div><br></div>
		<div><input type="submit" value="Login" style="background-color: lime;"></div>
		<div><br></div>
		<div><input type="button" value="Sign Up" onclick="goToRegister()" style="background-color: orange;"></div>
	</form>
</div>
<script type="text/javascript">
	function goToRegister(){
		window.location.href="/register";
	}
</script>
</body>
</html>
