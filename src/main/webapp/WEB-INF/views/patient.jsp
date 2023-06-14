<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 06/06/2023
  Time: 09:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patientèle</title>
    <jsp:include page="../includes/head.jsp" />
</head>
<body>
<jsp:include page="../includes/header.jsp" />
<div class="containerBase">
<div class="box1">

<h2>Liste de patients :</h2>
<hr>

<c:forEach items = "${patientList}" var="patient">

    <strong>Nom du patient :</strong> ${patient.getLastName()}
    <a href="${pageContext.request.contextPath}/?id=${patient.getId()}">  ->  Détails</a><br>

</c:forEach>
<hr>

</div>



<div class="box2">

    <h2>Rechercher un patient :</h2>
    <hr>

    <form action="" method="post">
        <input type="hidden" name="action" value="search">
        <div class="search"><label for="search">Recherche :</label><input type="search" name="search" id="search"  placeholder="Enter a name…"/></div>
        <div class="btnSearch"><button type="submit" name="research">Rechercher</button></div>
    </form>
    <hr>
</div>
    <div class="box2">
    <h2>Ajouter un patient :</h2>
    <hr>
    <c:if test="${isLogged == true}">
    <form  method="post" >
        <input type="hidden" name="test" />
        <div><label for="lastname">Lastname :</label><input type="text" name="lastname" id="lastname" /></div>
        <div><label for="firstname">Firstname :</label><input type="text" name="firstname" id="firstname"/></div>
        <div><label for="email">Email :</label><input type="text" name="email" id="email" /></div>
        <div><label for="tel">Tel :</label><input type="text" name="tel" id="tel"/></div>
<%--        <div><label for="image">Upload :</label><input type="file" name="image" id="image"/></div>--%>
        <div class="btn0"><input type="submit" name="ajouter" value="ajouter" class="btn"></div>
    </form>
    </c:if>
    <hr>
    </div>
</div>

</div>

</body>
</html>
