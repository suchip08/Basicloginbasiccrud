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
    <form method="get" action="/vehicles" style="display:flex;gap:10px;margin-bottom:12px;">
        <input type="text" name="q" value="${q}" placeholder="Search owner or number">
        <input type="hidden" name="size" value="${size}">
        <button type="submit" class="btn-primary">Search</button>
        <a class="back" href="/vehicles">Clear</a>
    </form>
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
    <div style="display:flex;justify-content:space-between;align-items:center;margin-top:10px;">
        <div>Page ${page + 1} of ${totalPages}</div>
        <div style="display:flex;gap:8px;">
            <c:if test="${page > 0}">
                <a class="back" href="/vehicles?q=${q}&page=${page - 1}&size=${size}">⬅ Prev</a>
            </c:if>
            <c:if test="${page + 1 < totalPages}">
                <a class="back" href="/vehicles?q=${q}&page=${page + 1}&size=${size}">Next ➡</a>
            </c:if>
        </div>
    </div>
    <a class="back" href="/admin/dashboard">⬅ Back to Dashboard</a>
</div>
<%@ include file="includes/footer.jsp" %>
</body>
</html>
