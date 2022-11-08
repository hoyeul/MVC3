<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.revDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<% String path = request.getContextPath(); %>
<link rel="stylesheet" href="<%=path %>/css/revUpdateForm2.css">
<script src="<%=path %>/js/revUpdateForm2.js"></script>
</head>
<body>
<% 
	revDto dto = (revDto)request.getAttribute("dto");
%>
<form name="frm" action="revUpdateController3.do" method="post">
<table>
	<caption>건강검진 예약 조회</caption>
	<tr>
		<td>예약번호</td>
		<td><input type="text" name="rev_num" value=<%=dto.getRev_num() %> readonly></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="rev_name" value=<%=dto.getRev_name() %> readonly></td>
	</tr>
	<tr>
	<tr>
		<td>지역</td>
		<td>
			<input type="radio" id="hong" name="rev_location" value="홍대점" onchange="change()" checked> 홍대점
			<input type="radio" id="gang" name="rev_location" value="강남점" onchange="change()"> 강남점
		</td>
	</tr>
	<tr>
		<td>날짜</td>
		<td><input type="text" name="rev_date" id="datepicker"></td>
	</tr>
	<tr>
		<td>시간</td>
		<td>
			<select name="rev_time" id="rev_time" disabled>
				<option value="">선택</option>
				<option value="09:00">09:00</option>
				<option value="10:00">10:00</option>
				<option value="11:00">11:00</option>
				<option value="12:00">12:00</option>
				<option value="13:00">13:00</option>
				<option value="14:00">14:00</option>
				<option value="15:00">15:00</option>
				<option value="16:00">16:00</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>건강검진 프로그램</td>
		<td>
			<select name="rev_program">
				<option value="">선택</option>
				<option value="선택1" id="hong1">선택1</option>
				<option value="선택2" id="hong2">선택2</option>
				<option value="선택3" id="gang1" hidden>선택3</option>
				<option value="선택4" id="gang2" hidden>선택4</option>
			</select>
		</td>
	</tr>	
	<tr>
		<td colspan="2">
			<button type="button" onclick="edit()">예약수정</button>
			<button type="button" onclick="window.location.href='index.html'">홈으로</button>
		</td>
	</tr>
</table>
</form>
</body>
</html>