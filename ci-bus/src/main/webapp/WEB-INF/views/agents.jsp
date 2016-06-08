<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="baseURL"
       value="${fn:replace(pageContext.request.requestURL, pageContext.request.requestURI, pageContext.request.contextPath)}"/>

<head>
    <link href="<spring:url value="/css/main.css" />" rel="stylesheet">
    <link href="<spring:url value="/css/header.css" />" rel="stylesheet">
    <title>Dashboard</title>
</head>
<body>
<%@ include file="header.jsp" %>
<h1>Agents</h1>

<ul>
    <core:forEach var="agent" items="${agentsList}">
        <li class="list-item">
            <div class="list-item-title">${agent.name}</div>
            <div class="list-item-content">
                <span>URI</span>
                <span>${baseURL}/skype/${agent.hash}</span>
            </div>
            <div class="list-item-tools">
                <span><a href="${pageContext.request.contextPath}/agents/${agent.id}">Edit</a></span>
                <span><a href="${pageContext.request.contextPath}/agents/${agent.id}/remove">Remove</a></span>
            </div>
        </li>
    </core:forEach>
</ul>
<div class="add-button">
    <span><a href="${pageContext.request.contextPath}/agents/new">Add Agent</a></span>
</div>
</body>
</html>