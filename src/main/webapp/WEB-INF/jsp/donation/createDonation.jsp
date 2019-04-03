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
            <c:out value="${cause}" />
            <input type="hidden" name="cause" value="${cause}" />
            <div class="control-group">
                <petclinic:selectField label="Donator" name="donator" names="${owners}" size="5" />
            </div>
            <petclinic:inputField label="Moment" name="moment" />
            <petclinic:inputField label="Amount" name="amount" />

            <div class="form-group">
                <button class="btn btn-default" type="submit">Save Donation</button>
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
        <br>

        <spring:url value="/cause/{causeId}/edit" var="causeUrl">
            <spring:param name="causeId" value="${causeId}" />
        </spring:url>
        <a class="btn btn-default" href="${fn:escapeXml(causeUrl)}">Go back</a>
    
        <br>
        <c:out value="${donationSaved}" />
        <br>
        <c:out value="${donationSaved.id}" />
        <br>
        <c:out value="${donationSaved.moment}" />
        <br>
        <c:out value="${donationSaved.amount}" />
        <br>
        <c:out value="${donationSaved.donator.id}" />
        <br>
        <c:out value="${donationSaved.donator.firstName}" />
        <br>
        <c:out value="${donationSaved.donator.lastName}" />
        <br>
        <c:out value="${donation.cause}" />
        <br>
        <c:out value="${causeId}" />

    </jsp:body>
</petclinic:layout>