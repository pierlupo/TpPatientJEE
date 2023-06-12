<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 12/06/2023
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%--user?action=login pour accéder au fomrulaire de login--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <jsp:include page="../includes/head.jsp" />
</head>
<body>
<jsp:include page="../includes/header.jsp" />
<div class="loginFormContainer">
    <h1>Log In</h1>
    <c:if test="${messageError != null}">
        <div>${messageError}</div>
    </c:if>
    <form action="${pageContext.request.contextPath}/user" method="post">
        <input type="hidden" name="action" value="login">
        <div>
            <label>Login</label>
            <input type="text" name="login">
        </div>
        <div>
            <label>Password</label>
            <input type="password" name="password">
        </div>
        <div>
            <button type="submit">Valider</button>
        </div>
    </form>
</div>
</body>
</html>
