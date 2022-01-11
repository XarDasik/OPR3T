<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vložte něco do databáze</title>
</head>
<body>
<h1>Vložte něco do databázze</h1>
<form method="post" action="insert-person">
    <label>Jméno:</label>
    <input type="text" name="name" id="name" required>
    <label>Příjmení:</label>
    <input type="text" name="surname" id="surname" required>
    <button type="submit">Vložit</button>
    <a href="viewPage.jsp">Podívejte se na záznamy v databázi</a>
</form>
</body>
</html>
