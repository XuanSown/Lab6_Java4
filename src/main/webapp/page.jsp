<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Trang chủ Lab 6</title>
</head>
<body>
    <h1>Xin chào!</h1>
    <h3 style="color: blue;">${message}</h3>
    
    <hr>
    <p>Menu thử nghiệm:</p>
    <ul>
        <li><a href="${pageContext.request.contextPath}/account/edit-profile">Edit Profile (Cần login)</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/user">Admin User (Cần Admin)</a></li>
        <li><a href="${pageContext.request.contextPath}/video/list">Video List (Công khai)</a></li>
    </ul>
</body>
</html>