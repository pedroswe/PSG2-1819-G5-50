<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>



<petclinic:layout pageName="showCause">

    <jsp:body>

        <h2>Cause Details</h2>

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

                </tr>
            </thead>
            <tbody>
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
                        <c:out value="${totalBudgetAchieved}" />
                    </td>
                    <td>
                        <c:out value="${cause.organization}" />
                    </td>
                </tr>
            </tbody>
        </table>

        <br>
        <br>
        <br>


        <h2>Cause Donation List</h2>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Date</th>
                    <th>Amount</th>
                    <th>Client</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${donationsVictor}" var="donation">
                    <tr>
                        <td>
                            <c:out value="${donation.moment}" />
                        </td>
                        <td>
                            <c:out value="${donation.amount}" />
                        </td>
                        <td>
                            <c:out value="${donation.donator.firstName} ${donation.donator.lastName}" />
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <c:if test="${cause.budgetTarget >  totalBudgetAchieved}">
            <a href="new">Register a donation</a>
        </c:if>
        <spring:url value="/cause/list" var="causeUrl">
        </spring:url>
        <a class="btn btn-default" href="${fn:escapeXml(causeUrl)}">Go back</a>
    </jsp:body>
</petclinic:layout>