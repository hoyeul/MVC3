<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<script>
let rev_num = prompt("예약번호를 입력하세요");
window.location.href="/Medi3/revUpdateOverlap.do?rev_num=" + rev_num;
</script>
</head>
<body>

</body>
</html>