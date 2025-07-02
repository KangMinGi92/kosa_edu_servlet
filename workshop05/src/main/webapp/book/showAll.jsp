<%@page import="servlet.model.Book"%>
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
		<h2>Book List</h2>
	</div>
  <table class="table table-dark table-hover text-center">
    <thead>
      <tr>
        <th>isbn</th>
       	<th>title</th>
        <th>catalogue</th>
        <th>nation</th>
        <th>publish_date</th>
        <th>publisher</th>
        <th>author</th>
        <th>price</th>
        <th>description</th>
      </tr>
    </thead>
    <tbody>
<%
	ArrayList<Book> list=(ArrayList<Book>)request.getAttribute("list");
	for(Book b:list){
%>
      <tr>
        <td><%= b.getIsbn() %></td>
        <td><%= b.getTitle()%></td>
        <td><%= b.getCatalogue()%></td>
        <td><%= b.getNation()%></td>
        <td><%= b.getPublish_date()%></td>
        <td><%= b.getPublisher()%></td>
        <td><%= b.getAuthor()%></td>
        <td><%= b.getPrice()%></td>
        <td><%= b.getDescription()%></td>
      </tr>
<%		
	}
%>
    </tbody>
  </table>
  <h3><a href="Book.html">추가 등록</a></h3>
</div>
</body>
</html>