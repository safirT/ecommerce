<%@page import="formation.ecommerce.presentation.springmvc.controller.AjouterProduitController"%>
<%@page import="formation.ecommerce.presentation.springmvc.form.ProduitForm"%>
<%@include file="includes/commun.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="catalogue.title" /></title>
<link rel="stylesheet" type="text/css" href="css/style.css" media="all"/>
</head>
<body>
	<h1>
		<spring:message code="catalogue.title" /><br/>
		<spring:message code="accueil.salutations" />
		${nomUtilisateur}
	</h1>
	<%@include file="includes/boutton.jsp"%><br/>
	<form:form commandName="<%=AjouterProduitController.PRODUIT_FORM %>" method="POST" cssClass="formulaire">
		<div class="formItem"><label for="id">Id : </label><form:input path="<%=ProduitForm.FIELD_ID %>"/></div>
		<div class="formItem"><label for="libelle">Libelle : </label><form:input path="<%=ProduitForm.FIELD_LIBELLE %>"/></div>
		<div class="formItem"><label for="prix">Prix : </label><form:input path="<%=ProduitForm.FIELD_PRIX %>"/></div>
		<div class="formItem"><input type="submit" value="Valider"/></div>
		${erreurProduitExistant}
		${erreurIdNegatif}
		${erreurLibelle}
		${erreurPrixNégatif}
		<form:errors path="idProduit" cssClass="erreure" element="div">Le champ Id est requis ou incorect</form:errors><br/>
		<form:errors path="libelleProduit" cssClass="erreure" element="div">Le champ Libelle est requis ou incorect</form:errors><br/>
		<form:errors path="prixProduit" cssClass="erreure" element="div">Le champ Prix est requis ou incorect</form:errors><br/>
	</form:form>
</body>
</html>