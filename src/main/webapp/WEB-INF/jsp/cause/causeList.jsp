<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<petclinic:layout pageName="causesList">

    <jsp:body>

        <h2>Causes</h2>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Burget Target</th>
                    <th>Organization</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${causes}" var="cause">
                    <tr>
                        <td>
                            <spring:url value="/cause/{causeId}.html" var="ownerUrl">
                                <spring:param name="causeUrl" value="${cause.id}" />
                            </spring:url>
                            <a href="${fn:escapeXml(causeUrl)}">
                                <c:out value="{cause.name}" /></a>
                        </td>
                        <td>
                            <c:out value="${cause.description}" />
                        </td>
                        <td>
                            <c:out value="${cause.budgetTarget}" />
                        </td>
                        <td>
                            <c:out value="${cause.organization}" />
                        </td>
                        <td>
                            <a href="edit/${cause.id}">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="create">Create a cause</a>
    </jsp:body>
</petclinic:layout>