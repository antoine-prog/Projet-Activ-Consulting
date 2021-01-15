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
		<link rel="stylesheet" href="./css/styleMesReviews.css">
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
        					<a class="btn btn-lg btn-primary" href="mesReviews.jsp">Mes reviews</a>
      					</li>
      					<li class="nav-item">
        					<a class="btn btn-lg btn-outline-primary" href="mesAmis.jsp">Mes amis</a>
      					</li>
      					<li class="nav-item">
        					<a class="btn btn-lg btn-outline-warning" href="passPremium.jsp">Pass premium</a>
      					</li>
    				</ul>
  				</div>
			</nav>
			
			
			<!-- Navbar pour les différents onglets des reviews -->
			<nav class="navbar navbar-expand-lg navbar-light bg-light border border-dark rounded col-11 mx-auto mt-5">
  				<div class="collapse navbar-collapse" id="navbarNav">
    				<ul class="navbar-nav">
      					<li class="nav-item active">
        					<a class="nav-link" id="reviewsTout" href="#">Tout</a>
      					</li>
      					<li class="nav-item active">
        					<a class="nav-link" id="reviewsAnime" href="#">Anime</a>
      					</li>
      					<li class="nav-item active">
        					<a class="nav-link" id="reviewsFilm" href="#">Film</a>
      					</li>
      					<li class="nav-item active">
        					<a class="nav-link" id="reviewsSerie" href="#">Séries</a>
      					</li>
    				</ul>
  				</div>
			</nav>
			
			<!-- Affichage contenu reviews -->
			<div class="d-flex flex-column col-10 offset-1 border border-dark mt-2">
				<!-- Div titres pour date, affichage, etc... -->
				<div class="d-flex justify-content-between">
					<h3 class="text-center taille-flex-date">Date</h3>
					<h3 class="text-center taille-flex-affiche">Affiche</h3>
					<h3 class="text-center taille-flex-nom">Nom</h3>
					<h3 class="text-center taille-flex-review">Review</h3>
					<h3 class="text-center taille-flex-note">Note review</h3>
				</div>
				<!-- Exemple info à afficher -->
				<div class="d-flex justify-content-between">
					<p class="text-center taille-flex-date">Date random</p>
					<p class="text-center taille-flex-affiche">Affiche</p>
					<p class="text-center taille-flex-nom">Nom</p>
					<p class="text-justify taille-flex-review">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Amet culpa eum, facere numquam asperiores aliquam odio expedita dolor aut similique quas quasi maxime nemo molestiae sit neque quaerat libero deleniti!</p>
					<p class="text-center taille-flex-note">Note</p>
				</div>
				<!-- Exemple info à afficher -->
				<div class="d-flex justify-content-between">
					<p class="text-center taille-flex-date">Date random</p>
					<p class="text-center taille-flex-affiche">Affiche</p>
					<p class="text-center taille-flex-nom">Nom</p>
					<p class="text-justify taille-flex-review">Lorem ipsum dolor sit, amet consectetur adipisicing elit. Amet culpa eum, facere numquam asperiores aliquam odio expedita dolor aut similique quas quasi maxime nemo molestiae sit neque quaerat libero deleniti!</p>
					<p class="text-center taille-flex-note">Note</p>
				</div>
			</div>
		</main>
		
		<footer>
			<%@ include file="footer.jsp"%>
		</footer>	
		
		<%@ include file="script.jsp"%>
		<script src="./js/scriptMesReviews.js"></script>
	</body>
</html>