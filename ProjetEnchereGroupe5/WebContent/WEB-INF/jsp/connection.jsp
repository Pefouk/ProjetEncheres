<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="icon" href="https://pbs.twimg.com/profile_images/790942822853640194/bvZIVYNp_400x400.jpg"/>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion</title>
</head>
<body>
	<header>
		<%@include file="../fragments/header.jsp" %>
	</header>
	<c:if test="${! empty erreurConnexion}">
		<h3 class = "offset-lg-3 offset-md-3 col-xs-12 col-lg-6 col-md-6 erreur">${erreurConnexion}</h3>
	</c:if>
	<c:if test="${empty utilisateur}">
	<div class="offset-lg-4 offset-md-3 col-xs-12 col-lg-4 col-md-6 inscription">
	<h1>Connexion</h1>
		<form action="${pageContext.request.contextPath}/connexion" method="post">
			<input type="text" autofocus required name="email" id="email_id" class="form-control" placeholder="Email / Pseudo" aria-label="Username" aria-describedby="addon-wrapping">
  			<br>
  			<input type="password" required name="motDePasse" id="motDePasse_id" class="form-control" placeholder="Mot de passe" aria-label="Username" aria-describedby="addon-wrapping">
  			<br>
  			<input type="submit" name="submit" class = "form-control" placeholder="Inscription">
  			<br><br>
  			<a class="btn btn-danger btn-lg btn-block" href="${pageContext.request.contextPath}/oublie" role="button">Mot de passe oubli�</a>
		</form>
	</div>
	</c:if>
	<c:if test="${! empty utilisateur}">
		<h1>Vous �tes d�ja connect� ${utilisateur.getPseudo()} !</h1>
	</c:if>
	<footer>
		<%@include file="../fragments/footer.jsp" %>
	</footer>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>