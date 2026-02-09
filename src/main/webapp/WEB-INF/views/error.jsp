<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Error Occurred</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/simple.css">
</head>
<body>
<div class="card" style="border-top: 5px solid #ff4444;">
    <h2 style="color: #d32f2f;">⚠ Something Went Wrong</h2>
    
    <div style="background: #fff0f0; padding: 15px; border-radius: 4px; margin: 15px 0;">
        <strong>Error Type:</strong> ${errorType} <br>
        <strong>Message:</strong> ${errorMessage}
    </div>

    <p>Please contact the administrator or check the server console for details.</p>
    
    <a href="/admin/login" class="back">⬅ Return to Login</a>
</div>
</body>
</html>
