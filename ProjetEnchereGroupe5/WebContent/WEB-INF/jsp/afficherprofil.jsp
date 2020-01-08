<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link rel="icon" href="https://pbs.twimg.com/profile_images/790942822853640194/bvZIVYNp_400x400.jpg"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profil de ${profil.getPseudo()}</title>
</head>
<body>
	<header>
		<%@include file="../fragments/header.jsp" %>
	</header>
	<c:if test="${! empty erreurAfficherProfil}">
		<h3 class = "offset-lg-3 offset-md-3 col-xs-12 col-lg-6 col-md-6 erreur">${erreurAfficherProfil}</h3>
	</c:if>
	<c:if test="${! empty profil}">
		<div class="offset-lg-4 offset-md-3 col-xs-12 col-lg-4 col-md-6 inscription">
			<h1>Profil de ${profil.getPseudo()}</h1>
			<c:if test="${profil.getAdministrateur()}">
				<h2>Administrateur</h2>
			</c:if>
				<label for="pseudo">Pseudo</label>
				<input type="text" required name="pseudo" id="pseudo_id" class="form-control" placeholder="${profil.getPseudo()}" disabled>
	  			<label for="nom">Nom</label>
	  			<input type="text" required name="nom" id="nom_id" class="form-control" placeholder="${profil.getNom()}" disabled>
	  			<label for="prenom">Prénom</label>
	  			<input type="text" required name="prenom" id="prenom_id" class="form-control" placeholder="${profil.getPrenom()}" disabled>
	  			<label for="email">E-mail</label>
	  			<input type="email" required name="email" id="email_id" class="form-control" placeholder="${profil.getEmail()}" disabled>
	  			<label for="telephone">N° de téléphone</label>
	  			<input type="tel" required name="telephone" id="telephone_id" class="form-control" placeholder="${profil.getTelephone()}" disabled>
	  			<label for="rue">Rue</label>
	  			<input type="text" required name="rue" id="rue_id" class="form-control" placeholder="${profil.getRue()}" disabled>
	  			<label for="codePostal">Code Postal</label>
	  			<input type="text" required name="codePostal" id="codePostal_id" class="form-control" placeholder="${profil.getCodePostal()}" disabled>
	  			<label for="ville">Ville</label>
	  			<input type="text" required name="ville" id="ville_id" class="form-control" placeholder="${profil.getVille()}"disabled>
		</div>
	</c:if>
	<footer>
		<%@include file="../fragments/footer.jsp" %>
	</footer>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>