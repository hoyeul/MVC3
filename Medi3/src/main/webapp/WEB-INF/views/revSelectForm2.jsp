<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.revDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% String path = request.getContextPath(); %>
<link rel="stylesheet" href="<%=path %>/css/revSelectForm2.css">
<script src="<%=path %>/js/revSelectForm2.js"></script>
</head>
<body>
<% 
	revDto dto = (revDto)request.getAttribute("dto");
%>
<form name="frm" action="revDeleteController.do">
<table>
	<caption>건강검진 예약 조회</caption>
	<tr>
		<td>예약번호</td>
		<td><input type="text" name="rev_num" value=<%=dto.getRev_num() %> readonly></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" value=<%=dto.getRev_name() %> readonly></td>
	</tr>
	<tr>
		<td>지역</td>
		<td><input type="text" value=<%=dto.getRev_location() %> readonly></td>
	</tr>
	<tr>
		<td>날짜</td>
		<td><input type="text" value=<%=dto.getRev_date() %> readonly></td>
	</tr>
	<tr>
		<td>시간</td>
		<td><input type="text" value=<%=dto.getRev_time() %> readonly></td>
	</tr>
	<tr>
		<td>프로그램</td>
		<td><input type="text" value=<%=dto.getRev_program() %> readonly></td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="button" onclick="cancel()">예약취소</button>
			<button type="button" onclick="window.location.href='home.do'">홈으로</button>
		</td>
	</tr>
</table>
<input type="hidden" name="rev_id", value=<%=dto.getRev_id() %>>
</form>
</body>
</html>