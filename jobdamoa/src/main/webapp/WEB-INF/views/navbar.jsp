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
				<li class="nav-item"><a class="nav-link" href="annList.do">기업 채용 공고</a></li>
			</ul>
			<div class="d-flex">
				<c:if test="${empty user_dist }">
				<div class="dropdown">
					<button class="btn btn-outline-dark dropdown-toggle bi bi-box-arrow-in-right" type="button" id="loginSelectButton" data-bs-toggle="dropdown" aria-expanded="false">
						로그인
					</button> <!-- 드랍박스가 아닌 화면 구성 시 로그인 페이지를 별도로 연결하여, 탭으로 회원 선택 및 구분 -->
					<ul class="dropdown-menu" aria-labelledby="loginSelectButton">
    					<li><a class="dropdown-item" href="memberLoginForm.do">일반회원</a></li>
    					<li><a class="dropdown-item" href="companyLoginForm.do">기업회원</a></li>
  					</ul>
				</div> <!-- 드랍박스가 아닌 화면 구성 시 로그인 페이지를 별도로 연결하여, 탭으로 회원 선택 및 구분 -->
				<button class="btn btn-dark" type="button" onclick="#">
					<i class="bi bi-person-plus"></i> 회원가입
				</button>
				</c:if>
				<c:if test="${user_dist == '0' }">
				<div class="dropdown">
					<button class="btn btn-outline-dark dropdown-toggle bi bi-person-circle" type="button" id="loginSelectButton" data-bs-toggle="dropdown" aria-expanded="false">
						마이페이지
					</button>
					<ul class="dropdown-menu" aria-labelledby="loginSelectButton">
    					<li><a class="dropdown-item" href="#">회원정보</a></li>
    					<li><a class="dropdown-item" onclick="location.href='myFavList.do'">저장공고</a></li>
    					<li><a class="dropdown-item" href="">스크랩공고</a></li>
  					</ul>
				</div>
					<button class="btn btn-dark" type="button" onclick="location.href='memberLogout.do';">
						<i class="bi bi-box-arrow-in-left"></i> 로그아웃
					</button>
				</c:if>
				<c:if test="${user_dist == '1' }">
				<div class="dropdown">
					<button class="btn btn-outline-dark dropdown-toggle bi bi-building" type="button" id="loginSelectButton" data-bs-toggle="dropdown" aria-expanded="false">
						마이페이지
					</button>
					<ul class="dropdown-menu" aria-labelledby="loginSelectButton">
    					<li><a class="dropdown-item" href="#">기업정보</a></li>
    					<li><a class="dropdown-item" onclick="location.href='myAnnList.do'">나의 공고</a></li>
  					</ul>  					
				</div>
					<button class="btn btn-dark" type="button" onclick="location.href='companyLogout.do';">
						<i class="bi bi-box-arrow-in-left"></i> 로그아웃
					</button>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>