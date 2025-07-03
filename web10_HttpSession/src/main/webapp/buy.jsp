<%@page import="servlet.model.Member"%>
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
session에서 바인딩된 정보를 찾아와서
vo, pvo 2개 바인딩... 2개 찾아온다

아랫부분에 출력
id,name, productname
  -->
<%
	Member vo=(Member)session.getAttribute("vo");
	String productName = (String)session.getAttribute("pvo");
	
	if(vo==null){
%>
	<h3>로그인부터 다시...</h3>
	<a href="Login.html">LOGIN PAGE</a>
<%		
	}
%>
<h2>결과를 출력합니다.</h2>
<h4>
ID <%= vo.getId() %><br>
NAME <%= vo.getName() %><br>
product <%= productName %><br>
</h4>
</body>
</html>