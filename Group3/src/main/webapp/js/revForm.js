function save(){
		//alert("hi");
		let frm = document.frm;
		let rev_num = frm.rev_num;
		let rev_name = frm.rev_name;
		let rev_date = frm.rev_date;
		let rev_time = frm.rev_time;
		let rev_location = frm.rev_location;
		let rev_program = frm.rev_program;
		
		
		if(rev_num.value == ""){
			alert("예약번호를 입력해주세요");
			rev_num.focus();
		}
		else if(rev_name.value == ""){
			alert("이름를 입력해주세요");
			rev_name.focus();
		}
		else if(rev_date.value == ""){
			alert("날짜를 선택해주세요");
			rev_date.focus();
		}
		else if(rev_time.value == ""){
			alert("시간을 선택해주세요");
			rev_time.focus();
		}
		else if(rev_location.value == ""){
			alert("위치를 선택해주세요");
			rev_location.focus();
		}
		else if(rev_program.value == ""){
			alert("프로그램을 입력해주세요");
			rev_program.focus();
		}
		
		else{
			frm.submit();
			alert("예약 완료");
		}
	
	}