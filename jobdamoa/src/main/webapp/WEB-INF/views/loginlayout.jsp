<%@ include file="head.jsp" %>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<tiles:insertAttribute name="loginnavbar">
		</tiles:insertAttribute>
	</nav>
	<section class="py-5">
		<tiles:insertAttribute name="section">
		</tiles:insertAttribute>
	</section>
</body>
</html>