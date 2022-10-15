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
        <h2>Customer Details</h2>
        <form:form  method="post" modelAttribute="customer">
            <table border="0" cellpadding="5">
                <tr>
                    <td>ID: </td>
                    <td>${customer.customerId}
                        <form:hidden path="customerId"/>
                    </td>
                </tr>
                <tr>
                    <td>Name: </td>
                    <td>${customer.custName}</td>
                </tr>
                <tr>
                    <td>Username: </td>
                    <td>${customer.username}</td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td>${customer.password}</td>
                </tr>
                 <tr>
                     <td>Account Number: </td>
                     <td>${customer.accNo}</td>
                 </tr>
                 <tr>
                     <td>Balance: </td>
                     <td>${customer.balance}</td>
                 </tr>
                 <tr>
                     <td>Address id: </td>
                     <td>${customer.addressId}</td>
                 </tr>
                 <tr>
                     <td>Gender: </td>
                     <td>${customer.gender}</td>
                 </tr>
            </table>

        </form:form>
<h3>Address Details</h3>
        <form:form  method="post" modelAttribute="address">

                    <table border="0" cellpadding="5">

                        <tr>
                            <td>House Name: </td>
                            <td>${address.houseName}</td>
                        </tr>
                        <tr>
                            <td>City: </td>
                            <td>${address.city}</td>
                        </tr>
                        <tr>
                            <td>State: </td>
                            <td>${address.state}</td>
                        </tr>
                        <tr>
                            <td>Pin Code: </td>
                            <td>${address.pin}</td>
                        </tr>

                    </table>
                </form:form>

    </div>
     </br><a href="http://localhost:8080/Evaluation/customer/loginResult"><i>HOME</a></i>
</body>
</html>