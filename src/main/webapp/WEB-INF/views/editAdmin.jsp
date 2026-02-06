<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Admin</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/simple.css">
    </head>
<body>
<%@ include file="includes/header.jsp" %>
<div class="container">
    <h2>Edit Admin</h2>
    <form action="/admin/update" method="post">
        <input type="hidden" name="id" value="${admin.id}">
        <label>Username</label>
        <input type="text" name="username" value="${admin.username}" required>
        <label>Password</label>
        <input type="password" name="password" value="${admin.password}" required>
        <label>Created By</label>
        <input type="text" value="${admin.createdBy}" readonly>
        <label>Creator Admin Id</label>
        <input type="text" value="${admin.createdByAdminId}" readonly>
        <button type="submit" class="btn-primary">Save</button>
    </form>
    <a class="back" href="/admin/list">⬅ Back to Admins</a>
</div>
<%@ include file="includes/footer.jsp" %>
</body>
</html>
