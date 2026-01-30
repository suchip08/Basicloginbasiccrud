<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Users</title>

<style>
    body {
        font-family: Arial, Helvetica, sans-serif;
        background: #f4f6f9;
        padding: 40px;
        margin: 0;
    }

    h2 {
        text-align: center;
        margin-bottom: 25px;
        color: #333;
    }

    .table-container {
        max-width: 1000px;
        margin: auto;
        background: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    th, td {
        padding: 12px;
        text-align: left;
    }

    th {
        background: #4CAF50;
        color: white;
    }

    tr:nth-child(even) {
        background: #f9f9f9;
    }

    tr:hover {
        background: #f1f1f1;
    }

    .actions a {
        text-decoration: none;
        padding: 6px 10px;
        margin-right: 6px;
        border-radius: 4px;
        font-size: 14px;
        color: white;
    }

    .edit {
        background: #2196F3;
    }

    .edit:hover {
        background: #1e88e5;
    }

    .delete {
        background: #f44336;
    }

    .delete:hover {
        background: #e53935;
    }

    .back {
        display: inline-block;
        margin-top: 20px;
        text-decoration: none;
        color: #4CAF50;
        font-weight: bold;
    }
</style>
</head>

<body>

<h2>📋 User List</h2>

<div class="table-container">

    <table>
        <tr>
            <th>Name</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Address</th>
            <th>Actions</th>
        </tr>

        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.name}</td>
                <td>${user.phone}</td>
                <td>${user.email}</td>
                <td>${user.address}</td>
                <td class="actions">
                    <a class="edit" href="/users/edit/${user.id}">Edit</a>
                    <a class="delete"
                       href="/users/delete/${user.id}"
                       onclick="return confirm('Are you sure you want to delete this user?');">
                        Delete
                    </a>
                </td>
            </tr>
        </c:forEach>

        <c:if test="${empty users}">
            <tr>
                <td colspan="5" style="text-align:center;">No users found</td>
            </tr>
        </c:if>
    </table>

    <a class="back" href="/admin/dashboard">⬅ Back to Dashboard</a>

</div>

</body>
</html>
