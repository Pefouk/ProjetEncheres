<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
	<%@include file="../fragments/header.jsp" %>
</header>
<div class="offset-lg-4 offset-md-3 col-xs-12 col-lg-4 col-md-6 inscription">
	<h1>Rentrez votre mot de passe pour confirmer la suppresion de votre compte</h1>
	<form action="${pageContext.request.contextPath}/inscription" method="post">
	<label for="motDePasse">Mot de passe</label>
  		<input type="password" required name="motDePasse" id="motDePasse_id" class="form-control" placeholder="Mot de passe" aria-label="Username" aria-describedby="addon-wrapping">
  	</form>
</div>
<footer>
	<%@include file="../fragments/footer.jsp" %>
</footer>
</body>
</html>