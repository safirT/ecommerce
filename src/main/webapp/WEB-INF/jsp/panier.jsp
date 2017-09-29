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
		<p class="nbPanier">Nb Produits dans le panier : ${panier.quantite}</p>
		<p class="totalPanier">Montant panier : ${panier.montant} €</p><br/><br/>
	<c:if test="${panier.mapPanier.size() > 0}" >
		<table>
			<thead>
				 <tr>
				 	<th>Référence</th>
				 	<th>Libellé</th>
				 	<th>Quantité</th>
				 	<th>Prix</th>
				 	<th></th>
				 </tr>
			</thead>
			<tbody>
				<c:forEach items="${panier.mapPanier}" var="prod">
					<tr>
						<td>${prod.key.id}</td>
						<td>${prod.key.libelle}</td>
						<td>${prod.value}</td>
						<td>${prod.key.prix * prod.value} €</td>
						<td>
							<a href="supprimerProduitPanier.do?produit=${prod.key.id}">
								<button type="submit" class="suprProduitPanier">-</button>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			
		</table>
	</c:if>
</body>
</html>