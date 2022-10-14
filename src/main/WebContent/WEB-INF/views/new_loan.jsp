<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Customer</title>
</head>
<body>
    <div align="center">
        <h2>Add New Loan</h2>
        <form:form action="/Evaluation/customer/loanSave" method="post" modelAttribute="loan">
            <table border="0" cellpadding="5">
                <tr>
                    <td>Id: </td>
                    <td><form:input path="loanId" /></td>
                </tr>
                <tr>
                    <td>Loan Name: </td>
                    <td><form:input path="loanName" /></td>
                </tr>
                <tr>
                    <td>amount: </td>
                    <td><form:input path="loanAmount" /></td>
                </tr>

                <tr>
                    <td>CustomerId: </td>
                    <td>${loan.customerId}</td>
                    <form:hidden path="customerId"/>
                </tr>

                <tr>
                    <td colspan="2"><input type="submit" value="Save"></td>
                </tr>
            </table>
                     </br><a href="http://localhost:8089/FruitStall/"><i>HOME</a></i>
        </form:form>
    </div>
</body>
</html>