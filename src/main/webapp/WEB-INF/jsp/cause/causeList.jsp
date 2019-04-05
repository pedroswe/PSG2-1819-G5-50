<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<petclinic:layout pageName="causesList">

    <jsp:body>

        <h2>Causes</h2>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Burget Target</th>
                    <th>Total</th>
                    <th>Organization</th>
                    <c:if test="${ownerId > 0}">
                        <th>Edit</th>
                    </c:if>
                    <th>Details</th>
                    <th>Status</th>

                </tr>
            </thead>
            <tbody>
                <c:forEach items="${causes}" var="cause">
                    <tr>
                        <td>
                            <c:out value="${cause.name}" />
                        </td>
                        <td>
                            <c:out value="${cause.description}" />
                        </td>
                        <td>
                            <c:out value="${cause.budgetTarget}" />
                        </td>
                        <td>
                            <c:out value="${map.get(cause.id)}" />
                        </td>
                        <td>
                            <c:out value="${cause.organization}" />
                        </td>
                        <c:if test="${ownerId > 0}">
                            <td>
                                <a href="/cause/${ownerId}/edit/${cause.id}">Edit</a>
                            </td>
                        </c:if>

                        <td>
                            <spring:url value="/cause/{causeId}/donations/list" var="donateToCause">
                                <spring:param name="causeId" value="${cause.id}" />
                            </spring:url> <a href="${fn:escapeXml(donateToCause)}">Details</a>
                        </td>
                        <c:choose>
                            <c:when test="${cause.budgetTarget >  map.get(cause.id)}">
                                <td>
                                    <span style="color:blueviolet">
                                        <spring:message code="donation.donate" />
                                    </span>
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td>
                                    <span style="color:green">
                                        <spring:message code="donation.success" />
                                    </span>
                                </td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <c:if test="${ownerId > 0}">
            <a href="/cause/${ownerId}/create">Create a cause</a>
            &nbsp;
            <spring:url value="/owners/${ownerId}" var="causeUrl">
            </spring:url>
            <a class="btn btn-default" href="${fn:escapeXml(causeUrl)}">Go back</a>
        </c:if>
    </jsp:body>
</petclinic:layout>