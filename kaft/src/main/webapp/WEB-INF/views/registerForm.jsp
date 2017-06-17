<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>

<div class="form_container">

	<c:choose>
		<c:when test="${not empty userForm.id}">
			<h1>Add User</h1>
		</c:when>
		<c:otherwise>
			<h1>Update User</h1>
		</c:otherwise>
	</c:choose>

	<s:url value="/users" var="userActionUrl" />

	<form:form class="form_css" method="POST" modelAttribute="userForm"
		action="${userActionUrl}">

		<form:hidden path="id" />

		<s:bind path="userNick">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="lable_class">Nick</label>
				<div class="col-sm-10">
					<form:input path="userNick" type="text" class="input_class"
						id="userNick" placeholder="userNick" />
					<form:errors path="userNick" class="control-label" />
				</div>
			</div>
		</s:bind>

		<s:bind path="password">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="lable_class">Password</label>
				<div class="col-sm-10">
					<form:input path="password" type="text" class="input_class"
						id="password" placeholder="password" />
					<form:errors path="password" class="control-label" />
				</div>
			</div>
		</s:bind>

		<%-- Tu dodać hasło potwierdzenie 
		
		
		<s:bind path="password">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="lable_class">Password</label>
				<div class="col-sm-10">
					<form:input path="password" type="text" class="input_class"
						id="password" placeholder="Password" />
					<form:errors path="password" class="control-label" />
				</div>
			</div>
		</s:bind> --%>

		<s:bind path="name">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="lable_class">Name</label>
				<div class="col-sm-10">
					<form:input path="name" type="text" class="input_class" id="name"
						placeholder="name" />
					<form:errors path="name" class="control-label" />
				</div>
			</div>
		</s:bind>

		<s:bind path="lastName">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="lable_class">Last Name</label>
				<div class="col-sm-10">
					<form:input path="lastName" type="text" class="input_class"
						id="lastName" placeholder="lastName" />
					<form:errors path="lastName" class="control-label" />
				</div>
			</div>
		</s:bind>

		<s:bind path="secondName">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="lable_class">Second Name</label>
				<div class="col-sm-10">
					<form:input path="secondName" type="text" class="input_class"
						id="secondName" placeholder="secondName" />
					<form:errors path="secondName" class="control-label" />
				</div>
			</div>
		</s:bind>


		<s:bind path="email">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="lable_class">Email</label>
				<div class="col-sm-10">
					<form:input path="email" type="text" class="input_class" id="email"
						placeholder="email" />
					<form:errors path="email" class="control-label" />
				</div>
			</div>
		</s:bind>
		<%-- <form:hidden path="status" /> --%>

<!-- addres 1 -->

		<form:hidden path="addressId" />

		
		<s:bind path="country">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="lable_class">Country</label>
				<div class="col-sm-10">
					<form:input path="country" type="text" class="input_class" id="country"
						placeholder="country" />
					<form:errors path="country" class="control-label" />
				</div>
			</div>
		</s:bind>
		
		<s:bind path="city">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="lable_class">City</label>
				<div class="col-sm-10">
					<form:input path="city" type="text" class="input_class" id="city"
						placeholder="city" />
					<form:errors path="city" class="control-label" />
				</div>
			</div>
		</s:bind>
		
		<s:bind path="zipCode">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="lable_class">Zip-Code</label>
				<div class="col-sm-10">
					<form:input path="zipCode" type="text" class="input_class" id="zipCode"
						placeholder="zipCode" />
					<form:errors path="zipCode" class="control-label" />
				</div>
			</div>
		</s:bind>
		
		<s:bind path="street">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="lable_class">Street</label>
				<div class="col-sm-10">
					<form:input path="street" type="text" class="input_class" id="street"
						placeholder="street" />
					<form:errors path="street" class="control-label" />
				</div>
			</div>
		</s:bind>
		
		<s:bind path="streetNumber">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="lable_class">StreetNumber</label>
				<div class="col-sm-10">
					<form:input path="streetNumber" type="text" class="input_class" id="streetNumber"
						placeholder="streetNumber" />
					<form:errors path="streetNumber" class="control-label" />
				</div>
			</div>
		</s:bind>
		
		<s:bind path="flatNumber">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<label class="lable_class">FlatNumber</label>
				<div class="col-sm-10">
					<form:input path="flatNumber" type="text" class="input_class" id="flatNumber"
						placeholder="flatNumber" />
					<form:errors path="flatNumber" class="control-label" />
				</div>
			</div>
		</s:bind>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${not empty userForm.id}">
						<button type="submit" class="">Add</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="">Update</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	

		<!-- buttons  -->


	</form:form>
</div>