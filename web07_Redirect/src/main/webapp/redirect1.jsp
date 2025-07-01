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
	String url="https://search.naver.com/search.naver?";
	String word=request.getParameter("word");
	url +="query="+word;
	
	//페이지 이동
	response.sendRedirect(url);
%>
<h3>redirect1.jsp 페이지가 몰라도 일단 응답은 합니다..
	그런데 응답을 하면서 헤더의 방향이 바뀔수 있도록 주소를 귀뜸합니다.
</h3>
</body>
</html>