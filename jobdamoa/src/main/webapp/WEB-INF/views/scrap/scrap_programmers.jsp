<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="${path}/python_scrap/data.json"></script>
    <script type="text/javascript">
        let mydata = null
        if(data){
            mydata = JSON.parse(data)
        }
        var x = mydata[1].company;
        window.onload(alert(x));
    </script>
</head>
<body>
</body>
</html>