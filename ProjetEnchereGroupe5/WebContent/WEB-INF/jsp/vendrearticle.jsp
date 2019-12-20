<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nouvelle Vente</title>
</head>
<body>
	<header>
		<%@include file="../fragments/header.jsp" %>
	</header>
	<div class="offset-lg-4 offset-md-3 col-xs-12 col-lg-4 col-md-6 inscription">
	<h1>Nouvelle vente</h1>
		<form action="${pageContext.request.contextPath}/vendrearticle" method="post">
		<label for="article">Article</label>
			<input type="text" required autofocus name="article" id="article_id" class="form-control" placeholder="" aria-label="Username" aria-describedby="addon-wrapping">
			<br>
			<label for="description">Description</label>
			<textarea id="story" name="story" rows="4" cols="68">
			</textarea>
			<br><br>
			<label for="categorie">Catégorie</label>
   				<div class="categorie" id="categorie" name="categorie" cols="68">
    			<select name="categorie" size="1">
   				 <option>Informatique
   				 <option>Ameublement
   			 	 <option>Vêtements
   				 <option>Sports & Loisirs
   			 </select>
   			 </div>
   			 <br>
   			 <label for="photo">Ajoutez une photo</label>
   			 <br>
   			 <input type="file"
       		 id="photo" name="photo"
       		 accept="image/png, image/jpeg">
       		 <br><br>
       		 <label for="number">Mise à prix</label>
       		 <br>
       		 <input id="number" type="number" value="0">
       		 <br><br>
       		 <label for="datedebut">Début de la mise en vente</label>
			<input type="date" id="debutdate" name="debutdate"
       		value="2018-07-22"
      		 min="2018-01-01" max="2018-12-31">
      		 <br>
      		 <label for="datefin">Fin de la mise en vente</label>
			<input type="date" id="findate" name="findate"
       		value="localdate"
      		 min="localdate" max="2018-12-31">
   			 
			
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