<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Vehicle</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/simple.css">
</head>
<body>
<%@ include file="includes/header.jsp" %>
<div class="container">
    <h2>Add Vehicle</h2>
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
        <input type="email" name="ownerEmail" required>
        <label>Vehicle No</label>
        <input type="text" name="vehicleNo" required>
        <button type="submit" class="btn-primary">Save Vehicle</button>
    </form>
    <a class="back" href="/vehicles">⬅ Back to Vehicle List</a>
</div>
<%@ include file="includes/footer.jsp" %>
</body>
</html>
