<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %><%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<center>
</br><h3>LOAN SECTION</h3>
<form method="get"  action="/Evaluation/customer/applyNewLoan/${customer.customerId}"></br>
<input type="submit" class="blue-button" value="Apply for new Loan"/></form>
<form method="get"  action="/Evaluation/customer/statusOfLoan/${customer.customerId}"></br>
<input type="submit" class="blue-button" value="Status of applied Loans"/></form>
</br><button onclick="history.back()"> Back</button>
</center>
</body>
</html>