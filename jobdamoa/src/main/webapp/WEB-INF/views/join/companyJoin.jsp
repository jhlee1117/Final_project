<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${result > 0 }">
		<script type="text/javascript">
			alert("회원가입이 정상적으로 처리되었습니다.");
			location.href = "${referer}";
		</script>
	</c:if>
	<c:if test="${result == 0 }">
		<script type="text/javascript">
			alert("회원가입에 실패하였습니다. 전화번호 또는 이메일, 사업자번호를 확인하시기 바랍니다.");
			history.back();
		</script>
	</c:if>	
</body>
</html>