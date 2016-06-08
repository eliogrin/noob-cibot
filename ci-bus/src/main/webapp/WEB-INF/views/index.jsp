<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
    <link href="<spring:url value="/css/main.css" />" rel="stylesheet">
    <link href="<spring:url value="/css/header.css" />" rel="stylesheet">
    <title>Dashboard</title>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>Dashboard</h1>

<ul>
    <core:forEach var="event" items="${events}">
        <li class="list-item">
            <span class="list-item-title">${event.id}</span>
            <span>bot ID ${event.bot}</span>
            <div class="list-item-content">${event.data}</div>
        </li>
    </core:forEach>
</ul>

</body>
</html>