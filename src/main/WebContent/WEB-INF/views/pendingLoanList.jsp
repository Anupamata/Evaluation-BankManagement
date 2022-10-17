    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
        Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    </head>
    <body>
    <div align="center">
        <h2>Details of all Pending Loans</h2>
        <table border="1" cellpadding="5">
            <tr>
                <th>Loan ID</th>
                <th>Loan Name</th>
                <th>Loan Amount</th>
                <th>Customer id</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${allPendingList}" var="loan">
            <tr>
                <td>${loan.loanId}</td>
                <td>${loan.loanName}</td>
                <td>${loan.loanAmount}</td>
                <td>${loan.customerId}</td>
                <td>${loan.status}</td>
                <td><a href="/Evaluation/manager/approveLoan/${loan.loanId}/${loan.customerId}">Approve</a>&nbsp;
                <a href="/Evaluation/manager/rejectLoan/${loan.loanId}">Reject</a></td>

            </tr>
            </c:forEach>
        </table>

	                     </br><button onclick="history.back()"> Back</button>

    </div>
    </body>
    </html>