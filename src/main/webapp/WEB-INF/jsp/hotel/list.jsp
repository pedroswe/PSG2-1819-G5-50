<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<petclinic:layout pageName="petHotels">
    <jsp:attribute name="customScript">
        <script>
            $(function () {
                $("#initDate").datepicker({dateFormat: 'yy/mm/dd'});
                $("#endDate").datepicker({dateFormat: 'yy/mm/dd'});
            });
        </script>
    </jsp:attribute>

    <jsp:body>
        
    <h2>Pet Hotel</h2>
    <form:form modelAttribute="petHotel" class="form-inline">
        <petclinic:selectField name="pet" label="Pet " names="${pets}" size="5"/>
        <petclinic:inputField label="Init Date" name="initDate"/>
        <petclinic:inputField label="End Date" name="endDate"/>
        <div class="form-group">
            <button class="btn btn-default" type="submit">Add Entry</button>
        </div>
    </form:form>

    <br>
    
    <table id="petHotel" class="table table-striped">
        <thead>
        <tr>
            <th>Owner</th>
            <th>Pet</th>
            <th>Init Date</th>
            <th>End Date</th>
            <th>Delete</th>
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
                    <td>
                        <a href="/pethotel/delete/${room.id}"><img src="/resources/images/papelera.png" alt="delete"></a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </jsp:body>
</petclinic:layout>
