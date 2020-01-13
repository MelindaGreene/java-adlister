<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <h1>Welcome to the Adlister!</h1>
    </div>

    <c:forEach var="ad" items="${ads}">
        <ul class="ad">
            <li>Title: ${ad.title}</li>
            <li>User: ${ad.userId}</li>
            <li>description: ${ad.description}</li>
        </ul>
    </c:forEach>

</body>
</html>
