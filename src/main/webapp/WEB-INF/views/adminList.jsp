<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admins</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/simple.css">
</head>
<body>
<%@ include file="includes/header.jsp" %>
<h2>Admins</h2>
<div class="table-container">
    <form method="get" action="/admin/list" style="display:flex;gap:10px;margin-bottom:12px;">
        <input type="text" name="q" value="${q}" placeholder="Search by username">
        <input type="hidden" name="size" value="${size}">
        <button type="submit" class="btn-primary">Search</button>
        <a class="back" href="/admin/list">Clear</a>
    </form>
    <table>
        <tr>
            <th>Username</th>
            <th>Created By</th>
            <th>Creator Admin Id</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="admin" items="${admins}">
            <tr>
                <td>${admin.username}</td>
                <td>${admin.createdBy}</td>
                <td>${admin.createdByAdminId}</td>
                <td class="actions">
                    <a class="action-btn edit" href="/admin/edit/${admin.id}">Edit</a>
                    <a class="action-btn delete" href="/admin/delete/${admin.id}" onclick="return confirm('Delete this admin?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty admins}">
            <tr><td colspan="4" style="text-align:center;">No admins found</td></tr>
        </c:if>
    </table>
    <div style="display:flex;justify-content:space-between;align-items:center;margin-top:10px;">
        <div>Page ${page + 1} of ${totalPages}</div>
        <div style="display:flex;gap:8px;">
            <c:if test="${page > 0}">
                <a class="back" href="/admin/list?q=${q}&page=${page - 1}&size=${size}">⬅ Prev</a>
            </c:if>
            <c:if test="${page + 1 < totalPages}">
                <a class="back" href="/admin/list?q=${q}&page=${page + 1}&size=${size}">Next ➡</a>
            </c:if>
        </div>
    </div>
    <a class="back" href="/admin/dashboard">⬅ Back to Dashboard</a>
</div>
<%@ include file="includes/footer.jsp" %>
</body>
</html>
