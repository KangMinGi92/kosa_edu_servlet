<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> Result JSP Page</h2>
<b>1. vo 정보를 EL로 출력하기</b><br>
${vo}
<hr>
<b>2. vo 의 각각의 정보를 출력하기</b><br>
1) ID : ${vo.id} <br>  <!--EL자체가 getter라서 Value.변수명  -->
2) NAME : ${vo.name}<br>
3) ADDRESS : ${vo.address}<br>
</body>
</html>