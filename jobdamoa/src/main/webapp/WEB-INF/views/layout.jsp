<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ include file="head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트-잡다모아</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<tiles:insertAttribute name="navbar"></tiles:insertAttribute>
	</nav>
	<header class="bg-dark py-5">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</header>
	<section class="py-5">
		<tiles:insertAttribute name="section"></tiles:insertAttribute>
	</section>
	<footer class="py-5 bg-dark">
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</footer>
</body>
</html>