<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>올 상반기 가게에서 가장 많이 판매되는 과일들입니다.</h2>
<c:forEach items="${fruits}" var="item">
	<li>${item}</li>
</c:forEach>
</body>
</html>