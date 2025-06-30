<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* 자바 코드를 사용할때는 이안에서 해야한다. */
	Member member=(Member)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Result Page</h2>
ID : <%= member.getId() %><br>
PASS : <%= member.getPass() %><br>
NAME : <%= member.getName() %><br>
</body>
</html>