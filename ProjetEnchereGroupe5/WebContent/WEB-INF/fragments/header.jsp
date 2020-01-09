<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--  p-2 mb-3align-baseline  col-sm-3 mr-auto col-md-3 col-lg-3-->
<c:if test="${!empty utilisateur}">
	<div class="row">
		<div class="col-8">
			<a href="connecte"><img class="eni" height="70" width="70"
				src="data:image/jpeg;base64,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"></img>
			</a>
		</div>

	<div class="col">
		<nav class="nav nav-pills">
			<a class="nav-link active nav-item" href="<%=request.getContextPath()%>/connecte">Ench�res</a><br> 
			<a class="nav-link active nav-item" href="<%=request.getContextPath()%>/vendrearticle">Vendre un article</a><br> 
			<a class="nav-link active nav-item" href="<%=request.getContextPath()%>/Profil">Mon profil</a>
			<a class="nav-link active nav-item" href="<%=request.getContextPath()%>/Deconnexion">D�connexion</a>
		</nav>
	</div>
</div>
</c:if>
<c:if test="${empty utilisateur}">
	<div class="row">
		<div class="col-10">
			<a href="AccueilServlet"><img class="eni" height="70" width="70"
				src="data:image/jpeg;base64,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"></img>
			</a>
		</div>
		
		<div class="col">
		<nav class="nav nav-pills">
			<a class="nav-link active nav-item" href="<%=request.getContextPath()%>/inscription">S'inscrire </a><br>
			<a class="nav-link active nav-item" href="<%=request.getContextPath()%>/connexion">Se connecter</a><br>
		</nav>
		</div>
		</div>
</c:if>


<!-- /connection -->
<!-- 		<nav class="navbar navbar-light bg-light navbar-expand-lg"> -->
<!--   <a class="navbar-brand" href="#">Logo</a> -->
<!--   <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> -->
<!--     <span class="navbar-toggler-icon"></span> -->
<!--   </button> -->
<!--   <div class="collapse navbar-collapse" id="navbarSupportedContent"> -->
<!--     <ul class="navbar-nav mr-auto"> -->
<!--       <li class="nav-item active"> -->
<!--         <a class="nav-link" href="#">Accueil</a> -->
<!--       </li> -->
<!--       <li class="nav-item"> -->
<!--         <a class="nav-link" href="#">A propos</a> -->
<!--       </li> -->
<!--       <li class="nav-item"> -->
<!--         <a class="nav-link" href="#">Services</a> -->
<!--       </li> -->
<!--       <li class="nav-item"> -->
<!--         <a class="nav-link" href="#">Contact</a> -->
<!--       </li> -->
<!--     </ul> -->
<!--   </div> -->
<!-- </nav> -->