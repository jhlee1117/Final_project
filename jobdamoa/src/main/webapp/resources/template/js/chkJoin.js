/**
 * 회원가입 사용 스크립트
 * 
 */
// ID 중복체크 기능
	function idComchk() {
		var idReg = /^[a-z]+[a-z0-9]{5,19}$/g;
			if (!frm.com_id.value) {
				alert('아이디를 입력하고 체크하세요.');
				frm.com_id.focus();
				return false;
			} else if( !idReg.test($("input[name=com_id]").val())) {
	            alert("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.");
	            return;
	        } else 
	        	$.post("confirmCom.do", "com_id=" + frm.com_id.value, function(data) {
				$("#id_check").html(data);
				$("#id_check").css("color","red");
				});
		}