<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		let rev_num = prompt("예약번호를 입력하세요");
		//alert(id);
	<% 
		String driver = "oracle.jdbc.driver.OracleDriver" ;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="system";
		String password="1234";
	
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, password);	
		
		String sql = " select rev_num from rev where rev_id = ? ";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, (String)session.getAttribute("sessionID"));
		ResultSet rs = pst.executeQuery();
	%>
	if(rev_num != null){
	<%	if(rs.next()){ %>
			if(rev_num == <%=rs.getString(1) %>){
				window.location.href="/Medi3/revUpdateController2.do?rev_num=" + rev_num;
			}
			else{
				alert("예약번호가 잘못되었습니다");
				window.location.href="/Medi3/revUpdateController.do?rev_num=" + rev_num;
			}
	<% } %>
	}else{window.location.href="home.do";}
	})
</script>


</head>
<body>

</body>
</html>