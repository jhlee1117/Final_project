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
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
				<!-- <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li> -->
				<!-- <li class="nav-item"><a class="nav-link" href="#!">About</a></li> -->
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" id="navbarDropdown" href="#"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">채용공고
						확인</a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="#!">프로그래머스</a></li>
						<li><a class="dropdown-item" href="#!">잡코리아</a></li>
						<li><a class="dropdown-item" href="#!">사람인</a></li>
					</ul></li>
				<li class="nav-item"><a class="nav-link" href="#!">기업 채용 공고</a></li>
			</ul>
			<form class="d-flex">
				<button class="btn btn-outline-dark" type="submit">
					<i class="bi bi-box-arrow-in-right"></i> 로그인
				</button>
				<button class="btn btn-dark" type="submit">
					<i class="bi bi-person-circle"></i> 회원가입
				</button>
			</form>
		</div>
	</div>
</body>
</html>