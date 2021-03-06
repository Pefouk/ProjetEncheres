<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="icon" href="https://pbs.twimg.com/profile_images/790942822853640194/bvZIVYNp_400x400.jpg"/>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Changer de mot de passe</title>
</head>
<body>
	<header>
		<%@include file="../fragments/header.jsp" %>
	</header>	
	<c:if test="${! empty erreurChangeMdp}">
		<h3 class = "offset-lg-3 offset-md-3 col-xs-12 col-lg-6 col-md-6 erreur">${erreurChangeMdp}</h3>
	</c:if>
	<c:if test="${(! empty utilisateur) or (! empty email and ! empty pseudo)}">
		<div class="offset-lg-4 offset-md-3 col-xs-12 col-lg-4 col-md-6 inscription">
		<h1>Changer de mot de passe</h1>
			<form action="${pageContext.request.contextPath}/changerMdp" method="post">
				<input type="password" autofocus required name="motdepasse" id="motdepasse_id" class="form-control" placeholder="Nouveau mot de passe" aria-label="Password" aria-describedby="addon-wrapping">
	  			<br>
	  			<input type="password" required name="motdepasseverif" id="motdepasseverif_id" class="form-control" placeholder="Verification du nouveau mot de passe" aria-label="Password" aria-describedby="addon-wrapping">
	  			<br>
	  			<input type="submit" name="submit" class = "form-control" placeholder="Verifier compte">
			</form>
		</div>
	</c:if>
	<footer>
		<%@include file="../fragments/footer.jsp" %>
	</footer>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>