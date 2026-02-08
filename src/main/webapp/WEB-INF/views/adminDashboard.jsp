<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/simple.css">
</head>

<body>
<%@ include file="includes/header.jsp" %>

<div class="wrapper">
    <div class="card" style="width:320px;">
        <h2>Admin Dashboard</h2>
        
        <div style="background-color: #ffe6e6; border: 1px solid #ffcccc; padding: 10px; margin-bottom: 10px; border-radius: 4px;">
            <strong>Data Quality Check:</strong><br>
            Users with Invalid Names: <strong>${invalidNameCount}</strong>
        </div>

        <a class="back" href="/admin/add">➕ Add Admin</a>
        <a class="back" href="/users">📋 View Users</a>
        <a class="back" href="/admin/list">🧑‍💼 View Admins</a>
        <a class="back" href="/vehicles">🚘 View Vehicles</a>
    </div>
    <div class="card">
        <h3>Quick Add User</h3>
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
            <input type="text" name="adhar">
            <label>PAN No</label>
            <input type="text" name="panNo">
            <label>Age</label>
            <input type="text" name="age">
            <label>Height</label>
            <input type="number" step="0.1" name="height">
            <button type="submit" class="btn-primary">Save User</button>
        </form>
    </div>
    <div class="card">
        <h3>Quick Add Vehicle</h3>
        <form action="/vehicles/save" method="post">
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
            <button type="submit" class="btn-primary">Save Vehicle</button>
        </form>
    </div>
</div>

<%@ include file="includes/footer.jsp" %>
</body>
</html>
