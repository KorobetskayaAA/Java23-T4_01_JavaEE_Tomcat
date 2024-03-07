<%@ page
    contentType="text/html; charset=UTF-8"
    import="ru.teamscore.java23.cities.*"
%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<caption class="m1"><h2>Список городов</h2></caption>
<table class="table">
    <thead>
        <tr>
            <th>Страна</th>
            <th>Название</th>
            <th>Население</th>
            <th>Координаты</th>
            <th colspan=2>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="city" items="${cities}">
            <tr>
                <td><c:out value="${city.getCountry().getName()}" /></td>
                <td><c:out value="${city.name}" /></td>
                <td><c:out value="${city.population}" /></td>
                <td><c:out value="${city.lat}" />, <c:out value="${city.lon}" /></td>
                <td>
                    <a href="/city/edit?city_name=<c:out value='${city.name}' />">Edit</a>
                </td>
                <td>
                    <a href="/city/delete?city_name=<c:out value='${city.name}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>