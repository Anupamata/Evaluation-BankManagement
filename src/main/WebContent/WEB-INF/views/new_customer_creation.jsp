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
        <form action="customerSave" method="post" >
            <table border="1" cellpadding="5">
                <tr>
                    <td>Id: </td>
                    <spring:bind path="customer.customerId">
                    <td><input type="text"></td>
                    </spring:bind>
                </tr>
                <tr>
                    <td>Customer Name: </td>
                     <spring:bind path="customer.custName">
                     <td><input type="text"></td>
                     </spring:bind>
                </tr>
                <tr>
                    <td>username: </td>
                     <spring:bind path="customer.username">
                     <td><input type="text"></td>
                     </spring:bind>
                </tr>
                <tr>
                    <td>Password: </td>
                    <spring:bind path="customer.password">
                    <td><input type="text"></td>
                    </spring:bind>
                </tr>
                <tr>
                    <td>Account Number: </td>
                     <spring:bind path="customer.accNo">
                     <td><input type="text"></td>
                     </spring:bind>
                </tr>
                <tr>
                    <td>Balance: </td>
                     <spring:bind path="customer.accNo">
                     <td><input type="text"></td>
                </tr>
                <tr>
                    <td>Gender: </td>
                    <spring:bind path="customer.gender">
                    <td><input type="text"></td>
                    </spring:bind>
                </tr>

                <tr>
                    <td>Address Id: </td>
                    <td>${address.addressId}
                     <spring:bind hidden path="address.addressId" path="address.addressId">
                     </spring:bind>
                </tr>
                <tr>
                    <td>House Name: </td>
                    <spring:bind path="address.houseName">
                    <td><input type="text"></td>
                    </spring:bind>
                </tr>
                <tr>
                    <td>City: </td>
                     <spring:bind path="address.city">
                     <td><input type="text"></td>
                     </spring:bind>
                </tr>
                <tr>
                    <td>State: </td>
                    <spring:bind path="address.state">
                    <td><input type="text"></td>
                    </spring:bind>
                </tr>
                <tr>
                    <td>Pin Code: </td>
                     <spring:bind path="address.pin">
                     <td><input type="text"></td>
                     </spring:bind>
                </tr>

</table>
               <br><br> <input type="submit">
                </form>

    </div>
</body>
</html>