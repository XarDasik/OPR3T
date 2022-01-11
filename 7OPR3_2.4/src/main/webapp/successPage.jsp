<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Text has been successfully added</title>
    <jsp:include page="header.jsp" />
</head>
<body>
<div id="intro" class="bg-image shadow-2-strong">
    <div class="mask" style="background-color: rgba(0, 0, 0, 0.8);">
        <div class="container d-flex align-items-center justify-content-center text-center h-100">
            <div class="text-white">
                <c:if test="${code != null}">
                    <h1 class="mb-3">Text added successfully!</h1>
                    <p>Tell this code to your friend: ${code}</p><br>
                    <a class="btn btn-outline-light btn-lg m-2" href="shareText.jsp" role="button">Do you want to add another text?</a>
                </c:if>
                </div>
        </div>
    </div>
</div>
</body>
</html>
