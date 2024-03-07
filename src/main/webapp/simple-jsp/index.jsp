<%-- Настройки страницы. Кодировка для http-header --%>
<%@ page
      contentType="text/html; charset=UTF-8"
      import="java.time.LocalDateTime,java.time.format.DateTimeFormatter" %>
<%-- Поля и методы --%>
<%!
    // Это значение будет присвоено один раз при создании класса сервлета
    LocalDateTime appRunnedAt = LocalDateTime.now();
    DateTimeFormatter rusDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy hh:mm:ss");
    String header = "JSP - Базовые примеры";
    String[] names = new String[]{"Alice", "Bob", "Сьюзи"};
    int square(int n){
        return n * n;
    }
%>
<%-- Локальные переменные и код --%>
<%
    // Это значение будет присвоено при каждой загрузке страницы (вызове метода сервлета)
    LocalDateTime pageLoadedAt = LocalDateTime.now();
 %>
<!DOCTYPE html>
<html lang="ru">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title><%= header %></title>
  </head>
  <body>
    <h2><%= header %></h2>
    <p>Время сборки <%= appRunnedAt.format(rusDateFormatter) %></p>
    <p>Время загрузки <%= pageLoadedAt.format(rusDateFormatter) %></p>
    <p>2 + 2 = <%= 2 + 2 %></p>
    <p>5 > 2 = <%= 5 > 2 %></p>
    <p><%= new String("Hello").toUpperCase() %></p>
    <ul>
    <%
        for (String name : names) {
            out.println("<li>Hello, " + name + "!</li>");
        }
    %>
    </ul>
  </body>
</html>
