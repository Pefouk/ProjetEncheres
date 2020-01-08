<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link rel="icon" href="https://pbs.twimg.com/profile_images/790942822853640194/bvZIVYNp_400x400.jpg"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Détails vente</title>
</head>
<body>
	<header>
		<%@include file="../fragments/header.jsp" %>
	</header>
	<div class="offset-lg-4 offset-md-3 col-xs-12 col-lg-4 col-md-6 inscription">
	<h1>Détails vente</h1>
		<label for="article">Article</label>
			<input type="text" required autofocus name="article" id="article_id" class="form-control" placeholder="${enchere.getArticle().getNomArticle()}" aria-label="Username" aria-describedby="addon-wrapping" disabled>
			<br>
			<label for="description">Description</label>
			<textarea id="story" name="description" rows="4" cols="68" placeholder="${enchere.getArticle().getDescription()}" disabled></textarea>
			<br><br>
			<label for="categorie">Catégorie</label>
   				<div class="categorie" id="categorie" name="categorie" cols="68">
    			<select name="categorie" size="1" disabled>
   				 <option value="1">${enchere.getArticle().getCategorie().getLibelle()}</option>
   			 </select>
   			 </div>
   			 <br>
   			 <label for="photo">Ajoutez une photo</label>
   			 <br>
   			 <input type="file" id="photo" name="photo" accept="image/png, image/jpeg" disabled>
       		 <br><br>
       		 <label for="meilleuro">Meilleure offre :</label>
       		 <br>
       		 <input type="number" id="meilleuro" name="meilleuro" min="0" placeholder="${enchere.getArticle().getPrixVente()}" disabled>
       		 <br>
       		 <label for="miseaprix">Mise à prix</label>
       		 <br>
       		 <input type="number" id="miseaprix" name="miseaprix" min="0"  placeholder="${enchere.getArticle().getPrixInitial()}" disabled>
       		 <br><br>
      		 <label for="datefin">Fin de l'enchère</label>
      		 <br>
			<input type="text" id="datefin" name="datefin" min="2020-01-02" placeholder="${enchere.getArticle().getFinEncheres().toString()}" disabled >
      		 <br><br><br>
      		 <h1>Retrait de l'article</h1>
      		 <br>
      		 <label for="rue">Rue</label>
      		 <input type="text" required autofocus name="rue" id="rue_id" class="form-control" placeholder="${enchere.getArticle().getRetrait().getRue()}" aria-label="Username" aria-describedby="addon-wrapping" disabled>
      		 <label for="codePostal">Code Postal</label>
      		 <input type="text" required autofocus name="codePostal" id="codePostal_id" class="form-control" placeholder="${enchere.getArticle().getRetrait().getCodePostal()}" aria-label="Username" aria-describedby="addon-wrapping" disabled>
      		 <label for="ville">Ville</label>
      		 <input type="text" required autofocus name="ville" id="ville_id" class="form-control" placeholder="${enchere.getArticle().getRetrait().getVille()}" aria-label="Username" aria-describedby="addon-wrapping" disabled>
			 <br>
		</div>
	<footer>
		<%@include file="../fragments/footer.jsp" %>
	</footer>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</html>