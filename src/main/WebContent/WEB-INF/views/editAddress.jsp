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
        <h2>Edit Details</h2>
<form:form action="saveAddress" method="post" modelAttribute="address">
            <table border="0" cellpadding="5">
                <tr>
                    <td>ID: </td>
                    <td>${address.addressId}
                     <form:hidden path="addressId"/>
                    </td>
                </tr>
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
                    <td colspan="2"><input type="submit" value="Save"></td>
                </tr>
            </table>
                                 </br><button onclick="history.back()"> Back</button>
        </form:form>
         </div>
        </body>
        </html>
