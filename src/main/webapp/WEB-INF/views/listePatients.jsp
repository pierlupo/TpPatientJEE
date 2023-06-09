<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 06/06/2023
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des Patients</title>
    <jsp:include page="../includes/head.jsp" />
</head>
<body>
<%--<a href="${pageContext.request.contextPath}/">--%>
    <jsp:include page="../includes/header.jsp" />
<%--</a>--%>
<div class="containerBase">
    <div class="box1">
        <h2>Liste de patients :</h2>
        <hr>
    <c:forEach items = "${patientList}" var="p">
        <strong>Nom du patient :</strong> ${p.getLastName()}<br>
        <strong>Prénom :</strong> ${p.getFirstName()}<br>
        <strong>Email :</strong> ${p.getEmail()}<br>
        <strong>Tel :</strong> ${p.getTel()}<br>
        <hr>
    </c:forEach>
    </div>
    <div class="box2">
        <div>
            <h2>Ajouter une consultation</h2>
            <form action="/consultation" method="post">
                <input type="hidden" name="patientId" value="${patient.getId()}">
                <div>
                    <button type="submit">Valider</button>
                </div>
            </form>
        </div>
        <h2>Liste des consultations</h2>
        <c:forEach items="${patient.getConsultations()}" var="consultation">
            <div>
                id : ${consultation.getId()}
                date : ${consultation.getdateConsultation()}
                <a href="${pageContext.request.contextPath}/consultation?id=${consultation.getId()}">Détails de la consultation</a>
            </div>
        </c:forEach>
        <hr>

    </div>
    </div>
</body>
</html>
