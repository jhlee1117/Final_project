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
<c:if test="${result == 0 }">
	<script type="text/javascript">
		alert("작성 권한이 없습니다.");
		location.href=history.go(-1);
	</script>	
</c:if>
<c:if test="${result == 1 }">
<div class="container px-4 px-lg-5 mt-5">
	<div class="col mb-5">
		<h2 class="text-primary">공고 등록하기</h2>
	</div>
	<form action="annInsert.do" method="post">
		<input type="hidden" name="ann_num" value="${ann_num }">
		<input type="hidden" name="pageNum" value="${pageNum }">
		<input type="hidden" name="com_num" value="${com_num }">
		<div class="row gx-4 gx-lg-5 row-cols-1 row-cols-md-2 row-cols-xl-2 justify-content-left">
			<table class="table table-bordered">
				<tr>
					<th width="30%" valign="middle">공고명</th>
					<td>
						<input type="text" name="ann_title" class="form-control" required="required" autofocus="autofocus">
					</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">회사명</th>
					<!-- com_num은 company 테이블의 주키이므로 com_num을 이용하여 com_name을 가져와 불러오도록 변경 필요 -->
					<td>
						${com_name }
					</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">직무</th>
					<td>
						<input type="text" name="ann_job" class="form-control" required="required">
					</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">고용형태</th>
					<td>
						<select class="form-select" name="ann_type" required="required" aria-label="Default select example">
  							<option selected>고용형태를 선택하세요</option>
  							<option value="regular">정규직</option>
  							<option value="contract">계약직</option>
  							<option value="intern">인턴</option>
  							<option value="rest">협의 후 결정</option>
						</select>
					</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">경력여부</th>
					<td>
						<select class="form-select" name="ann_career" required="required" aria-label="Default select example">
  							<option selected>경력여부를 선택하세요</option>
  							<option value="new">신입</option>
  							<option value="old">경력</option>
  							<option value="okay">경력무관</option>
						</select>
					</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">급여 수준</th>
					<td>
						<div class="input-group">
  							<span class="input-group-text">최소급여</span>
  							<input type="number" name="ann_min" required="required" class="form-control">
  						</div>
  						<div class="input-group">
  							<span class="input-group-text">최대급여</span>
  							<input type="number" name="ann_max" required="required" class="form-control">
  						</div>
					</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">근무위치</th>
					<td>
						<input type="text" name="ann_location" class="form-control" required="required">
					</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">기간</th>
					<td>
						<input type="text" name="ann_recruit_period" class="form-control" required="required">
					</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">업무소개</th>
					<td>
						<div class="form-floating">
  							<textarea class="form-control" name="ann_contents" required="required" placeholder="업무를 소개해주세요." id="ann_contents" style="height: 400px"></textarea>
  							<label for="ann_contents">업무소개</label>
						</div>
					</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">자격요건</th>
					<td>
						<div class="form-floating">
  							<textarea class="form-control" name="ann_qualification" required="required" placeholder="자격 요건을 작성해주세요." id="ann_qualification" style="height: 400px"></textarea>
  							<label for="ann_qualification">자격요건</label>
						</div>
					</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">우대사항</th>
					<td>
						<div class="form-floating">
  							<textarea class="form-control" name="ann_prime" required="required" placeholder="우대사항이 있으면 작성해주세요." id="ann_prime" style="height: 400px"></textarea>
  							<label for="ann_prime">우대사항</label>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div align="center">
			<button class="btn btn-dark" type="submit">확인</button>
			<button class="btn btn-dark" type="button" onclick="history.go(-1); return false;">취소</button>
		</div>
	</form>
</div>
</c:if>
</body>
</html>