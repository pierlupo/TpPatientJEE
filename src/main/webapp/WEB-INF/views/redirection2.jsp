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
  <title>Détails des Patients ${patient.getId()}</title>
  <jsp:include page="../includes/head.jsp" />
</head>
<body>
<jsp:include page="../includes/header.jsp" />

<div>
<h2>Détails des patients :</h2>
    Nom : ${patient.getLastName()}, Prénom : ${patient.getFirstName()}, Email : ${patient.getEmail()}, Tel : ${patient.getTel()}
</div>
</body>
</html>
