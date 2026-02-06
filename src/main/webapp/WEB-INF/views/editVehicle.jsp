<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Vehicle</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/simple.css">
</head>
<body>
<%@ include file="includes/header.jsp" %>
<div class="container">
    <h2>Edit Vehicle</h2>
    <form action="/vehicles/update" method="post">
        <input type="hidden" name="id" value="${vehicle.id}">
        <label>Type</label>
        <select name="type" required>
            <option ${vehicle.type == '2-wheeler' ? 'selected' : ''}>2-wheeler</option>
            <option ${vehicle.type == '3-wheeler' ? 'selected' : ''}>3-wheeler</option>
            <option ${vehicle.type == '4-wheeler' ? 'selected' : ''}>4-wheeler</option>
        </select>
        <label>Owner Name</label>
        <input type="text" name="ownerName" value="${vehicle.ownerName}" required>
        <label>Owner Number</label>
        <input type="text" name="ownerNumber" value="${vehicle.ownerNumber}" required>
        <label>Owner Email</label>
        <input type="email" name="ownerEmail" value="${vehicle.ownerEmail}" required>
        <label>Vehicle No</label>
        <input type="text" name="vehicleNo" value="${vehicle.vehicleNo}" required>
        <button type="submit" class="btn-primary">Save</button>
    </form>
    <a class="back" href="/vehicles">⬅ Back to Vehicle List</a>
</div>
<%@ include file="includes/footer.jsp" %>
</body>
</html>
