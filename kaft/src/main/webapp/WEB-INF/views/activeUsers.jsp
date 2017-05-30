<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page session="false" %> --%>

<h1>ActiveUsers</h1>

<c:if test="${not empty list}">

	<ul>
		<c:forEach var="listValue" items="${list}">
			<li>${listValue.name}</li>
		</c:forEach>
	</ul>

</c:if>