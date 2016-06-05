<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link href="<spring:url value="/css/main.css" />" rel="stylesheet">
    <title>Hello Spring MVC</title>
</head>
<body>
<h1>${message}</h1>
<h2>${message}</h2>
<p>User Id: ${userId}</p>
<core:if test="${id != null}">
    <p>Id != test. Printing table</p>
    <table id="list" border="1px">
        <tr>
            <td>Id attribute</td>
            <td class="myclass">${id}</td>
            <td><a href="${pageContext.request.contextPath}/cars/path/${id}">link</a></td>
        </tr>
        <tr>
            <td>Index attribute</td>
            <td class="myclass">${index}</td>
            <td><a href="${pageContext.request.contextPath}/cars/path/${id}">link</a></td>
        </tr>
        <tr>
            <td>Index attribute</td>
            <td class="myclass">${index}</td>
            <td><a href="${pageContext.request.contextPath}/cars/path/${id}">link</a></td>
        </tr>
    </table>
</core:if>
</body>
</html>