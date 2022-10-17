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
    <center>
    <h2>
    Welcome <i>${manager.managerName}</i><br></h2>
   <form method="get"  action="/Evaluation/manager/getAllCustomers/${customer.customerId}"></br>
        <input style="height:50px;width:120px" type="submit"  value="View customers"/></form>
   <form method="get"  action="/Evaluation/manager/fetchById"></br>
        <input style="height:50px;width:120px" type="submit"  value="Search Customer"/></form>
   <form method="get"  action="/Evaluation/manager/newCustomer"></br>
        <input style="height:50px;width:120px" type="submit"  value="New Customer"/></form>
   <form method="get"  action="/Evaluation/manager/pendingLoan"></br>
        <input style="height:50px;width:120px" type="submit"  value="   Loan Details   "/></form>
   <form method="get"  action="/Evaluation/"></br>
        <input style="height:50px;width:120px" type="submit"  value="   Log Out   "/></form>
    </center>
    </body>
    </html>