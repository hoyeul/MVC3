<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1> Main화면 입니다</h1>


<% String id  =(String) session.getAttribute("id");
if( id  != null){
%>
<a href="/Group3/logOut2">로그아웃</a>

<%
}
else{
%>
<a href="/Group3/login2.do2">로그인</a>
<%} %>

<a href="/Group3/index.html">주문하기</a>

</body>
</html>