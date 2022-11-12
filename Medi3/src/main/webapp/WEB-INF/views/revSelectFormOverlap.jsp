<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<script>
<% String rev_num = (String)request.getAttribute("rev_num"); %>
window.location.href="/Medi3/revSelectController2.do?rev_num=" + <%=rev_num %>;
</script>
</head>
<body>

</body>
</html>