<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
    <h1>Đăng nhập hệ thống</h1>
    
    <h3 style="color: red;">${message}</h3>
    
    <form action="${pageContext.request.contextPath}/login" method="post">
        <div>
            <label>Username:</label>
            <input name="username" value="${param.username}">
        </div>
        <br>
        <div>
            <label>Password:</label>
            <input name="password" type="password">
        </div>
        <hr>
        <button type="submit">Login</button>
    </form>
</body>
</html>