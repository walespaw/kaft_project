<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="linkPanel">
<a href="<s:url value="/" />"> <img
	src="<s:url value="/resources" />/img/kaft_app.png" border="0" height="30px" />
</a> |
<a href="<s:url value="/test"></s:url>"> Test </a> |
<a href="<s:url value="/activeUsers"></s:url>"> ActiveUsers </a> |
<!-- <a href="<s:url value="/allAppUsers"></s:url>"> AllUsers </a> | -->
<a href="<s:url value="/allDtoUsers"></s:url>"> AllDtoUsers </a><br /> |
<a href="<s:url value="/users"></s:url>"> Users </a> |
<a href="<s:url value="/registerUser"></s:url>"> Add User </a> |
<a href="<s:url value="/usersJson"></s:url>"> Json </a>
</div>

<div id="loginPanel">


	<c:url var="logoutUrl" value="/logout" />
	<form class="form-inline" action="${logoutUrl}" method="post">
		<p>
		Hello <b><c:out value="${pageContext.request.remoteUser}" /></b>
	</p>
		<input type="submit" value="Log out" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	
</div>
