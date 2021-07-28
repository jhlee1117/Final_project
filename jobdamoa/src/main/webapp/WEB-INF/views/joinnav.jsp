<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<body>
	<div class="container px-4 px-lg-5">
		<a class="navbar-brand" href="home.do"><img src="${path }/resources/template/img/logo_jobdamoa.png" class="img-fluid"></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<div class="d-flex">
				<ul class="list-group list-group-horizontal">
  					<li class="list-group-item"><a href="memberJoinForm.do">일반회원 가입</a></li>
  					<li class="list-group-item"><a href="companyJoinForm.do">기업회원 가입</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>