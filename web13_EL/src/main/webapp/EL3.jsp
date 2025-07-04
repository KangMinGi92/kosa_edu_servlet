<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Member vo = new Member("kosa","1234","James","Texas");
	request.setAttribute("vo", vo);
	request.getRequestDispatcher("EL3_view.jsp").forward(request, response);
%>
</body>
</html>