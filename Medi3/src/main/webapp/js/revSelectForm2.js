function cancel(){
	debugger;
	//alert("ok");
	if(confirm("예약을 취소하시겠습니까?")){
		let frm = document.frm;
		frm.submit();
	}
	
}