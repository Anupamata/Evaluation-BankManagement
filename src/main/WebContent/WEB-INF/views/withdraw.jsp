<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Customer</title>
</head>
<body>
    <div align="center">
        <h2>Withdraw Form</h2>

your balance is : ${customer.balance}</br><br>
            Enter amount to withdraw : <input type="text" id="amount"><br>
            </br><button onclick='window.location ="/Evaluation/customer/withdrawResult/${customer.customerId}/"+document.getElementById("amount").value'>OK </button>


         </div>
        </body>
        </html>
