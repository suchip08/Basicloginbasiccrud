<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vehicles</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/simple.css">
</head>
<body>
<%@ include file="includes/header.jsp" %>
<h2>Vehicles</h2>
<div class="table-container">

    <table>
        <tr>
            <th>Type</th>
            <th>Owner Name</th>
            <th>Owner Number</th>
            <th>Owner Email</th>
            <th>Vehicle No</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="v" items="${vehicles}">
            <tr>
                <td>${v.type}</td>
                <td>${v.ownerName}</td>
                <td>${v.ownerNumber}</td>
                <td>${v.ownerEmail}</td>
                <td>${v.vehicleNo}</td>
                <td class="actions">
                    <a class="action-btn edit" href="/vehicles/edit/${v.id}">Edit</a>
                    <a class="action-btn delete" href="/vehicles/delete/${v.id}" onclick="return confirm('Delete this vehicle?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty vehicles}">
            <tr><td colspan="6" style="text-align:center;">No vehicles found</td></tr>
        </c:if>
    </table>
    
    <a class="back" href="/admin/dashboard">⬅ Back to Dashboard</a>
</div>
<%@ include file="includes/footer.jsp" %>
</body>
</html>
