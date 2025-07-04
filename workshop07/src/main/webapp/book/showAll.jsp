
<%@page import="web.servlet.model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<title>Insert title here</title>
<STYLE TYPE="text/css"> table {font-size: 9pt;} </STYLE>
</head>
<body>
	<div class="container">
	<div class="jumbotron text-center">
		<h2>전체 도서 List 보기</h2>
	</div>
	<table class="table">
		<thead class="thead-dark">
			<tr>
			<th>ISBN</th>
			<th>TITLE</th>
			<th>Catalogue</th>
			<th>Nation</th>
			<th>Publish Date</th>
			<th>Publisher</th>
			<th>Author</th>
			<th>Price</th>
			<th>Description</th>
			</tr>
		</thead>
		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.isbn}</td>
				<td>${book.title}</td>
				<td>${book.catalogue}</td>
				<td>${book.nation}</td>
				<td>${book.publish_date}</td>
				<td>${book.publisher}</td>
				<td>${book.author}</td>
				<td>${book.price}원</td>
				<td>${book.description}</td>
				
			</tr>
		</c:forEach>
	</table>
	<h3 align="center"><a href="${pageContext.request.contextPath}/Book.html">등록 화면으로</a></h3>
	<h3 align="center"><a href="${pageContext.request.contextPath}/login.html">로그인 화면으로</a></h3>
	</div>
</body>
</html>