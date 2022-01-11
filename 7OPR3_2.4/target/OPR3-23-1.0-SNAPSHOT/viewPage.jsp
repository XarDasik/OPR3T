<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="databaseService"
             class="com.example.opr323.Service.DatabaseService"
             scope="session"/>
<html>
<head>
    <title>Záznamy v databázi</title>
</head>
<body>
    <h1>Záznamy v databázi</h1>
<table>
    <tr>
        <th>Jméno</th>
        <th>Příjmení</th>
    </tr>
    <c:forEach var="item" items="${databaseService.get()}">
        <tr>
            <td>${item.getName()}</td>
            <td>${item.getSurname()}</td>
        </tr>
    </c:forEach>
</table>
    <a href="insertPage.jsp">Vložte něco do databáze</a><br>


</body>
</html>
