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
    <div align="center">
        <h2>Details of all Customers</h2>
        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>See Details</th>
            </tr>
            <c:forEach items="${allPersons}" var="customer">
            <tr>
                <td>${customer.customerId}</td>
                <td>${customer.custName}</td>
                <td><a href="/Evaluation/customer/fetchById/${customer.customerId}">Details</a></td>

            </tr>
            </c:forEach>
        </table>

         </br><a href="http://localhost:8089/Evaluation/"><i>HOME</a></i>

    </div>
    </body>
    </html>