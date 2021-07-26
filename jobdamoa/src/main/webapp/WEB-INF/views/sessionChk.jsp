<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="user_dist" value="${sessionScope.user_dist }"></c:set>
<c:if test="${empty user_dist }">
	<script type="text/javascript">
		location.href="selectLoginForm.do";
	</script>
</c:if>
<c:if test="${user_dist ne 2}">
	<script type="text/javascript">
		alert("접근 권한이 없습니다")
		location.href="home.do"
	</script>
</c:if>
</body>
</html>