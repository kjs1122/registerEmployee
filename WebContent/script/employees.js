

function loginCheck() {
	if(document.frm.id.value == ""){
		alert("아이디를 입력해 주세요.");
		frm.id.focus();
		return false;
	}
	if(document.frm.pwd.value == ""){
		alert("비밀번호를 입력해 주세요.");
		frm.pwd.focus();
		return false;
	}
	return true;
}
function pageCheck() {
	if(document.frm.id.value == ""){
		alert("아이디를 입력해 주세요.");
		frm.id.focus();
		return false;
	}
	if(document.frm.pwd.value == ""){
		alert("비밀번호를 입력해 주세요.");
		frm.pwd.focus();
		return false;
	}
	if(document.frm.name.value == ""){
		alert("이름을 입력해 주세요.");
		frm.name.focus();
		return false;
	}
	if(document.frm.phone.value == ""){
		alert("전화번호를 입력해 주세요.");
		frm.phone.focus();
		return false;
	}
	return true;
}