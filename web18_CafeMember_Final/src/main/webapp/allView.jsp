<%@page import="web.servlet.model.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">회원 전체 명단 보기</h2>
<table border="2" width="400px" bgcolor="yellow" align="center">
<c:forEach items="${list}" var="vo">
	<tr>
		<td>${vo.id}</td>
		<td>${vo.name}</td>
		<td>${vo.address}</td>
	</tr>
</c:forEach>
<%-- <%
	for(Member vo : list){		
%>
	<tr>
		<td><%= vo.getId() %></td>
		<td><%= vo.getName() %></td>
		<td><%= vo.getAddress() %></td>
	</tr>
<%		
	}
%> --%>
</table>
<p><h3 align="center"><a href="index.jsp">INDEX..</a></h3></p>
</body>
</html>




















