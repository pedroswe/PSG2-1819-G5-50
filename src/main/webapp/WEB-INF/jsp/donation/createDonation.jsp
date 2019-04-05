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
                $("#moment").datepicker({ dateFormat: 'yy/mm/dd' });
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <h2>
            <c:if test="${donation['new']}">New </c:if> Donation
        </h2>
        <form:form modelAttribute="donation" class="form-horizontal">
            
            <input type="hidden" name="cause" value="cause" />
            <input type="hidden" name="moment" value="moment" />
            <div class="control-group">
                <petclinic:selectField label="Donator" name="donator" names="${owners}" size="5" />
            </div>

            <petclinic:inputField label="Amount" name="amount" />

            <div class="form-group">
                <button class="btn btn-default" type="submit">Save Donation</button>
                <spring:url value="/cause/{causeId}/donations/list" var="causeUrl">
                    <spring:param name="causeId" value="${cause.id}" />
                </spring:url>
                <a class="btn btn-default" href="${fn:escapeXml(causeUrl)}">Go back</a>
            </div>

        </form:form>

        <c:if test="${donationError}">
            <span class="alert-danger">
                <fmt:message key="donation.SaveError" /></span>
        </c:if>
        <c:if test="${error}">
            <span class="alert-danger">
                <fmt:message key="donation.UnexpectedError" /></span>
        </c:if>
    </jsp:body>
</petclinic:layout>