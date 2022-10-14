<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %><%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
</br><h3>Person List</h3>
<form method="get"  action="/Evaluation/customer/applyNewLoan/${customer.customerId}"></br>
<input type="submit" class="blue-button" value="Apply for new Loan"/></form>
<form method="get"  action="/Evaluation/customer/statusOfLoan/${customer.customerId}"></br>
<input type="submit" class="blue-button" value="Status of applied Loans"/></form>
</body>
</html>