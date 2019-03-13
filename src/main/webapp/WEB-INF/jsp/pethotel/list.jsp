<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="petHotels">
    <h2>Pet Hotel</h2>

    <jsp:attribute name="customScript">
        <script>
            $(function () {
                $("#birthDate").datepicker({dateFormat: 'yy/mm/dd'});
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <form:form modelAttribute="petHotel" class="form-horizontal">
            <div class="form-group has-feedback">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Owner</label>
                    <div class="col-sm-10">
                        <c:out value="${pet.owner.firstName} ${pet.owner.lastName}"/>
                    </div>
                </div>
                <petclinic:inputField label="Name" name="name"/>
                <petclinic:inputField label="Birth Date" name="birthDate"/>
                <div class="control-group">
                    <petclinic:selectField name="type" label="Type " names="${types}" size="5"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <c:choose>
                        <c:when test="${pet['new']}">
                            <button class="btn btn-default" type="submit">Add Pet</button>
                        </c:when>
                        <c:otherwise>
                            <button class="btn btn-default" type="submit">Update Pet</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>

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
