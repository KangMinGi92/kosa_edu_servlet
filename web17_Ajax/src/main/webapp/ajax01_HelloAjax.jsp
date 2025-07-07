<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$(function(){
	$("#ajaxBtn").on('click',function(){
		//비동기 통신 시작...
		$.ajax({
			//요청
			type:"get",
			url:"http://localhost:8888/web17_Ajax/bank.json",
			
			//응답
			success:function(resultData){
				alert(resultData.data);
			},
			error : function(error){
				alert(error);
			}
		});//ajax
	});//on
});//ready
</script>
</head>
<body>
<h3>버튼 클릭시 비동기 통신 시작</h3>
<input type="button" value="JQuery Ajax" id="ajaxBtn">
</body>
</html>