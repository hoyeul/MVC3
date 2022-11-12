function check(){
	let form =document.modckfrm;
	let id = form.userid;
	let pw = form.userpw;
	
	if(id.value==""){
		alert("아이디를 입력하세요.");
		id.focus();
	}else if(pw.value==""){
		alert("비밀번호를 입력하세요.");
		pw.focus();
	}else {
      	 form.submit();}
}

 function check2(){
	let form =document.modfrm;
	let id = form.userid;
	let pw = form.userpw;
	let pwck = form.userpwcheck;
	let name = form.name;
	let num = form.num;
	let addr = form.addr;
	let tel = form.tel;
	
	if(id.value==""){
		alert("아이디를 입력하세요.");
		id.focus();
	}else if(pw.value==""){
		alert("비밀번호를 입력하세요.");
		pw.focus();
	}else if(pwck.value==""){
		alert("비밀번호 확인를 입력하세요.");
		pwck.focus();
	}else if(pw.value!=pwck.value){
		alert("비밀번호와 비밀번호 확인 부분을 확인하세요.");
		pw.focus();
	}else if(name.value==""){
		alert("이름을 입력하세요.");
		name.focus();
	}else if(num.value==""){
		alert("주민번호를 입력하세요.");
		num.focus();
	}else if(addr.value==""){
		alert("주소를 입력하세요.");
		addr.focus();
	}else if(tel.value==""){
		alert("전화번호를 입력하세요.");
		tel.focus();
	}else {form.submit();}
}