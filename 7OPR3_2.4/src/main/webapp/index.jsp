<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Get text</title>
    <jsp:include page="header.jsp" />
</head>
<body>
<div id="intro" class="bg-image shadow-2-strong">
    <div class="mask" style="background-color: rgba(0, 0, 0, 0.8);">

        <div class="container d-flex align-items-center justify-content-center text-center h-100">
            <div class="text-white">
                <c:if test="${invalidParameters != null}"><p class="text-danger text-center">Invalid Code or pin</p></c:if>
                <h1 class="mb-3">Share your own text with friends</h1>
                <h5 class="mb-4">A place where you can easily, for free and quickly share your text with friends.</h5>
                <form method="post" action="get-text">
                    <label for="code">Unique code:</label>
                    <input type="text" class="form-control" id="code" name="code" aria-label="Default" aria-describedby="inputGroup-sizing-default" value="${code}" required><br>
                    <label for="pin">PIN(if necessary, digit only):</label>
                    <input type="text" id="pin" pattern="\d*" class="form-control" name="pin" aria-label="Default" aria-describedby="inputGroup-sizing-default" value="${pin}" maxlength="4"><br>
                    <button type="submit" class="btn btn-dark btn-lg">Submit</button>
                </form>
                <a class="btn btn-outline-light btn-lg m-2" href="shareText.jsp" role="button">or share your own text with a friend</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
