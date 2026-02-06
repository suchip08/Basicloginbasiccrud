<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Users</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/simple.css">
</head>

<body>
<%@ include file="includes/header.jsp" %>

<h2>📋 User List</h2>

<div class="table-container">

    <form method="get" action="/users" style="display:flex;gap:10px;margin-bottom:12px;">
        <input type="text" name="q" value="${q}" placeholder="Search by name">
        <input type="hidden" name="size" value="${size}">
        <button type="submit" class="btn-primary">Search</button>
        <a class="back" href="/users">Clear</a>
    </form>

    <table>
        <tr>
            <th>Name</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Adhar</th>
            <th>PAN No</th>
            <th>Age</th>
            <th>Height</th>
            <th>Filled By</th>
            <th>Admin Id</th>
            <th>Actions</th>
        </tr>

        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.name}</td>
                <td>${user.phone}</td>
                <td>${user.email}</td>
                <td>${user.address}</td>
                <td>${user.adhar}</td>
                <td>${user.panNo}</td>
                <td>${user.age}</td>
                <td>${user.height}</td>
                <td>${user.filledBy}</td>
                <td>${user.addedByAdminId}</td>
                <td class="actions">
                    <a class="action-btn edit" href="/users/edit/${user.id}">Edit</a>
                    <a class="action-btn delete"
                       href="/users/delete/${user.id}"
                       onclick="return confirm('Are you sure you want to delete this user?');">
                        Delete
                    </a>
                </td>
            </tr>
        </c:forEach>

        <c:if test="${empty users}">
            <tr>
                <td colspan="5" style="text-align:center;">No users found</td>
            </tr>
        </c:if>
    </table>

    <div style="display:flex;justify-content:space-between;align-items:center;margin-top:10px;">
        <div>Page ${page + 1} of ${totalPages}</div>
        <div style="display:flex;gap:8px;">
            <c:if test="${page > 0}">
                <a class="back" href="/users?q=${q}&page=${page - 1}&size=${size}">⬅ Prev</a>
            </c:if>
            <c:if test="${page + 1 < totalPages}">
                <a class="back" href="/users?q=${q}&page=${page + 1}&size=${size}">Next ➡</a>
            </c:if>
        </div>
    </div>

    <a class="back" href="/admin/dashboard">⬅ Back to Dashboard</a>

</div>

<%@ include file="includes/footer.jsp" %>
</body>
</html>
