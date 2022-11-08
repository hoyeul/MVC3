<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="searchPW" method="post">
	<h1> 등록된 회원정보로 패스워드 찾기</h1>
	<table>
		<tr>
        	<td> 아이디와 회원 이름을 입력해주세요.</td>
        </tr>
		<tr>	
			<td>
				<label>아이디:</label>
				<input type="text" name="userID" id="userID" autofocus/>
			</td>
		</tr>
		<tr>	
			<td>
				<label>회원이름:</label>
				<input type="text" name="userName" id="userName"/>
	        </td>
		</tr>
	</table>
	<input type="submit" value="찾기">
	<input type="button" value="취소" onclick="location.href='/WEB-INF/views/index.jsp'">
	
</form>

</body>
</html>