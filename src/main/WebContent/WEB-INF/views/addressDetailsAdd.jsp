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
        <form:form  method="post" modelAttribute="address" action="/Evaluation/manager/saveAddress/${customer.customerId}">
            <table border="0" cellpadding="5">

                <tr>
                    <td>House Name: </td>
                    <td><form:input path="houseName" /></td>
                </tr>
                <tr>
                    <td>City: </td>
                    <td><form:input path="city" /></td>
                </tr>

                <tr>
                    <td>State: </td>
                    <td><form:input path="state" /></td>
                </tr>
                <tr>
                    <td>Pin Code: </td>
                    <td><form:input path="pin" /></td>
                </tr>
                <tr>
                <form modelAttribute="customer" >
                </tr>
                <tr>
                   <td> <input style="height:50px;width:120px" type="submit"  value="Save"/></td>
                </tr>
            </table>
                </form>
        </form:form>
      </br><button onclick="history.back()"> Back</button>
    </div>
</body>
</html>