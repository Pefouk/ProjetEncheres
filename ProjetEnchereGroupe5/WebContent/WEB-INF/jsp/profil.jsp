<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mon Profil</title>
</head>
<body>
	<header>
		<%@include file="../fragments/header.jsp" %>
	</header>
	<div class="offset-lg-4 offset-md-3 col-xs-12 col-lg-4 col-md-6 inscription">
		<form action="${pageContext.request.contextPath}/ModifierProfil" method="get">
		<label for="pseudo">Pseudo</label>
			<input type="text" required name="pseudo" id="pseudo_id" class="form-control" placeholder="${utilisateur.getPseudo()}" aria-label="Username" aria-describedby="addon-wrapping" disabled>
  			<label for="nom">Nom</label>
  			<input type="text" required name="nom" id="nom_id" class="form-control" placeholder="${utilisateur.getNom()}" aria-label="Username" aria-describedby="addon-wrapping" disabled>
  			<label for="prenom">Pr�nom</label>
  			<input type="text" required name="prenom" id="prenom_id" class="form-control" placeholder="${utilisateur.getPrenom()}" aria-label="Username" aria-describedby="addon-wrapping" disabled>
  			<label for="email">E-mail</label>
  			<input type="email" required name="email" id="email_id" class="form-control" placeholder="${utilisateur.getEmail()}" aria-label="Username" aria-describedby="addon-wrapping" disabled>
  			<label for="telephone">N� de t�l�phone</label>
  			<input type="tel" required name="telephone" id="telephone_id" class="form-control" placeholder="${utilisateur.getTelephone()}" aria-label="Username" aria-describedby="addon-wrapping"disabled>
  			<label for="rue">Rue</label>
  			<input type="text" required name="rue" id="rue_id" class="form-control" placeholder="${utilisateur.getRue()}" aria-label="Username" aria-describedby="addon-wrapping" disabled>
  			<label for="codePostal">Code Postal</label>
  			<input type="text" required name="codePostal" id="codePostal_id" class="form-control" placeholder="${utilisateur.getCodePostal()}" aria-label="Username" aria-describedby="addon-wrapping" disabled>
  			<label for="ville">Ville</label>
  			<input type="text" required name="ville" id="ville_id" class="form-control" placeholder="${utilisateur.getVille()}" aria-label="Username" aria-describedby="addon-wrapping" disabled>
  			<label for="motDePasse">Mot de passe</label>
  			<input type="password" required name="motDePasse" id="motDePasse_id" class="form-control" placeholder="********" aria-label="Username" aria-describedby="addon-wrapping" disabled>
  			<br>
  			<input type="submit" alt="Submit" value="Modifier" class="btn btn-light" placeholder="Modifier">
		</form>
	</div>
	<footer>
		<%@include file="../fragments/footer.jsp" %>
	</footer>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>