<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page session="false" %> --%>

<h1>AllDtoUsers</h1>

<c:if test="${not empty list}">

	<ul>
		<c:forEach var="listValue" items="${list}">
			<li>${listValue.userNick}- ${listValue.name}
				${listValue.lastName} <br /> 
				${listValue.emaill} <br />
				and this UserDto id is ${listValue.id}
			</li>
		</c:forEach>
	</ul>

</c:if>