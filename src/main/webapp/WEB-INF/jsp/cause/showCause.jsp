<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>



<petclinic:layout pagename="showCause">

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
                <c:forEach items="${donations}" var="donation">
                    <tr>
                        <td>
                            <c:out value="$donation.donationDate" />
                        </td>
                        <td>
                            <c:out value="$donation.amount" />
                        </td>
                        <td>
                            <c:out value="$donation.donator" />
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </jsp:body>
</petclinic:layout>