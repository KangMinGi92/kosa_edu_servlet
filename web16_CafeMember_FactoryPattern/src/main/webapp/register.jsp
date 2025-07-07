<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h2{
		text-align: center;
		color: purple;
	}
	#wrap{
		margin-left: 220px;		
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$(function(){
	$('#idCheck').on('click',function(){
		let userId=$('#id').val();
		$.ajax({
			type : "post",
			url : "idExist.do",
			data : {'id':userId},
			
			success : function(result){
				if(result=='true')
					$('#resultView').html('<h3><font color=crimson>사용불가 ID!!</font></h3>');
				else
					$('#resultView').html('<h3><font color=blue>사용가능 ID!!</font></h3>');
			}
		});//ajax
	});//on
});//ready
</script>
</head>
<body>
<h2>REGISTER MEMBER FORM</h2>
<div id="wrap">
	<form action="register.do" method="post">
		ID <input type="text" name="id" id="id" required="required">
		<input type="button" value="중복확인" id="idCheck"><span id="resultView"></span><br><br>
		PASS <input type="password" name="password" required="required"><br><br>
		NAME <input type="text" name="name"><br><br>
		ADDR <input type="text" name="address"><br><br>
		<input type="submit" value="REGISTER">		
	</form>
</div>
</body>
</html>