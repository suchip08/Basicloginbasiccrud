<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

<style>
    body {
        font-family: Arial, Helvetica, sans-serif;
        background: #f4f6f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    .dashboard {
        background: #ffffff;
        padding: 30px 40px;
        width: 350px;
        border-radius: 8px;
        box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        text-align: center;
    }

    h2 {
        margin-bottom: 25px;
        color: #333;
    }

    .dashboard a {
        display: block;
        padding: 12px;
        margin: 10px 0;
        text-decoration: none;
        background: #4CAF50;
        color: white;
        border-radius: 4px;
        font-size: 16px;
        transition: background 0.2s ease;
    }

    .dashboard a:hover {
        background: #43a047;
    }
</style>
</head>

<body>

<div class="dashboard">
    <h2>Admin Dashboard</h2>

    <a href="/admin/add">➕ Add Admin</a>
    <a href="/users/add">👤 Add User</a>
    <a href="/users">📋 View Users</a>
</div>

</body>
</html>
