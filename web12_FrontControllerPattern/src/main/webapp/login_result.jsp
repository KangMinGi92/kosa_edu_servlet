<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--
	1. 세션에 바인딩된 vo찾아와서
	2. 정보를 출력
  -->
 <%
	 Member vo = (Member)session.getAttribute("vo");
	 if(vo!=null){
 %>
 <h3>Login Information</h3>
 ID : <%= vo.getId() %><br>
 NAME : <%= vo.getName() %><br>
 ADDRESS : <%= vo.getAddress() %><br><br>
 <hr>
 <h3><a href="Logout.jsp"><b>Log Out</b></a></h3>
 <h3><a href="index.html"><b>INDEX</b></a></h3>
 <%
 }else{
%>
	<h3>로그인부터 다시 진행하세요.</h3>
	<h3><a href="index.html">INDEX</a></h3>
<%

 }
 %>
</body>
</html>