<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String driver = "oracle.jdbc.driver.OracleDriver" ;
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="system";
	String password="1234";

	Class.forName(driver);
	Connection con = DriverManager.getConnection(url, user, password);
	
	String sql = "select rev_num from rev where ROWNUM = 1 order by rev_num desc";
	PreparedStatement pst = con.prepareStatement(sql);
	ResultSet rs = pst.executeQuery();

	int num = 0;
	if(rs.next()){
		num = Integer.parseInt(rs.getString(1))+1;
	}
	
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<% String path  = request.getContextPath(); %>
<link rel="stylesheet" href="<%=path %>/css/revInsertForm.css">
<script src="<%=path %>/js/revInsertForm.js"></script>
<script>
	
	
</script>
</head>
<body>

<form action="revInsertController.do" method="post" name="frm">
<table class="revFrom_table">
<caption>건강검진 예약</caption>
<tr>
	<td>예약번호</td>
	<td><input type="text" name="rev_num" value="<%=num %>" readonly></td>
	<!-- 예약번호 자동 생성(해결) -->
</tr>
<tr>
	<td>이름</td>
	<td><input type="text" name="rev_name"></td>
	<!-- 로그인한 사람 이름 연결받아서 박아두기 -->
</tr>
<tr>
	<td>지역</td>
	<td>
		<input type="radio" id="hong" name="rev_location" value="홍대점" onchange="change()" checked> 홍대점
		<input type="radio" id="gang" name="rev_location" value="강남점" onchange="change()"> 강남점
	</td>
	<!-- js로 onchange일 때 다르게 나오게(해결) -->
</tr>
<tr>
	<td>날짜</td>
	<td><input type="text" name="rev_date" id="datepicker"></td>
	<!-- js로, 라이브러리 확인(해결) -->
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
			<!-- 이미 예약된 시간 안보이게 하기 -->
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
		<button type="button" onclick="save()">예약</button>
		<button type="button" onclick="window.location.href='index.html'">취소</button>
	</td>
</tr>
</table>
</form>

</body>
</html>