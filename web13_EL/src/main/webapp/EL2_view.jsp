<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>EL로 폼값 받아오기.</h2>
<b>1. 이전 방식으로 폼값 받아서 출력하기</b><br>
	ID : <%= request.getParameter("myId") %>
	<ul>
	<%String[] menus = request.getParameterValues("menu");
	for(String menu : menus){
	%>
		<li><%= menu %></li>
	<%	
	}
	%>
	</ul>
	<hr>
	
<b>2. EL 방식으로 폼값 받아서 출력하기</b><br>
	1)ID : ${param.myId}<br>
	<ul>2)Menus : 
	<li>${paramValues.menu[0]}</li>
	<li>${paramValues.menu[1]}</li>
	<li>${paramValues.menu[2]}</li>
	<li>${paramValues.menu[3]}</li>
	</ul>
</body>
</html>