<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function logoout(){
		alert("LogOut!!");
	}
</script>
</head>
<!--
로그아웃 로직::::
1) user를 찾아와서
2) user가 있다면
3) 세션을 죽인다
-->
<body onload="return logout()">
<%
	Member user = (Member)session.getAttribute("vo");
	if(user !=null){ //로그인이 되어져 있다면
		session.invalidate();
%>
<% 
	}
%>
<h3><b> 로그아웃 되었습니다.</b><br>
<a href="login.jsp">Home</a></h3>
</body>
</html>