<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add User</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/simple.css">
</head>
<body>
<%@ include file="includes/header.jsp" %>

<div class="container">

    <h2>Add User (Admin)</h2>

    <form action="/users/save" method="post">
        <input type="hidden" name="source" value="ADMIN">

        <label>Name</label>
        <input type="text" name="name" required>

        <label>Phone</label>
        <input type="text" name="phone">

        <label>Email</label>
        <input type="email" name="email">

        <label>Address</label>
        <input type="text" name="address">

        <label>Adhar</label>
        <input type="text" name="adhar" placeholder="Enter adhar">
        <small>If left blank: not provide</small>

        <label>PAN No</label>
        <input type="text" name="panNo" placeholder="Enter PAN">
        <small>If left blank: not given</small>

        <label>Age</label>
        <input type="text" name="age" placeholder="Enter age">
        <small>If left blank: not provide age</small>

        <label>Height</label>
        <input type="text" name="height" placeholder="Enter height">
        <small>If left blank: 4.5</small>

        <button type="submit" class="btn-primary">Save User</button>
    </form>

    <a class="back" href="/users">⬅ Back to User List</a>

</div>

<%@ include file="includes/footer.jsp" %>
</body>
</html>
