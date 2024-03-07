<%@ page
    contentType="text/html; charset=UTF-8"
    import="ru.teamscore.java23.cities.*"
%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<h2>${city == null ? 'Добавить ' : 'Изменить '} город <c:out value='${city.name}' /></h2>

<form action="${city == null ? 'create' : 'update'}" method="post">
    <div class="row my-2">
        <div class="col">
            <label for="input-name" class="form-label">Название</label>
            <input type="${city != null ? "hidden" : "text"}" class="form-control"
                    id="input-name"
                    name="name"

                    placeholder="Название города"
                    value="${city.name}"
            />
        </div>
    </div>
    <div class="row my-2">
        <div class="col">
            <label for="input-country" class="form-label">Страна</label>
            <select id="input-country" class="form-control" name="country">
                <c:forEach var="country" items="${countries}">
                    <option ${country.name == city.country.name ? "selected" : ""} value="${country.code}">
                        <c:out value='${country.name}' />
                    </option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="row my-2">
        <div class="col">
            <label for="input-population" class="form-label">Численность населения, чел.</label>
            <input type="numeric" class="form-control"
                    id="input-population"
                    name="population"
                    placeholder="Численность населения"
                    value="${city.population}"
            />
        </div>
    </div>
    <div class="row my-2">
    <div class="col">
        <label for="input-lat" class="form-label">Широта</label>
        <input type="numeric" class="form-control"
                id="input-lat"
                name="lat"
                placeholder="Широта"
                value="${city.lat}"
        />
    </div>
    <div class="col">
        <label for="input-lon" class="form-label">Долгота</label>
        <input type="numeric" class="form-control"
                id="input-lon"
                name="lon"
                placeholder="Долгота"
                value="${city.lon}"
        />
    </div>
    </div>
    <div class="row mt-5">
        <div class="col">
            <input type="submit" value="Сохранить" class="btn btn-primary"/>
        </div>
    </div>
</form>