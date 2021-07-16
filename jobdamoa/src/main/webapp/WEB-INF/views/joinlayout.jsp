<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<tiles:insertAttribute name="navbar">
		</tiles:insertAttribute>
	</nav>
	<section class="py-5">
		<tiles:insertAttribute name="section">
		</tiles:insertAttribute>
	</section>
</body>
</html>