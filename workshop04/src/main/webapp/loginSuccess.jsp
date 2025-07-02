<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style>
	.cotainer{
		display: flex;
		align-items: center;
		justify-content: center;
	}
	.wrraper{
		align-items: center;
		border: 1px solid black;
	}
	h2{
		margin-bottom: 20px;
	}
</style>
</head>
<body>
<div class="container">
	<div class="wrraper">
		<h2 align="center"><%= request.getParameter("id") %> 님이 로그인 되었습니다.</h2>
		<h4 align="center"><a href="#">도서 등록</a></h4>
		<h4 align="center"><a href="./login.html">로그아웃</a></h4>
	</div>
</div>
</body>
</html>