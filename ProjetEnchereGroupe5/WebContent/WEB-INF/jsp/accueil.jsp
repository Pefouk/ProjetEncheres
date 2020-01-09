<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link rel="icon" href="https://pbs.twimg.com/profile_images/790942822853640194/bvZIVYNp_400x400.jpg"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
</head>
<body>

<header>
<!-- Faire un include pour importer le header.html -->
<%@include file="../fragments/header.jsp" %>
</header>
<main>
<div class="container">
<h1 class="text-center">Liste des enchères</h1> 

</div>
<form>


</form>
<form action="<%=request.getContextPath()%>/AccueilServlet" method="post">
<label for="filtres">Filtres :</label>
<input type="text" name="filtres" id="filtres"/><br>

<label for="categorie">Catégories :</label>
<select name="categorie">
    <option value="Toutes" selected>Toutes</option>
    <option value="Ameublement">Ameublement</option>
    <option value="Informatique">Informatique</option>
    <option value="Vetement">Vetement</option>
    <option value="Sport&Loisir">Sport & Loisir</option>
</select>
<input type="submit" value="Rechercher"/>
</form>

<h2>Listes de toutes les enchères en cours</h2>

 <c:forEach items="${listeEnchere}" var="enchere"  varStatus="loop">
    <tr>                                     
   <%--<td> ${loop.count} </td>     --%>
 <div class="offset-lg-4 offset-md-3 col-xs-12 col-lg-4 col-md-6 inscription">
 <a href="${pageContext.request.contextPath}/AfficherEnchere?noArticle=${enchere.getArticle().getNoArticle()}" style="display:block;width:100%;height:100%;">
         <td><c:out value="${enchere.getArticle().getNomArticle()}"></c:out> <br></td> 
         <td><c:out value="${enchere.getArticle().getPrixInitial()}"></c:out> <br></td>
         <td><c:out value="${enchere.getArticle().getFinEncheres()}"></c:out> <br></td>
         <td><c:out value="${enchere.getPseudoUtilisateur()}"></c:out> <br></td>
</a>
</div>
 
 
    </tr>
   </c:forEach>
</main>
<footer>

<!-- Faire un "include pour importer le Footer.html -->
<%@include file="../fragments/footer.jsp" %>

</footer>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>

