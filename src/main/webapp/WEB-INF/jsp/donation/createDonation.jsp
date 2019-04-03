<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="donations">
    <jsp:attribute name="customScript">
        <script>
            $(function () {
                $("#moment").datepicker({dateFormat: 'yy/mm/dd'});
            });
        </script>
    </jsp:attribute>
    <jsp:body>
    <h2>
        <c:if test="${donation['new']}">New </c:if> Donation
    </h2>
    <form:form modelAttribute="donation" class="form-horizontal" >
            <input type="hidden" name="ownerId" value="${owner.id}"/>
            <input type="hidden" name="causeId" value="${causeId}"/>
            <div class="control-group">
                    <petclinic:selectField label="Owner" name="owner" names="${owners}" size="5"/>
            </div>
            <petclinic:inputField label="Moment" name="moment"/>
            <petclinic:inputField label="Amount" name="amount"/>
        
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
               
                <button class="btn btn-default" type="submit">Save Donation</button>
            
                    <spring:url value="/cause/{causeId}/edit" var="causeUrl">
                    <spring:param name="causeId" value="${causeId}"/>
                </spring:url>
                <a class="btn btn-default" href="${fn:escapeXml(causeUrl)}">Go back</a>
            
             
            </div>
        </div>
    </form:form>
</jsp:body>
</petclinic:layout>