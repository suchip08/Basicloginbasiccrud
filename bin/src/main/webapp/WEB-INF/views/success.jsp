<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Saved</title>

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

    .success-box {
        background: #ffffff;
        padding: 30px 40px;
        width: 360px;
        border-radius: 8px;
        box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        text-align: center;
    }

    h2 {
        color: #2e7d32;
        margin-bottom: 20px;
    }

    a {
        display: inline-block;
        padding: 10px 20px;
        background: #4CAF50;
        color: white;
        text-decoration: none;
        border-radius: 4px;
        font-size: 15px;
    }

    a:hover {
        background: #43a047;
    }
</style>
</head>
<body>

<div class="success-box">
    <h2>✅ User Saved Successfully</h2>
    <a href="/admin/login">Back</a>
</div>

</body>
</html>
