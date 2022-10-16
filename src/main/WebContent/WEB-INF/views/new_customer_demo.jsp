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
        <h2>Add New Person</h2>
        <form:form action="save" method="post" modelAttribute="customer">
            <table border="0" cellpadding="5">
                <tr>
                    <td>Id: </td>
                    <td><form:input path="customerId" /></td>
                </tr>
                <tr>
                    <td>Name: </td>
                    <td><form:input path="custName" /></td>
                </tr>
                <tr>
                    <td>Username: </td>
                    <td><form:input path="username" /></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><form:input path="password" /></td>
                </tr>
                <tr>
                    <td>Account number: </td>
                    <td><form:input path="accNo" /></td>
                </tr>
                <tr>
                    <td>Balance: </td>
                    <td><form:input path="balance" /></td>
                </tr>
                <tr>
                    <td>Address id: </td>
                    <td>${customer.addressId}</td>
                        <form:hidden path="addressId"/>

                </tr>
                <tr>
                    <td>gender: </td>
                    <td><form:input path="gender" /></td>
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