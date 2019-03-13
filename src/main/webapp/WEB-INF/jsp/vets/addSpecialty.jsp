<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="vets">
    <h2>
        New Specialty
    </h2>
    <form:form modelAttribute="specialty" class="form-horizontal" id="add-vet-form">
        <input type="hidden" name="vetId" value="${vetId}"/>
        <input type="hidden" name="id" value="${specialty.id}"/>
        <div class="form-group has-feedback">
            <petclinic:inputField label="Name" name="name"/>
            
        </div>
        
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
               
                <button class="btn btn-default" type="submit">Save</button>
                 
                <spring:url value="/vets/{vetId}/edit" var="vetUrl">
                        <spring:param name="vetId" value="${vet.id}"/>
                    </spring:url>
                    <a class="btn btn-default" href="${fn:escapeXml(vetUrl)}">Go back</a>
            </div>
        </div>
    </form:form>
</petclinic:layout>
