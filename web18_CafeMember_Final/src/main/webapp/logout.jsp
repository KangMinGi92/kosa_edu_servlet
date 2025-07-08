<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
window.onload= ()=>{
		alert("LogOut!!");
		location.href="index.jsp";
	};
</script>
</head>
<!--
로그아웃 로직::::
1) user를 찾아와서
2) user가 있다면
3) 세션을 죽인다
-->
<body>
</body>
</html>