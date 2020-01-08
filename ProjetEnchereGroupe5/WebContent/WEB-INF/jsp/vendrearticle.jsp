<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link rel="icon" href="https://pbs.twimg.com/profile_images/790942822853640194/bvZIVYNp_400x400.jpg"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nouvelle Vente</title>
</head>
<body>
	<header>
		<%@include file="../fragments/header.jsp" %>
	</header>
	<div class="offset-lg-4 offset-md-3 col-xs-12 col-lg-4 col-md-6 inscription">
	<h1>Nouvelle vente</h1>
		<form action="${pageContext.request.contextPath}/CreerEnchere" method="post">
		<label for="article">Article</label>
			<input type="text" required autofocus name="article" id="article_id" class="form-control" placeholder="Nom de l'article" aria-label="Username" aria-describedby="addon-wrapping">
			<br>
			<label for="description">Description</label>
			<textarea id="story" name="description" rows="4" cols="68" placeholder="Description de l'article (couleur, taille, état, marque etc)"></textarea>
			<br><br>
			<label for="categorie">Catégorie</label>
   				<div class="categorie" id="categorie" name="categorie" cols="68">
    			<select name="categorie" size="1">
   				 <option value="1">Informatique
   				 <option value="2">Ameublement
   			 	 <option value="3">Vêtements
   				 <option value="4">Sports & Loisirs
   			 </select>
   			 </div>
   			 <br>
   			 <label for="photo">Ajoutez une photo</label>
   			 <br>
   			 <input type="file"
       		 id="photo" name="photo"
       		 accept="image/png, image/jpeg">
       		 <br><br>
       		 <label for="miseaprix">Mise à prix</label>
       		 <br>
       		 <input type="number" id="miseaprix" name="miseaprix"
       			min="0" max="">
       		 <br><br>
      		 <label for="datefin">Date limite de l'enchère</label>
      		 <br>
			<input type="date" id="findate" name="findate"
       		value="localdate"
      		 min="2020-01-02" max="2021-01-01">
      		 <br><br><br>
      		 <h1>Retrait de l'article</h1>
      		 <br>
      		 <label for="rue">Rue</label>
      		 <input type="text" required autofocus name="rue" id="rue_id" class="form-control" placeholder="Rue et N°" aria-label="Username" aria-describedby="addon-wrapping">
      		 <label for="codePostal">Code Postal</label>
      		 <input type="text" required autofocus name="codePostal" id="codePostal_id" class="form-control" placeholder="Code postal" aria-label="Username" aria-describedby="addon-wrapping">
      		 <label for="ville">Ville</label>
      		 <input type="text" required autofocus name="ville" id="ville_id" class="form-control" placeholder="Ville" aria-label="Username" aria-describedby="addon-wrapping">
			 <br>
			 <button class="btn btn-light" type="submit">Valider</button>
			<a class="btn btn-light" href="${pageContext.request.contextPath}/" role="button">Annuler</a>
      		 
   			 
			
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