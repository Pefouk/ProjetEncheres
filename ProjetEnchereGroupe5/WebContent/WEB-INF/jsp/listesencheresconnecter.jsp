<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet">
<link rel="icon"
	href="https://pbs.twimg.com/profile_images/790942822853640194/bvZIVYNp_400x400.jpg" />
<title>Nouvelle vente</title>
</head>
<body>
	<header>
		<%@include file="../fragments/header.jsp"%>
	</header>

	<main>
	<div class="container">
		<h1 class="text-center">Liste des enchères</h1>

	</div>

	<form action="<%=request.getContextPath()%>/connecte" method="get">
		<div class="row">
			<div class="col">
				<div class="form-check">
					<label for="filtres">Filtres :</label> <input type="text"
						name="filtres" id="filtres" /><br> <label for="categorie">Catégories :</label>
						<select name="categorie">
						<option value="Toutes" selected>Toutes</option>
						<option value="Ameublement">Ameublement</option>
						<option value="Informatique">Informatique</option>
						<option value="Vetement">Vetement</option>
						<option value="Sport&Loisir">Sport & Loisir</option>
					</select><br>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="col">
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="gridCheck1"
						value="achats"> <label class="form-check-label"
						for="gridCheck1">Achats</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="gridRadios"
						id="gridRadios1" value="encheres" checked> <label
						class="form-check-label" for="gridRadios1"> Enchères
						ouvertes </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="gridRadios"
						id="gridRadios2" value="encheresencours"> <label
						class="form-check-label" for="gridRadios2"> Mes enchères
						en cours </label>
				</div>
				<div class="form-check disabled">
					<input class="form-check-input" type="radio" name="gridRadios"
						id="gridRadios3" value="encheresremportees"> <label
						class="form-check-label" for="gridRadios3"> Mes enchères
						remportées </label>
				</div>
			</div>

			<div class="col-4">
				<div class="form-check form-check-inline">
					<input class="form-check-input" type="checkbox" id="gridCheck1"
						value="ventes"> <label class="form-check-label"
						for="gridCheck1">Mes ventes</label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="gridRadios"
						id="gridRadios1" value="ventesencours"> <label
						class="form-check-label" for="gridRadios1"> Mes ventes en
						cours </label>
				</div>
				<div class="form-check">
					<input class="form-check-input" type="radio" name="gridRadios"
						id="gridRadios2" value="ventesnondebutees"> <label
						class="form-check-label" for="gridRadios2"> Ventes non
						débutées </label>
				</div>
				<div class="form-check disabled">
					<input class="form-check-input" type="radio" name="gridRadios"
						id="gridRadios3" value="ventesterminees"> <label
						class="form-check-label" for="gridRadios3"> Ventes
						terminées </label>
				</div>
			</div>
			<div class="col">
				<div class="form-check form-check-inline">
					<input type="submit" value="Rechercher" />
				</div>
			</div>
		</div>

		<c:forEach items="${listeEnchere}" var="enchere" varStatus="loop">
			<tr>
				<div class="offset-lg-4 offset-md-3 col-xs-12 col-lg-4 col-md-6 inscription">
					<a href="${pageContext.request.contextPath}/AfficherEnchere?noArticle=${enchere.getArticle().getNoArticle()}" style="display: block; width: 100%; height: 100%;">
						<td><c:out value="${enchere.getArticle().getNomArticle()}"></c:out>
							<br></td>
						<td><c:out value="${enchere.getArticle().getPrixInitial()}"></c:out>
							<br></td>
						<td><c:out value="${enchere.getArticle().getFinEncheres()}"></c:out>
							<br></td>
						<td><c:out value="${enchere.getPseudoUtilisateur()}"></c:out>
							<br></td>
					</a>
				</div>


			</tr>
		</c:forEach>



	</form>
	</main>
	<footer>
		<%@include file="../fragments/footer.jsp"%>
	</footer>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>