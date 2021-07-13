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
		alert("공고를 저장하였습니다.");
		location.href="annList.do?pageNum=${pageNum}";
	</script>
</c:if>
<c:if test="${result == 0 }">
	<script type="text/javascript">
		alert("이미 저장한 공고입니다.");
		history.back();
	</script>
</c:if>
<c:if test="${result < 0 }">
	<script type="text/javascript">
		alert("공고를 저장할 수 없습니다.");
		history.back();
	</script>
</c:if>
</body>
</html>