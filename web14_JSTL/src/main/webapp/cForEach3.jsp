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
<h2>jstl forEach사용하기</h2>
<c:forEach begin="1" end="6" var="cnt">
	<font size=${cnt}>Wow~~ Today is Friday~~~</font><br>
</c:forEach>
</body>
</html>