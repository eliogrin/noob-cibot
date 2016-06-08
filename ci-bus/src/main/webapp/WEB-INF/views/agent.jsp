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
<h1>Agent</h1>

<form:form modelAttribute="agentForm" action="${pageContext.request.contextPath}/agents" method="post">
    <table>
        <tr>
            <td><span class="list-item-title">Name</span></td>
            <td><span><form:input path="name"/></span></td>
        </tr>
        <tr>
            <td><span class="list-item-title">Password</span></td>
            <td><span><form:input path="password"/></span></td>
        </tr>
        <tr>
            <td><span class="list-item-title">Hash</span></td>
            <td><span><form:input path="hash"/></span></td>
        </tr>
    </table>
    <form:hidden path="id"/>
    <%--<form:button name="new">Save</form:button>--%>
    <form:button>Save</form:button>
</form:form>
</body>
</html>