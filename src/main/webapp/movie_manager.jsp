<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 목록 관리 페이지</title>
<style type="text/css">
	.container{
		width: 1200px;
		margin:0 auto;
	}
	.container > table {
		width: 100%;
		table-layout: fixed;
	}
	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#frm").submit(function(e){
			e.preventDefault();
			var d = $(this).serialize();
			//alert(d);
			$.ajax({
				url : "insertMovie.do",
				data : d,
				type:"get",
				dataType:"json",
				success:function(r){
					//데이터 등록이 완료되면 결과값으로 현재 저장된 모든 영화 정보를 읽어와서
					//container에 출력
					var tag = "<table>";
					for(i=0;i<r.length;i++){
						tag += "<tr>";
						tag += "<td>" + r[i].bno + "</td>";
						tag += "<td>" + r[i].title + "</td>";
						tag += "<td>" + r[i].openDate + "</td>";
						tag += "<td>" + r[i].audienceCount + "</td>";
						tag += "<td>" + r[i].director + "</td>";
						tag += "</tr>";
					}
					tag +="</table>"
					$(".container").html(tag);
				},
				error:function(xhr,text,error){
					//경고창으로 에러 메세지를 출력
					console.log(xhr.status, xhr.responseText);
					alert(xhr.responseText);
				}
			});
		});
	});
</script>
</head>
<body>
	<!-- 
		영화정보 한건 입력 받는 폼
		호출할 url : insertMovie.do
		영화제목, 개봉일, 누적관객수, 감독		
	 -->
	 <form id="frm">
	 	<input type="text" name="title" placeholder="영화 제목">
	 	<input type="date" name="open_date" placeholder="개봉일">
	 	<input type="text" name="audience_count" placeholder="누적 관객 수">
	 	<input type="text" name="director" placeholder="감독">
	 	<button>등록</button>
	 </form>
	 <hr>
	 <!-- 등록 후 결과를 출력하는 영역 -->
	 <div class="container">
	 
	 </div>
</body>
</html>





