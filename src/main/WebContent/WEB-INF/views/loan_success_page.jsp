<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
    <div align="center">
        <h2>Loan Details</h2>
        <form:form  method="post" modelAttribute="loan">
            <table border="0" cellpadding="5">
                <tr>
                    <td>ID: </td>
                    <td>${loan.loanId}
                        <form:hidden path="loanId"/>
                    </td>
                </tr>
                <tr>
                    <td>Loan Name: </td>
                    <td>${loan.loanName}</td>
                </tr>
                <tr>
                    <td>Loan Amount: </td>
                    <td>${loan.loanAmount}</td>
                </tr>
                <tr>
                    <td>Customer ID: </td>
                    <td>${loan.customerId}</td>
                </tr>

                 <tr>
                     <td>Status: </td>
                     <td>${loan.status}</td>
                 </tr>
            </table>

        </form:form>
    </div>
     </br><a href="http://localhost:8080/Evaluation/customer/loginResult"><i>HOME</a></i>
</body>
</html>