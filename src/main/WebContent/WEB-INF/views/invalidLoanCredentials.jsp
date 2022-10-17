<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Welcome</title>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	</head>
	<body>
	<form modelAttribute="loan">
		<h2>Oops! Invalid Loan Credentials</h2>
		Please enter Loan Name and Loan Amount
		<a href="http://localhost:8080/Evaluation/customer/applyNewLoan/${loan.customerId}"><i>Try Again</i></a>
	</form>
	</body>
</html>