<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="petHotels">
    <h2>Pet Hotel</h2>

    <table id="petHotel" class="table table-striped">
        <thead>
        <tr>
            <th>Owner</th>
            <th>Pet</th>
            <th>Init Date</th>
            <th>End Date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${petHotels}" var="room">
                <tr>
                    <td>
                        <c:out value="${room.pet.owner.firstName} ${room.pet.owner.lastName}"/>
                    </td>
                    <td>
                        <c:out value="${room.pet.name}"/>
                    </td>
                    <td>
                        <c:out value="${room.initDate}"/>
                    </td>
                    <td>
                        <c:out value="${room.endDate}"/>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</petclinic:layout>
