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

    <table>
        <tr>
            <th>Username</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="admin" items="${admins}">
            <tr>
                <td>${admin.username}</td>
                <td class="actions">
                    <a class="action-btn edit" href="/admin/edit/${admin.id}">Edit</a>
                    <a class="action-btn delete" href="/admin/delete/${admin.id}" onclick="return confirm('Delete this admin?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empty admins}">
            <tr><td colspan="2" style="text-align:center;">No admins found</td></tr>
        </c:if>
    </table>
    
    <a class="back" href="/admin/dashboard">⬅ Back to Dashboard</a>
</div>
<%@ include file="includes/footer.jsp" %>
</body>
</html>
