<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>



<petclinic:layout pageName="showCause">

    <jsp:body>
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
            <a href="create">Register a donation</a>
        </c:if>
    </jsp:body>
</petclinic:layout>