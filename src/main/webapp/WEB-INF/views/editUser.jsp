<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit User</title>

   
</head>
<body>

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

        <button type="submit">Update User</button>
    </form>

<a href="${pageContext.request.contextPath}/admin/dashboard">⬅ Back to Admin Dashboard</a>

 
  
</div>

</body>
</html>
