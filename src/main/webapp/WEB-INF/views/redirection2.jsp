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
  <title>Détails du Patient ${patient.getId()}</title>
  <jsp:include page="../includes/head.jsp" />
</head>
<body>
<a href="redirection-servlet"><jsp:include page="../includes/header.jsp" /></a>
<div class="containerBase">
 <div class="box1">
<h2>Détails du patient :</h2>
     <strong>Nom :</strong> ${patient.getLastName()}, <strong>Prénom :</strong> ${patient.getFirstName()}, <strong>Email :</strong> ${patient.getEmail()}, <strong>Tel :</strong> ${patient.getTel()}
 </div>
 <div class="box2">
<h2>Liste de consultations :</h2>
    ${patient.getConsultations()}
    <a href="redirection-servlet?id=${patient.getId()}">  ->  Détails</a><br>
 </div>

</div>

</body>
</html>
