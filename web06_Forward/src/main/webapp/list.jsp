<%@page import="java.util.ArrayList"%>
<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Member> list= new ArrayList<>();
	list.add(new Member("aaa","111","James"));
	list.add(new Member("bbb","222","Scott"));
	
	//Member vo=(Member)request.getAttribute("vo");
	//Member vo=(Member)session.getAttribute("vo");
	Member vo=(Member)application.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Member List</h2>
<% 
	for(Member mem : list){
%>
	ID <%= mem.getId() %> <br>
	PASS <%= mem.getPass() %> <br>
	NAME <%= mem.getName() %> <br>
<%
	}
%>
<hr>
<h2> Register Member</h2>
ID <%= vo.getId() %><br>
NAME <%= vo.getName() %><br>
</body>
</html>