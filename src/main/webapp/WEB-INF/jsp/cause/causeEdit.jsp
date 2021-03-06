<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>

<petclinic:layout pageName="causeEdit">
	<h2>New Cause</h2>
	<form:form modelAttribute="cause" class="form-horizontal" action="${requestURI}">
		<div class="form-group has-feedback">
			<input type="hidden" name="owner" value="${owner}" />
			<petclinic:inputField label="Name" name="name" />
			<petclinic:inputField label="Description" name="description" />
			<petclinic:inputField label="Burget Target" name="budgetTarget" />
			<petclinic:inputField label="Organization" name="organization" />
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button class="btn btn-default" type="submit">Submit</button>
				<spring:url value="/cause/${owner.id}/list" var="causeUrl">
				</spring:url>
				<a class="btn btn-default" href="${fn:escapeXml(causeUrl)}">Go back</a>
			</div>
		</div>
	</form:form>
</petclinic:layout>