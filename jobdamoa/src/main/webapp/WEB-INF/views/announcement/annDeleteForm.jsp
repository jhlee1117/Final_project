<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function chk() {
		$.ajax({
			url: "confirmAnnDel.do",
			type: "post",
			data: "com_password=" + frm.com_password.value,
			async: false,
			success: function(data) {
				if (data.msg == "1") {
					var delchk = confirm("정말로 공고를 삭제하시겠습니까?");
					if (delchk == true) {
						return true;
					} else {
						return false;		
					}
				} else if (data.msg == "-1") {
					alert("비밀번호가 일치하지 않습니다.");
					return false;
				}
			}
		});
	}
</script>
</head>
<body>
<c:if test="${result == 0 }">
	<script type="text/javascript">
		alert("중지된 공고는 삭제할 수 없습니다.");
		location.href=history.go(-1);
	</script>	
</c:if>
<c:if test="${result == 1 }">
	<div class="container" align="center">
	<form action="annDelete.do" name="frm" method="post" onsubmit="return chk()">
			<div class="card w-100 text-center">
				<div class="card-body">
					<h6>회원님의 계정 비밀번호를 입력하세요.</h6>
					<div class="form-floating mb-3">
						<input type="password" name="com_password" class="form-control"
							id="com_password" placeholder="Password"> <label
							for="com_password">Password</label>
					</div>
				</div>
				<div class="card-footer">
					<button type="submit" class="btn btn-primary">확인</button>
					<button type="button" class="btn btn-danger"
						onclick="history.back()">취소</button>
				</div>
			</div>
		</form>
	</div>
</c:if>
</body>
</html>