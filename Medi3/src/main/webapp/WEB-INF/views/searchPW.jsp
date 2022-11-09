<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function pwSearch(){
	if ( document.searchPw.userID.value == "") {
		alert("아이디를 입력해주세요");
		searchPw.userID.focus();
		return false;
	}
	else if (document.searchPw.userName.value == ""){
			alert("이름을 입력해주세요");
			searchPw.userName.focus();
			return false;
	}
	// 만약 값이 다 넘어왔다면 전송
	document.searchPw.submit();
}
</script>
</head>
<body>

<form action="searchPW" method="post" name="searchPw">
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
	<input type="button" value="찾기" onclick="pwSearch()">
	<input type="button" value="취소" onclick="location.href='home.do'">
	
</form>

</body>
</html>