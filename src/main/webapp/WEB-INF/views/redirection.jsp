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
<a href="patientlist"><jsp:include page="../includes/header.jsp" /><a>

<div class="containerBase">
<div class="box1">

<h2>Liste de patients :</h2>
<hr>

<c:forEach items = "${patientList}" var="patient">

    <strong>Nom du patient :</strong> ${patient.getLastName()}
    <a href="redirection-servlet?id=${patient.getId()}">  ->  Détails</a><br>

</c:forEach>
<hr>

</div>



<div class="box2">

    <h2>Ajouter un patient :</h2>
    <hr>

    <form action="redirection-servlet" method="post">

        <div><label for="lastname">Lastname :</label><input type="text" name="lastname" id="lastname" /></div>
        <div><label for="firstname">Firstname :</label><input type="text" name="firstname" id="firstname"/></div>
        <div><label for="email">Email :</label><input type="text" name="email" id="email" /></div>
        <div><label for="tel">Tel :</label><input type="text" name="tel" id="tel"/></div>
        <div class="btn"><button type="submit" >Submit</button></div>

    </form>
    <hr>

</div>

</div>

</body>
</html>
