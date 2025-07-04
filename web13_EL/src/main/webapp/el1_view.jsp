<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Result JSP Page</h2>
<b>1. JSP에서 원래 사용했던 방식으로 데이터 받아서 출력</b><br>
Request에 바인딩 한 값 : <%= request.getAttribute("RESULT1")%><br>
Session에 바인딩 한 값 : <%= session.getAttribute("RESULT2")%><br>
<hr>
<b>2. EL방식으로 데이터 받아서 출력</b><br>
<%-- 1) ${requestScope.RESULT1}<br>
2) ${sessionScope.RESULT2}<br> --%>
1) ${RESULT1}<br><!--request부터 scope가 작은 Attribute 부터 찾아서 있으면 출력 없으면 다음 scope로 올라감 -->
2) ${RESULT2}<br>
3) ${RESULT1 + 111}
</body>
</html>