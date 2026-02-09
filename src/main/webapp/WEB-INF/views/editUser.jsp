<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit User</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/simple.css">
</head>
<body>
<%@ include file="includes/header.jsp" %>

<div class="container">

    <h2>Edit User</h2>

    <form action="/users/update" method="post">
        <input type="hidden" name="id" value="${user.id}">

        <label>Name  *</label>
        <input type="text" name="name" value="${user.name}" required>

        <label>Phone *</label>
        <input type="text" name="phone" value="${user.phone}" required>

        <label>Email</label>
        <input type="email" name="email" value="${user.email}">

        <label>Address</label>
        <input type="text" name="address" value="${user.address}">

        <label>Adhar</label>
        <input type="text" name="adhar" value="${user.adhar}">

        <label>PAN No</label>
        <input type="text" name="panNo" value="${user.panNo}">

        <label>Age</label>
        <input type="text" name="age" value="${user.age}">

        <label>Height</label>
        <input type="number" step="0.1" name="height" value="${user.height}">

        <button type="submit" class="btn-primary">Update User</button>
    </form>

<a class="back" href="${pageContext.request.contextPath}/admin/dashboard">⬅ Back to Admin Dashboard</a>

 
  
</div>

<%@ include file="includes/footer.jsp" %>
</body>
</html>
