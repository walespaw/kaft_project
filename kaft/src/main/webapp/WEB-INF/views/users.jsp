<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page session="false" %> --%>

<h1>AllUsers</h1>

<c:if test="${not empty users}">

	<ul>
		<c:forEach var="list" items="${users}">
			<li>
				<p>
					id - ${list.id}<br /> 
					userNick - ${list.userNick} <br /> 
					userName - ${list.name} userLastName - ${list.lastName} <br />
					userEmail - ${list.email}
				</p>
			</li>
		</c:forEach>
	</ul>

</c:if>