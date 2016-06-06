<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="header">
    <div class="header_menu">
        <a href="${pageContext.request.contextPath}/">Dashboard</a>
        <a href="${pageContext.request.contextPath}/#">Agents</a>
        <a href="${pageContext.request.contextPath}/#">Configuration</a>
    </div>
    <div class="userData">
        <span>Hello, ${username}!</span>
        <form id="logout-form" action="<spring:url value="/logout"/>" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="Logout"/>
        </form>
    </div>
</div>