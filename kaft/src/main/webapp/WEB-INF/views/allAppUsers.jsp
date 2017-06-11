<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page session="false" %> --%>

<h1>AllUsers</h1>

<c:if test="${not empty list}">

	<ul>
		<c:forEach var="listValue" items="${list}">
			<li>${listValue.userNick} - ${listValue.name} ${listValue.lastName} <br />${listValue.email}</li>
		</c:forEach>
	</ul>

</c:if>