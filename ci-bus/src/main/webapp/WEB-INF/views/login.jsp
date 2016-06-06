<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link href="<spring:url value="/css/main.css" />" rel="stylesheet">
    <title>Login</title>
</head>
<body>

<h1>Login form</h1>
<core:if test="${param.containsKey(\"error\")}">
    <p>Authorization failed</p>
</core:if>
<form id="login-form" action="<spring:url value="/login"/>" method="post">
    <table border="0">
        <tr>
            <td>Name:</td>
            <td><input type="text" name="username" path="username"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" path="password"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Login"/>
            </td>
        </tr>
    </table>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>