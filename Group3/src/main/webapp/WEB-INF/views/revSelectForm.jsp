<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	let rev_num = prompt("예약번호를 입력하세요");
	$.ajax(
			 {
				 type:"post",
				 dataType:"text",              
				 url:"/Group3/revSelectController.do",
				 data:{rev_num:rev_num}
				 success: function( data, textStatus){
				    alert("ok");
				 }
				 ,
				 error: function( data, textStatus){
					 alert("error");
				 },		 
				 complete:function(data, textStatus){
					 alert("done");
				 }		 
			}
		 );
}
</script>
</head>
<body>

</body>
</html>