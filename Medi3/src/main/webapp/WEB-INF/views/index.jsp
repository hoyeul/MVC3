<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	
	<h1>로그인 테스트 메인페이지 입니다.</h1>
	
<% String id  =(String) session.getAttribute("sessionID");
out.print(id);
if( id  !=  null){
%>
<a href="/Medi3/logout.do">로그아웃</a>

<%
}
else{
%>
<a href="/Medi3/login.do">로그인</a>
<%} %>

<a href="revInsertController.do">예약하기</a>
<a href="revSelectController.do">예약조회</a>
<a href="revUpdateController.do">예약변경</a>

</body>
</html>