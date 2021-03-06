<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="vets">
    <h2>
        <c:if test="${vet['new']}">New </c:if> Vet
    </h2>
    <form:form modelAttribute="vet" class="form-horizontal" id="add-vet-form">
        <input type="hidden" name="id" value="${vet.id}"/>
        <div class="form-group has-feedback">
            <petclinic:inputField label="First Name" name="firstName"/>
            <petclinic:inputField label="Last Name" name="lastName"/>

            <c:choose>
                    <c:when test="${vet['new']}">
                            <input type="hidden" name="specialties" value="${vet.specialties}"/>
                    </c:when>
                    <c:otherwise>
                        <petclinic:inputField label="Specialties" name="specialties"/>
                        
                    </c:otherwise>
                </c:choose>
            
        </div>
        
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${vet['new']}">
                        <button class="btn btn-default" type="submit">Add Vet</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Update Vet</button>
                        
                    </c:otherwise>
                </c:choose>
                <spring:url value="/vets/{vetId}/addSpecialty" var="vetUrl">
                        <spring:param name="vetId" value="${vet.id}"/>
                    </spring:url>
                    <a class="btn btn-default" href="${fn:escapeXml(vetUrl)}">Add Specialty</a>
                <a class="btn btn-default" href='<spring:url value="/vets/list" htmlEscape="true"/>'>Go back</a>
            </div>
        </div>
    </form:form>
</petclinic:layout>
