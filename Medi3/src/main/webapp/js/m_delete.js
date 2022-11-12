function checkpw(){
	 $.ajax(
			 {
				 type:"post",
				 data: $("input[name=userpw]").serialize(), 
				 dataType:"json",
				 url:"/Medi3/pwcheck",	    
				 success: function( data, textStatus){
					if (data.result==1) {
						check();
					} else if ($('input[name=userpw]')== ""){
						alert("비밀번호를 입력해주세요.");
					} else {
						alert("비밀번호가 맞지 않습니다.");
						window.location.href = 'delete.do'
					}
					
				 }
				 ,
				 error: function( data, textStatus){		
					 alert("아이디 로드 실패, 관리자에게 문의하세요.");
				 },		 
				 complete:function(data, textStatus){
				 }		 
			}
		);
	
}


function check(){
	let form =document.delfrm;
	//let id = form.userid;
	let pw = form.userpw;
	
	/*if(id.value==""){
		alert("아이디를 입력하세요.");
		id.focus();
	}else */ if(pw.value==""){
		alert("비밀번호를 입력하세요.");
		pw.focus();
	}else{
		 let delConfirm = confirm('정말로 탈퇴하시겠습니까?');
  		 if (delConfirm) {
      	 form.submit();
  		 }  else {alert('삭제가 취소되었습니다.');
  		 window.location.href = 'home.do'; 
  		 }
		
	}
}