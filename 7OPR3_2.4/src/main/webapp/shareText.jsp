<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Share text</title>
    <jsp:include page="header.jsp" />
</head>
<body>
<div id="intro" class="bg-image shadow-2-strong">
    <div class="mask" style="background-color: rgba(0, 0, 0, 0.8);">
        <div class="container d-flex align-items-center justify-content-center text-center h-100">
            <div class="text-white">
                <c:if test="${error != null}"><p class="text-danger text-center">Service is not running! Please try again later...</p></c:if>
                <h1 class="mb-3">Write something you want to share...</h1>
                <form method="post" action="save-servlet">
                    <label for="pin">PIN(optional, digit only):</label>
                    <input type="text" id="pin" pattern="\d*" class="form-control" name="pin" aria-label="Default" aria-describedby="inputGroup-sizing-default" value="${pin}" minlength="4" maxlength="4"><br>
                    <label for="text">Your text:</label>
                    <textarea class="form-control" id="text" rows="3" name="text" required>${text}</textarea><br>
                    <button type="submit" class="btn btn-dark btn-lg">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
