<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Historique</title>
		<%@ include file="linkStyleSheetCSS.jsp"%>
		<link rel="stylesheet" href="./css/styleHistorique.css">
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
        					<a class="btn btn-lg btn-primary" href="historique.jsp">Mon historique</a>
      					</li>
      					<li class="nav-item">
        					<a class="btn btn-lg btn-outline-primary" href="mesReviews.jsp">Mes reviews</a>
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
			
			<!-- Navbar pour les différents onglets de l'historique -->
			<nav class="navbar navbar-expand-lg navbar-light bg-light border border-dark rounded col-11 mx-auto mt-5">
  				<div class="collapse navbar-collapse" id="navbarNav">
    				<ul class="navbar-nav">
      					<li class="nav-item active">
        					<a class="nav-link" id="historiqueTout" href="#">Tout</a>
      					</li>
      					<li class="nav-item active">
        					<a class="nav-link" id="historiqueAnime" href="#">Anime</a>
      					</li>
      					<li class="nav-item active">
        					<a class="nav-link" id="historiqueFilm" href="#">Film</a>
      					</li>
      					<li class="nav-item active">
        					<a class="nav-link" id="historiqueSerie" href="#">Séries</a>
      					</li>
      					<li class="nav-item active">
        					<a class="nav-link" id="historiqueAutres" href="#">Autres</a>
      					</li>
    				</ul>
  				</div>
			</nav>
			
			
			
			<!-- Div contenu historique pour films, séries, etc... (pas de classe pour le flex car conflit avec .hide() de jQuery -->
			<div id="contenuHistorique">
				<div class="d-flex justify-content-between col-12">
					<h3 class="col-2 text-center historiqueDate">Date</h3>
					<h3 class="col-1 text-center historiqueNom">Nom</h3>
					<h3 class="col-2 text-center historiqueCategorie">Catégorie</h3>
					<h3 class="col-1 text-center historiqueSaison">Saison</h3>
					<h3 class="col-1 text-center historiqueEpisode">Episode</h3>
					<h3 class="col-2 text-center historiqueNote">Note</h3>
					<h3 class="col-2 text-center historiqueLien">Lien film ou épisode</h3>
					<h3 class="col-1 text-center historiqueSupprimer"></h3>
				</div>
				<!-- Exemple div historique 1 -->
				<div class="d-flex justify-content-between col-12">
					<p class="col-2 text-center historiqueDate">Contenu</p>
					<p class="col-1 text-center historiqueNom">A</p>
					<p class="col-2 text-center historiqueCategorie">Afficher</p>
					<p class="col-1 text-center historiqueSaison">Ici</p>
					<p class="col-1 text-center historiqueEpisode">Historique</p>
					<p class="col-2 text-center historiqueNote">Exemple</p>
					<a href="#" target="_blank" class="col-2 text-center historiqueLien">Blablabla</a>
					<a href="#" class="col-1 text-center">
						<img src="./img/logoNON.png" alt="Supprimer élément historique">
					</a>
				</div>
				<!-- Exemple div historique 2 -->
				<div class="d-flex justify-content-between col-12">
					<p class="col-2 text-center historiqueDate">Contenu</p>
					<p class="col-1 text-center historiqueNom">A</p>
					<p class="col-2 text-center historiqueCategorie">Afficher</p>
					<p class="col-1 text-center historiqueSaison">Ici</p>
					<p class="col-1 text-center historiqueEpisode">Historique</p>
					<p class="col-2 text-center historiqueNote">Exemple</p>
					<a href="#" target="_blank" class="col-2 text-center historiqueLien">Blablabla</a>
					<a href="#" class="col-1 text-center">
						<img src="./img/logoNON.png" alt="Supprimer élément historique">
					</a>
				</div>
			</div>
			
			<div id="contenuHistoriqueAutres" class="mt-3">
				<!-- Affichage obtention badge -->
				<div class="border border-dark col-11">
					<p>Passage cap badge BRONZE</p>
					<p>Passage cap badge ARGENT</p>
					<p>...</p>
					<br>
					<p>Passage cap badge BRONZE</p>
					<p>Passage cap badge ARGENT</p>
					<p>...</p>
				</div>
				<!-- Affichage info autre -->
				<div class="d-flex flex-column col-11 border border-dark mt-2">
					<!-- Div titres pour infos ajout ami etc... -->
					<div class="d-flex justify-content-between">
						<h3 class="text-center">Date</h3>
						<h3 class="text-center">Info</h3>
						<h3></h3>
					</div>
					<!-- Exemple info à afficher -->
					<div class="d-flex justify-content-between">
						<p class="text-center">Date random</p>
						<p class="text-center">Ajout ami 1</p>
						<a href="#" class="col-1 text-center">
							<img src="./img/logoNON.png" alt="Supprimer élément historique">
						</a>
					</div>
					<!-- Exemple info à afficher -->
					<div class="d-flex justify-content-between">
						<p class="text-center">Date random</p>
						<p class="text-center">Ajout ami 2</p>
						<a href="#" class="col-1 text-center">
							<img src="./img/logoNON.png" alt="Supprimer élément historique">
						</a>
					</div>
					<!-- Exemple info à afficher -->
					<div class="d-flex justify-content-between">
						<p class="text-center">Date random</p>
						<p class="text-center">Ajout ami 3</p>
						<a href="#" class="col-1 text-center">
							<img src="./img/logoNON.png" alt="Supprimer élément historique">
						</a>
					</div>
				</div>
			</div>
		</main>
		
		<footer>
			<%@ include file="footer.jsp"%>
		</footer>
		
		<%@ include file="script.jsp"%>
		<script src="./js/scriptHistorique.js"></script>
	</body>
</html>