<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원님의 패스워드는
 <%
   String userpw = (String)request.getAttribute("pwResult");
   out.println( userpw);
  
 %>
 입니다.
 <a href="/Medi3/login.do">로그인하러 가기</a>
 <a href="/Medi3/home.do">홈으로</a>
</body>
</html>