<%@page import="web.servlet.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
	<div class="jumbotron text-center">
		<h2>Product List</h2>
	</div>
  <table class="table table-dark table-hover text-center">
    <thead>
      <tr>
        <th>상 품 번 호</th>
       	<th>상 	품 	명</th>
        <th>상 품 가 격</th>
        <th>상 세 설 명</th>
      </tr>
    </thead>
    <tbody>
<%
	ArrayList<Product> products=(ArrayList<Product>)request.getAttribute("pvo");
	for(Product p:products){
%>
      <tr>
        <td><%= p.getNum()%></td>
        <td><%= p.getName()%></td>
        <td><%= p.getPrice()%></td>
        <td><%= p.getDetail()%></td>
      </tr>
<%		
	}
%>
    </tbody>
  </table>
  <h3><a href="./index.html">INDEX</a></h3>
</div>
</body>
</html>