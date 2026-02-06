<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Admin</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/simple.css">
</head>
<body>
<%@ include file="includes/header.jsp" %>

<div class="container">

    <h2>Add New Admin</h2>

    <form action="/admin/save" method="post">

        <label>Username:</label>
        <input type="text" name="username" required>

        <br><br>

        <label>Password:</label>
        <input type="password" name="password" required>

        <br><br>

        <button type="submit" class="btn-primary">Save Admin</button>
    </form>

    <a class="back" href="/admin/login">⬅ Back to Login</a>

</div>

<%@ include file="includes/footer.jsp" %>
</body>
</html>
