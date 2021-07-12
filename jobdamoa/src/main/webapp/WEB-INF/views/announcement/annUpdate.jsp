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
		alert("수정 성공");
/* 		location.href="annList.do?pageNum=${pageNum}"; */
		// 바로 조회로 넘어가려고 하는 경우
		location.href="annView.do?ann_num=${ann_num}&pageNum=${pageNum}";
	</script>
</c:if>
<c:if test="${result == 0 }">
	<script type="text/javascript">
		alert("수정 실패");
		history.back();
	</script>
</c:if>
</body>
</html>