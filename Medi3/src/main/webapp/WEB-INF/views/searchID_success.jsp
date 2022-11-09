<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원님의 아이디는
 <%
   String userid = (String)request.getAttribute("idResult");
   out.println( userid);
  
 %>
 입니다.
<a href="/Medi3/login.do">로그인하러 가기</a>
<a href="/Medi3/searchPW">비밀번호 찾으러 가기</a>

</body>
</html>