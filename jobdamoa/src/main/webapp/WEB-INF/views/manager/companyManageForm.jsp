<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기업 회원 관리</title>
<script type="text/javascript">
	function del() {
		var con = confirm("정말로 탈퇴 처리 하시겠습니까?");
		if (con) {
			document.select_company.action = "companyOut.do"
			document.select_company.submit();
		}
		else {
			alert("기업 회원 탈퇴 처리가 취소되었습니다");
			return;
		}
	}
	function res() {
		var con = confirm("정말로 복구 처리 하시겠습니까?");
		if (con) {
			document.select_company.action = "companyRestore.do"
			document.select_company.submit();
		}
		else {
			alert("기업 회원 복구 처리가 취소되었습니다");
			return;
		}
	}
</script>
</head>
<body>
<div class="col-10 bd-content">
<div class="mt-5 mb-5">
	<font color="black" size="6">기업회원관리</font>
</div>
	<form method="post" name="select_company">
		<table class="table table-hover">
			<thead class="table-primary">
			<tr class="table-dark">
				<th style="width: 5%">선택</th>
				<th style="width: 10%">기업회원번호</th>
				<th style="width: 13%">기업회원ID</th>
				<th style="width: 12%">회사명</th>
				<th style="width: 15%">가입일</th>
				<th style="width: 20%">대표이메일</th>
				<th style="width: 13%">사업번호</th>
				<th style="width: 17%">홈페이지</th>
			</tr>
			</thead>
			<tbody class="table-dark">
			<c:forEach var="company" items="${companyList}">
				<tr class="table-dark">
					<td><input type="checkbox" name="chk_company_id" value="${company.com_id }"></td>
					<td>${company.com_num } </td>
					<td>${company.com_id }</td>
					<td>${company.com_name }</td>
					<td>${company.com_join_date }</td>
					<td>${company.com_email }</td>
					<td>${company.com_business_num }</td>
					<td>${company.com_homepage }</td>
					<td><c:choose>
						<c:when test="${company.com_invalid eq 'y'}">탈퇴</c:when>
						<c:when test="${company.com_invalid eq 'n'}">가입</c:when></c:choose></td>
				<tr>	
			</c:forEach>
			</tbody>
		</table>
		<div align="center">
			<nav aria-label="Page navigation example">
			  <ul class="pagination justify-content-center">
			  <c:if test="${startPage > PAGE_PER_BLOCK}">
			    <li class="page-item">
			      <a class="page-link" href="companyManageForm.do?&pageNum=${startPage - 1}" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    </c:if>
				    <c:forEach var="i" begin="${startPage}" end="${endPage}">
				    	<c:choose>
				    		<c:when test="${currentPage eq i }">
					    		<li class="page-item active" aria-current="page"><a class="page-link" href="companyManageForm.do?&pageNum=${i}">${i}</a></li>
					    	</c:when>
					    	<c:otherwise>
					    		<li class="page-item"><a class="page-link" href="companyManageForm.do?&pageNum=${i}">${i}</a></li>
					    	</c:otherwise>
					    </c:choose>
					</c:forEach>
					<c:if test="${endPage < totalPage}">
			    <li class="page-item">
			      <a class="page-link" href="companyManageForm.do?&pageNum=${endPage + 1}" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			    </c:if>
			  </ul>
			</nav>
		</div>
	    <button class="mt-2 btn btn-danger btn-sm" onclick="del()">회원삭제</button>
		<button class="mt-2 btn btn-primary btn-sm" onclick="res()">회원복구</button>
	</form>
</div>
</body>
</html>