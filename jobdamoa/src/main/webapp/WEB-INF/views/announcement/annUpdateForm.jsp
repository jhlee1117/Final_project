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
		alert("중지된 공고는 수정할 수 없습니다.");
		location.href=history.go(-1);
	</script>	
</c:if>
<c:if test="${result == 1 }">
<div class="container px-4 px-lg-5 mt-5">
	<div class="col mb-5">
		<h2 class="text-primary">공고 수정하기</h2>
	</div>
	<form action="annUpdate.do" method="post">
		<input type="hidden" name="ann_num" value="${ann.ann_num }">
		<input type="hidden" name="pageNum" value="${pageNum }">
		<input type="hidden" name="com_num" value="${com_num }">
		<div class="row gx-4 gx-lg-5 row-cols-1 row-cols-md-2 row-cols-xl-2 justify-content-left">
			<table class="table table-bordered">
				<tr>
					<th width="30%" valign="middle">공고명</th>
					<td>
						<input type="text" name="ann_title" value="${ann.ann_title }" class="form-control" required="required" readonly="readonly">
					</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">회사명</th>
					<td>
						${com_name }
					</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">직무</th>
					<td>
						<input type="text" name="ann_job" value="${ann.ann_job }"  class="form-control" required="required">
					</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">고용형태</th>
					<td>
						<select class="form-select" name="ann_type" aria-label="Disabled select example" required="required" >
  							<option disabled>고용형태를 선택하세요</option>
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
						<select class="form-select" name="ann_career" aria-label="Disabled select example" required="required" >
  							<option disabled>경력여부를 선택하세요</option>
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
  							<input type="number" name="ann_min" value="${ann.ann_min}" required="required" class="form-control">
  						</div>
  						<div class="input-group">
  							<span class="input-group-text">최대급여</span>
  							<input type="number" name="ann_max" value="${ann.ann_max}" required="required" class="form-control">
  						</div>
					</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">근무위치</th>
					<td>
						<input type="text" name="ann_location" value="${ann.ann_location }" class="form-control" required="required">
					</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">기간</th>
					<td>
						<input type="text" name="ann_recruit_period" value="${ann.ann_recruit_period }" class="form-control" required="required">
					</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">업무소개</th>
					<td>
						<div class="form-floating">
  							<textarea class="form-control" name="ann_contents" required="required" placeholder="업무를 소개해주세요." id="ann_contents" style="height: 400px">${ann.ann_contents }</textarea>
  							<label for="ann_contents">업무소개</label>
						</div>
					</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">자격요건</th>
					<td>
						<div class="form-floating">
  							<textarea class="form-control" name="ann_qualification" required="required" placeholder="자격 요건을 작성해주세요." id="ann_qualification" style="height: 400px">${ann.ann_qualification }</textarea>
  							<label for="ann_qualification">자격요건</label>
						</div>
					</td>
				</tr>
				<tr>
					<th width="30%" valign="middle">우대사항</th>
					<td>
						<div class="form-floating">
  							<textarea class="form-control" name="ann_prime" required="required" placeholder="우대사항이 있으면 작성해주세요." id="ann_prime" style="height: 400px">${ann.ann_prime }</textarea>
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