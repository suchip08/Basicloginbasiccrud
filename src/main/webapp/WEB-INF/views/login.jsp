<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Login</title>

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

        .wrapper {
            display: flex;
            gap: 30px;
        }

        .card {
            background: #ffffff;
            padding: 25px 30px;
            width: 320px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }

        h3 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
            color: #555;
        }

        input {
            width: 100%;
            padding: 9px;
            margin-top: 6px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 10px;
            margin-top: 18px;
            border: none;
            border-radius: 4px;
            background: #4CAF50;
            color: white;
            font-size: 15px;
            cursor: pointer;
        }

        button:hover {
            background: #43a047;
        }

        .login button {
            background: #2196F3;
        }

        .login button:hover {
            background: #1e88e5;
        }

        .error {
            color: red;
            text-align: center;
            margin-top: 10px;
            font-size: 14px;
        }
    </style>
</head>
<body>

<div class="wrapper">

    <!-- Public User Form -->
    <div class="card">
        <h3>Public User</h3>

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

</div>

</body>
</html>
