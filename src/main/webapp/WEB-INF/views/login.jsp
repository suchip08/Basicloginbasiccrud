<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/simple.css">
</head>
<body>
<%@ include file="includes/header.jsp" %>

<div class="wrapper">

    <!-- Public User Form -->
    <div class="card">
        <h3>Public User</h3>

        <c:if test="${not empty registrationError}">
            <div style="color: red; margin-bottom: 10px;">${registrationError}</div>
        </c:if>

        <form action="/users/save" method="post">
            <input type="hidden" name="source" value="PUBLIC">

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

            <button type="submit">Save</button>
        </form>
    </div>

    <!-- Admin Login -->
    <div class="card login">
        <h3>Admin Login</h3>

        <form action="/admin/login" method="post">

            <label>Username</label>
            <input type="text" name="username" required>

            <label>Password</label>
            <input type="password" name="password" required>

            <button type="submit">Login</button>
        </form>

        <p class="error">${error}</p>
    </div>

    <!-- Vehicle Quick Form -->
    <div class="card">
        <h3>Vehicle</h3>
        <form action="/vehicles/save" method="post">
            <input type="hidden" name="source" value="PUBLIC">
            <label>Type</label>
            <select name="type" required>
                <option value="">Select type</option>
                <option>2-wheeler</option>
                <option>3-wheeler</option>
                <option>4-wheeler</option>
            </select>
            <label>Owner Name</label>
            <input type="text" name="ownerName" required>
            <label>Owner Number</label>
            <input type="text" name="ownerNumber" required>
            <label>Owner Email</label>
            <input type="email" name="ownerEmail">
            <label>Vehicle No</label>
            <input type="text" name="vehicleNo">
            <button type="submit">Save Vehicle</button>
        </form>
    </div>

</div>

<%@ include file="includes/footer.jsp" %>
</body>
</html>
