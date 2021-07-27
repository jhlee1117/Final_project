<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
  					<li class="list-group-item"><a href="memberLoginForm.do">일반회원 로그인</a></li>
  					<li class="list-group-item"><a href="companyLoginForm.do">기업회원 로그인</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>