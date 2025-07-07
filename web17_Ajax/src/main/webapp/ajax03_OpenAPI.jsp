<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
$(function(){
	$("#serverSend").on('click',function(){
		//비동기 통신 연결....
		$.ajax({
			type : "get",
			url : "http://localhost:8888/weather.xml", // tomcat홈에서 webapp아래 ROOT가 디폴트 안써줘도 알아서 찾아감
			dataType:'xml',//응답!!되는 데이터의 타입을 미리지정
			
			success:function(result){
				let str = '';
				$(result).find('list').each(function(index,item){
					let region=$(this).find('region').text();
					let wind=$(this).find('wind').text();
					let temp=$(this).find('temp').text();
					let rain=$(this).find('rain').text();
					str += '<tr>';
					str += `<td>\${region}</td>`;
					str += `<td>\${wind}</td>`;
					str += `<td>\${temp}</td>`;
					str += `<td>\${rain}</td>`;
					str += '</tr>';
				});//each
				//remove...tbody직계자식은 tr의 모든것을 삭제하고
				$('tbody>tr>*').remove();
				$('tbody').append(str);
			}//callback(응답)
			
		});//ajax
	});//on
});//ready
</script>
</head>
<body>
	<div class="container">
		<div class="jumbotron text-center">
			<h2>=========== OPEN API Weather 데이터 가져오기 ===========</h2>
		</div>
		<p><a href="#" id="serverSend"><b>XML 데이터 요청하기</b></a></p>
		<table class="table table-hover">
			<thead class="thead-dark">
				<tr>
					<th>REGION</th>
					<th>WIND</th>
					<th>TEMP</th>
					<th>RAIN</th>
				</tr>
			</thead>
			<tbody>
				<!-- 이 부분에 공공데이터 받아온 것을 붙인다.  -->			
			</tbody>
		</table>
	</div>
</body>
</html>