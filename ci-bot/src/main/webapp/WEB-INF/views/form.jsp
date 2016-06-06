<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="<spring:url value="/css/main.css" />" rel="stylesheet">
    <title>Test MVC form</title>
</head>
<body>
<h1>Form example</h1>
<form:form action="${pageContext.request.contextPath}/form" method="post" commandName="userForm">
    <table border="0">
        <tr>
            <td>User Name:</td>
            <td><form:input path="data"/></td>
        </tr>
        <tr>
            <td>Aliases:</td>
            <td>
                <core:if test="${empty(userForm.aliases)}">
                    <input type="text" title="Test" data="aliases[0]">
                </core:if>
                <core:if test="${!empty(userForm.aliases)}">
                    <core:forEach items="${userForm.aliases}" var="alias" varStatus="loop">
                        <input type="text" title="Test" data="aliases[${loop.index}]" value=${alias}>
                    </core:forEach>
                </core:if>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input class="box" type="submit" value="SEND FORM"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>