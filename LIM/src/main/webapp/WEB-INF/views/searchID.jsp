<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="searchID" method="post">
	<h1> 등록된 회원정보로 아이디 찾기</h1>
	<table>
		<tr>
        	<td>가입시 입력한 이름과 핸드폰 번호를 입력해주세요.</td>
        </tr>
		<tr>	
			<td>
				<label>회원이름:</label>
				<input type="text" name="userName" id="userName" autofocus/>
			</td>
		</tr>
		<tr>	
			<td>
				<label>전화번호:</label>
				<input type="text" name="userTel" id="userTel" placeholder="000-0000-0000"/>
	        </td>
		</tr>
	</table>
	<input type="submit" value="찾기">
	<input type="button" value="취소" onclick="location.href='home.do'">
	
</form>

</body>
</html>