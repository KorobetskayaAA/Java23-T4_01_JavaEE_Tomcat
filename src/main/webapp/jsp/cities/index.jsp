<%@ page
    contentType="text/html; charset=UTF-8"
    import="ru.teamscore.java23.cities.*"
%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%!
    String title = "JSP CRUD - Города";
 %>
<!DOCTYPE html>
<html lang="ru">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title><%= title %></title>
    </head>
    <body class="p-3">
        <div class="m-2">
            <h1><%= title %></h1>
        </div>
        <div class="m-2">
            <a href="/city/new" class="btn btn-primary">Добавить город</a>
        </div>
        <div class="m-2">
            <jsp:include page="city-list.jsp"></jsp:include>
        </div>
    </body>
</html>