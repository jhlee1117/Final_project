/**
 * 회원가입 사용 스크립트
 * 
 */
// ID 중복체크 기능 (기업회원)
	function idComchk() {
		var idReg = /^[a-z]+[a-z0-9]{5,19}$/g; // ID 정규식 체크
			if (!frm.com_id.value) {
				alert('아이디를 입력하고 체크하세요.');
				frm.com_id.focus();
				return false;
			} else if( !idReg.test($("input[name=com_id]").val())) {
	            alert("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.");
	            frm.com_id.value="";
	            frm.com_id.focus();
	            $("#submit").attr("disabled", "disabled");
	            return false;
	        } else 
	        	$.post("confirmCom.do", "com_id=" + frm.com_id.value, function(data) {
				$("#id_check").html(data);
					if (data=="사용 가능한 아이디입니다.") {
						$("#id_check").css("color","blue");
					} else {
						$("#id_check").css("color","red");
						frm.com_id.value="";
						frm.com_id.focus();
						$("#submit").attr("disabled", "disabled");
					}
				});
		}
// ID 중복체크 기능 (일반회원)
	function idMemchk() {
		var idReg = /^[a-z]+[a-z0-9]{5,19}$/g; // ID 정규식 체크
			if (!frm.mem_id.value) {
				alert('아이디를 입력하고 체크하세요.');
				frm.mem_id.focus();
				return false;
			} else if( !idReg.test($("input[name=mem_id]").val())) {
	            alert("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.");
	            frm.mem_id.value="";
	            frm.mem_id.focus();
	            $("#submit").attr("disabled", "disabled");
	            return false;
	        } else 
	        	$.post("confirmMem.do", "mem_id=" + frm.mem_id.value, function(data) {
				$("#id_check").html(data);
					if (data=="사용 가능한 아이디입니다.") {
						$("#id_check").css("color","blue");
					} else {
						$("#id_check").css("color","red");
						frm.mem_id.value="";
						frm.mem_id.focus();
						$("#submit").attr("disabled", "disabled");
					}
				});
		}
// 비밀번호 체크 기능
	$(function() {
		$("#alert-success").hide();
		$("#alert-danger").hide();
		$(".passchk").keyup(function() {
			var pass = $("#pass").val();
			var confirmPass = $("#confirmPass").val();
			if (pass != "" || confirmPass != "") {
				if (pass == confirmPass) {
					$("#alert-success").css("color","blue").show();
					$("#alert-danger").hide();
					$("#submit").removeAttr("disabled");
				} else {
					$("#alert-success").hide();
					$("#alert-danger").css("color","red").show();
					$("#submit").attr("disabled", "disabled");
				}
			}
		});
	});
