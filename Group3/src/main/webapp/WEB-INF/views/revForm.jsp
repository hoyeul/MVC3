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
		num = Integer.parseInt(rs.getString(1));
	}


%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%  String path  = request.getContextPath(); %>
<link rel="stylesheet" href="<%=path %>/css/revForm.css">
<script src="<%=path %>/js/revForm.js"></script>
</head>
<body>

<form action="revController.do" method="post" name="frm">
<table class="revFrom_table">
<caption>건강검진 예약</caption>
<tr>
	<td>예약번호</td>
	<td><input type="text" name="rev_num" value="<%=num + 1%>" readonly></td>
</tr>
<tr>
	<td>이름</td>
	<td><input type="text" name="rev_name"></td>
</tr>
<tr>
	<td>날짜</td>
	<td><input type="date" name="rev_date"></td>
</tr>
<tr>
	<td>시간</td>
	<td>
		<select name="rev_time">
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
	<td>지역</td>
	<td>
		<input type="radio" name="rev_location" value="홍대점"> 홍대점
		<input type="radio" name="rev_location" value="강남점"> 강남점
	</td>
</tr>
<tr>
	<td>건강검진 프로그램</td>
	<td>
		<select name="rev_program">
			<option value="">선택</option>
			<option value="선택1">선택1</option>
			<option value="선택2">선택2</option>
			<option value="선택3">선택3</option>
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