    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
        Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Customer Manager</title>
    </head>
    <body>
    Successfully Logged in<br>
   <form method="get"  action="/Evaluation/customer/fetchById/${customer.customerId}"></br>
        <input type="submit"  value="My Details"/></form>
   <form method="get"  action="/Evaluation/customer/edit/${customer.customerId}"></br>
        <input type="submit"  value="Edit My Details"/></form>
   <form method="get"  action="/Evaluation/customer/withdraw/${customer.customerId}"></br>
        <input type="submit"  value="Withdraw"/></form>
   <form method="get"  action="/Evaluation/customer/loanHome/${customer.customerId}"></br>
        <input type="submit"  value="Loan"/></form>

    <a href="http://localhost:8080/Evaluation/customer/login"><i>HOME</i></a>
    </body>
    </html>