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
    <title>Liste de Produits</title>
    <jsp:include page="../includes/head.jsp" />
</head>
<body>

<div>
<h2>Liste de patients :</h2>
<c:forEach items = "${patientList}" var="patient">

    Nom du patient : ${patient.getLastName()}
    <a href="redirection-servlet?id=${patient.getId()}">  ->  Détails</a><br>

</c:forEach>

</div>
<h2>Ajouter un patient :</h2>
<div>
    <form action="redirection-servlet" method="post">
        <div><label>Lastname :</label><input type="text" name="lastname" /></div>
        <div><label>Firstname :</label><input type="text" name="firstname" /></div>
        <div><label>Email :</label><input type="text" name="email" /></div>
        <div><label>Tel :</label><input type="text" name="tel" /></div>
        <div><button type="submit" >Submit</button></div>
    </form>
</div>
</body>
</html>
