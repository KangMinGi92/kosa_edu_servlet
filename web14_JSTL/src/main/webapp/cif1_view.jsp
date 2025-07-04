<!--
	JSTL
	1) jar파일 2개를 lib에 넣는다.
	2) taglib에 선언문이 필요
	
	core문법 중에서
	if, for
  -->

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
<h2>jstl if 사용법</h2>
<c:if test="${param.NUM == '100'}">
	<h4><b>100만원이 입금되었습니다.</b></h4>
</c:if>

<c:if test="${param.NUM == '200'}">
	<h4><b>200만원이 입금되었습니다.</b></h4>
</c:if>

<c:if test="${param.NUM != '100' or param.NUM != '200'}">
	<h4><b>입금액을 다시 확인한 후 거래 부탁드립니다.</b></h4>
</c:if>

</body>
</html>