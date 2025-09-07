<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>  
    <meta charset="UTF-8">
    <title>Multi-Language Demo</title>
</head>
<body>
<c:set var="languageCode" value="${param.radLanguageCode}"></c:set>
<c:if test="${not empty languageCode }">
    <fmt:setLocale value="${languageCode}" scope="session"/>
</c:if>
<fmt:setBundle basename="resource" scope="session"/>
<form action="login.jsp" method="POST">
    <fmt:message key="languageMessage"></fmt:message>
    <input type="radio" name="radLanguageCode" value="vi"
            <c:if test="${languageCode == 'vi'}"> checked</c:if> />
    <fmt:message key="vn"></fmt:message>
    <input type="radio" name="radLanguageCode" value="en"
            <c:if test="${languageCode == 'en'}"> checked</c:if> />
    <fmt:message key="en"></fmt:message>
    <input type="submit" name="submit" value="<fmt:message key='chooseButton'/>" />
    <table border="0">
        <tr>
            <td><fmt:message key="userName"/></td>
            <td><input type="text" name="txtUserName" value=""/></td>
        </tr>
        <tr>
            <td><fmt:message key="pass"/></td>
            <td><input type="password" name="txtPassword" value=""/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="submit" value="<fmt:message key='login'/>"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
