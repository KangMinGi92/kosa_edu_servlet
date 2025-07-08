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
/*
1)ID값의 길이가 4~8자 이여야 한다.
2) 1)조건을 만족하면 비동기 통신을 시작...
	해당 아이디가 존재하면 true
	해당 아이디가 없으면 false
*/
$(function(){
	$('#id').keyup(function(){
		let userId=$('#id').val();
		if(4<=userId.length && userId.length <=8){
			$.ajax({
				type : "post",
				url : "idExist.do",
				data : {'id':userId},
				
				success : function(result){
					if(result=='true')
						$('#resultView').html('<h3><font color=crimson>사용불가 ID!!</font></h3>');
					else
						$('#resultView').html('<h3><font color=blue>사용가능 ID!!</font></h3>');
				}else{
					$('#resultView').html('<h4>ID제약조건을 다시 확인하세요!!</h4>');
				}//if
			});//ajax
		}
	});//on
});//ready
</script>
</head>
<body>
<h2>REGISTER MEMBER FORM</h2>
<div id="wrap">
	<form action="register.do" method="post">
		ID <input type="text" name="id" id="id" required="required"><br><br>
		PASS <input type="password" name="password" required="required"><br><br>
		NAME <input type="text" name="name"><br><br>
		ADDR <input type="text" name="address"><br><br>
		<input type="submit" value="REGISTER">		
	</form>
</div>
</body>
</html>