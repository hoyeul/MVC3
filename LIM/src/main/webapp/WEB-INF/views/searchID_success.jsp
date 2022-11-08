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
</body>
</html>