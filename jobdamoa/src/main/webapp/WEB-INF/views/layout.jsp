<%@ include file="head.jsp" %>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<tiles:insertAttribute name="navbar"></tiles:insertAttribute>
	</nav>
<%-- 	<header class="bg-dark py-5">
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</header> --%>
	<section   style="padding-top: 0px;">
		<tiles:insertAttribute name="section"></tiles:insertAttribute>
	</section>
	<footer class="py-5 bg-dark">
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</footer>
</body>
</html>