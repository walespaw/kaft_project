<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<h1>AllUsers</h1>
<div class="add_user_button">
	<a href="<s:url value="/registerUser"></s:url>"> Add User Form </a>
</div>
<c:if test="${not empty users}">

	<ul>
		<c:forEach var="list" items="${users}">
			<li>
				<p>
				<div class="user_data">
					id - ${list.id}<br /> userNick - ${list.userNick} <br /> userName
					- ${list.name} userLastName - ${list.lastName} <br /> userEmail -
					${list.email}
				</div>
				<div class="user_data_change">
					<%-- <s:url value="/users/${list.id}" var="userUrl" /> --%>
					<s:url value="/users/${list.id}/delete" var="deleteUrl" />
					<s:url value="/users/${list.id}/update" var="updateUrl" />

					<%-- <button class="btn btn-info" onclick="location.href='${userUrl}'">Query</button> --%>
					<button class="btn btn-primary"
						onclick="location.href='${updateUrl}'">Update</button>
					<button class="btn btn-danger"
						onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
				</div>
				</p>
			</li>
		</c:forEach>
	</ul>

</c:if>