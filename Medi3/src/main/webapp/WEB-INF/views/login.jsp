<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
function validate(){
	if ( document.LoginForm.userID.value == "") {
		alert("아이디를 입력해주세요");
		LoginForm.userID.focus();
		return false;
	}
	else if (document.LoginForm.userPW.value == ""){
			alert("비밀번호를 입력해주세요");
			LoginForm.userPW.focus();
			return false;
	}
	// 만약 값이 다 넘어왔다면 전송
	document.LoginForm.submit();
}
</script>

</head>
<body>
<section id="loginFormArea">
	
		<h1>로그인</h1>
		<form action="login.do" method="post" name="LoginForm">
			<table>
				<tr>	
					<td class="td_left">
					<label for="id">아이디:</label>
					</td>
					
					<td class="td_ right">
					<input type="text" name="userID" id="userID" autofocus/>
					</td>
				</tr>
				<tr>	
					<td class="td_left">
					<label for="pw">비밀번호:</label>
					</td>	
					<td class="td_ right">
					<input type="password" name="userPW" id="userPW"/>
					</td>
				</tr>
			</table>
			
			<input type="button" value="로그인" id="selectButton" onclick="validate()"/>
			<input type="button" value="회원가입" id="selectButton"/>
			<input type="button" value="ID/PW찾기" id="selectButton"/>
						 
		</form>
	</section>
</body>
</html>