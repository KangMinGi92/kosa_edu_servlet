<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>ArrayList를 사용하기</h2>
<%
	ArrayList<String> fruits = new ArrayList<>();
	fruits.add("Apple");
	fruits.add("Banana");
	fruits.add("WarterMelone");
	fruits.add("Grape");
	fruits.add("Orange");
	
	request.setAttribute("fruits",fruits);
	
	request.getRequestDispatcher("cForEach4_view.jsp").forward(request, response);
%>
</body>
</html>