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
				$("#submit").attr("disabled", "disabled");
			} else if(emailVal.match(emailReg) == null) {
	            alert("이메일 형식이 아닙니다.");
	            frm.mem_email.value="";
	            frm.mem_email.focus();
	            $("#submit").attr("disabled", "disabled");
	        } else 
	        	$.post("checkMem_email.do", "mem_email=" + frm.mem_email.value + "&mem_num=" + frm.mem_num.value, function(data) {
				$("#email_check").html(data);
					if (data=="사용 가능한 이메일입니다.") {
						$("#email_check").css("color","blue");
						$("#submit").removeAttr("disabled");
					} else  {
						$("#email_check").css("color","red");
						frm.mem_email.value="";
						frm.mem_email.focus();
						$("#submit").attr("disabled", "disabled");
						return false;	
					}
				});
		}

// e-mail 중복체크 기능 (기업회원)
	function checkCom_email() {
		var emailVal = frm.com_email.value;
		var emailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; // E-mail 정규식 체크
			if (emailVal == "") {
				alert('이메일을 입력하고 체크하세요.');
				frm.com_email.focus();
				$("#submit").attr("disabled", "disabled");
			} else if(emailVal.match(emailReg) == null) {
	            alert("이메일 형식이 아닙니다.");
	            frm.com_email.value="";
	            frm.com_email.focus();
	            $("#submit").attr("disabled", "disabled");
	        } else 
	        	$.post("checkCom_email.do", "com_email=" + frm.com_email.value + "&com_num=" + frm.com_num.value, function(data) {
				$("#email_check").html(data);
					if (data=="사용 가능한 이메일입니다.") {
						$("#email_check").css("color","blue");
						$("#submit").removeAttr("disabled");
					} else  {
						$("#email_check").css("color","red");
						frm.com_email.value="";
						frm.com_email.focus();
						$("#submit").attr("disabled", "disabled");
						return false;	
					}
				});
		}

// 전화번호 중복체크 기능 (기업회원)
	function checkCom_pno() {
		var pnoVal = frm.com_pno.value;
		var pnoReg = /^\d{3}-\d{3,4}-\d{4}$/; // E-mail 정규식 체크
			if (pnoVal == "") {
				alert('전화번호를 입력하고 체크하세요.');
				frm.com_pno.focus();
				$("#submit").attr("disabled", "disabled");
			} else if(pnoVal.match(pnoReg) == null) {
	            alert("전화번호 형식이 아닙니다.");
	            frm.com_pno.value="";
	            frm.com_pno.focus();
	            $("#submit").attr("disabled", "disabled");
	        } else 
	        	$.post("checkCom_pno.do", "com_pno=" + frm.com_pno.value + "&com_num=" + frm.com_num.value, function(data) {
				$("#pno_check").html(data);
					if (data=="사용 가능한 전화번호입니다.") {
						$("#pno_check").css("color","blue");
						$("#submit").removeAttr("disabled");
					} else  {
						$("#pno_check").css("color","red");
						frm.com_pno.value="";
						frm.com_pno.focus();
						$("#submit").attr("disabled", "disabled");
						return false;	
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