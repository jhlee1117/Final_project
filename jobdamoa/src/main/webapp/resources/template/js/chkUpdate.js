/**
 * 회원 업데이트 사용 스크립트
 */
// e-mail 중복체크 기능 (일반회원)
	function checkMem_email() {
		var emailVal = frm.mem_email.value;
		var emailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; // E-mail 정규식 체크
			if (emailVal == "") {
				alert('이메일을 입력하고 체크하세요.');
				frm.mem_email.focus();
				return false;
			} else if(emailVal.match(emailReg) == null) {
	            alert("이메일 형식이 아닙니다.");
	            frm.mem_email.value="";
	            frm.mem_email.focus();
	            $("#submit").attr("disabled", "disabled");
	            return false;
	        } else 
	        	$.post("checkMem_email.do", "mem_email=" + frm.mem_email.value + "&mem_num=" + frm.mem_num.value, function(data) {
				$("#email_check").html(data);
					if (data.value="사용 가능한 이메일입니다.") {
						$("#email_check").css("color","blue");
						$("#submit").removeAttr("disabled");
					} else if (data.value="사용 중이니 다른 이메일을 사용하세요.") {
						$("#email_check").css("color","red");
						frm.mem_email.value="";
						frm.mem_email.focus();
						$("#submit").attr("disabled", "disabled");
						return false;	
					}
				});
		}