<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <title>Manager Login</title>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<body>
	    <center>
	        <h2 align="center">Manager Login</h2>
	        <div>&nbsp;</div>
	        <form id="user_form" action="${pageContext.request.contextPath}/manager/loginResult" method="POST">
	                <label for="name">Username:</label>
	                <input type="text"  id="name" placeholder="Enter username" name="username"><br><br>
	                <label for="pwd">Password:  </label>
	                <input type="password"  id="pwd" placeholder="Enter password" name="password"><br><br>
                    <input type="reset" value="Reset"/>&nbsp &nbsp
	                 <button id="confirm_user" type="submit" >Login</button>
	        </form>
	    </center>
	</body>
</html>