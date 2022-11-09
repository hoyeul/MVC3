<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function idSearch(){
	if ( document.searchId.userName.value == "") {
		alert("이름을 입력해주세요");
		searchId.userName.focus();
		return false;
	}
	else if (document.searchId.userTel.value == ""){
			alert("전화번호를 입력해주세요");
			searchId.userTel.focus();
			return false;
	}
	// 만약 값이 다 넘어왔다면 전송
	document.searchId.submit();
}
</script>

</head>
<body>

<form action="searchID" method="post" name="searchId">
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
	<input type="button" value="찾기" onclick="idSearch()">
	<input type="button" value="취소" onclick="location.href='home.do'">
	
</form>

</body>
</html>