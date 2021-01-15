<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Mes reviews</title>
		<%@ include file="linkStyleSheetCSS.jsp"%>
		<link rel="stylesheet" href="./css/styleMesAmis.css">
	</head>
	
	
	<body class="container">
		<header>
			<%@ include file="header.jsp"%>
		</header>
	
		<main>
			<!-- "Navbar" pour naviguer entre les différentes jsp affichées -->
			<nav class="navbar navbar-expand-lg bg-white mt-5 border border-dark rounded">
  				<div class="collapse navbar-collapse" id="navbarSupportedContent">
    				<ul class="navbar-nav">
      					<li class="nav-item">
        					<a class="btn btn-lg btn-outline-primary" href="Profil">Mon profil</a>
      					</li>
      					<li class="nav-item">
       						<a class="btn btn-lg btn-outline-primary" href="ModifierProfil">Modifier profil</a>
      					</li>
     					<li class="nav-item">
        					<a class="btn btn-lg btn-outline-primary" href="MaListe">Ma liste</a>
      					</li>
      					<li class="nav-item">
        					<a class="btn btn-lg btn-outline-primary" href="historique.jsp">Mon historique</a>
      					</li>
      					<li class="nav-item">
        					<a class="btn btn-lg btn-outline-primary" href="mesReviews.jsp">Mes reviews</a>
      					</li>
      					<li class="nav-item">
        					<a class="btn btn-lg btn-primary" href="mesAmis.jsp">Mes amis</a>
      					</li>
      					<li class="nav-item">
        					<a class="btn btn-lg btn-outline-warning" href="passPremium.jsp">Pass premium</a>
      					</li>
    				</ul>
  				</div>
			</nav>
			
			<!-- Contenu page mes amis -->
			<div class="d-flex flex-column col-11 border border-dark mt-2 mx-auto">
				<!-- Div titres pour pseudo, points contrib, etc... -->
				<div class="d-flex justify-content-between">
					<h3 class="col-1 text-center taille-flex-pseudo">Pseudo</h3>
					<h3 class="col-1 text-center taille-flex-points">Points contrib.</h3>
					<h3 class="col-2 text-center taille-flex-animePrefere">Anime préféré</h3>
					<h3 class="col-2 text-center taille-flex-filmPrefere">Film préféré</h3>
					<h3 class="col-2 text-center taille-flex-seriePrefere">Série préférée</h3>
					<h3 class="col-1 text-center taille-flex-amisDepuis">Amis depuis</h3>
					<h3 class="col-1 text-center taille-flex-derniereCo">Dernière connexion</h3>
					<h3 class="col-1 text-center taille-flex-suppr"></h3>
				</div>
				<!-- Exemple info à afficher -->
				<div class="d-flex justify-content-between">
					<p class="col-1 text-center taille-flex-pseudo">Pseudo</p>
					<p class="col-1 text-center taille-flex-points">50 000</p>
					<p class="col-2 text-center taille-flex-animePrefere">Anime</p>
					<p class="col-2 text-center taille-flex-filmPrefere">Film</p>
					<p class="col-2 text-center taille-flex-seriePrefere">Série</p>
					<p class="col-1 text-center taille-flex-amisDepuis">Hier</p>
					<p class="col-1 text-center taille-flex-derniereCo">Aujourd'hui</p>
					<a href="#" class="col-1 text-center taille-flex-suppr">
						<img src="./img/logoNON.png" alt="Supprimer ami">
					</a>
				</div>
				<!-- Exemple info à afficher -->
				<div class="d-flex justify-content-between">
					<p class="col-1 text-center taille-flex-pseudo">Pseudo</p>
					<p class="col-1 text-center taille-flex-points">50 000</p>
					<p class="col-2 text-center taille-flex-animePrefere">Anime</p>
					<p class="col-2 text-center taille-flex-filmPrefere">Film</p>
					<p class="col-2 text-center taille-flex-seriePrefere">Série</p>
					<p class="col-1 text-center taille-flex-amisDepuis">Hier</p>
					<p class="col-1 text-center taille-flex-derniereCo">Aujourd'hui</p>
					<a href="#" class="col-1 text-center taille-flex-suppr">
						<img src="./img/logoNON.png" alt="Supprimer ami">
					</a>
				</div>
			</div>
		</main>
		
		<footer>
			<%@ include file="footer.jsp"%>
		</footer>	
		
		<%@ include file="script.jsp"%>
	</body>
</html>