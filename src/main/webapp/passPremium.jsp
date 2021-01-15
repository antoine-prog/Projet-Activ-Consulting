<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!doctype html>
<html lang="fr">
<head>
<meta charset="utf-8">
<title>SAJ</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="linkStyleSheetCSS.jsp"%>
<link rel="stylesheet" href="./css/stylesPassPremium.css">
</head>


<body class="container">

	<header>
		<%@ include file="header.jsp"%>
	</header>
	<main>

		<section>

			<!-- "Navbar" pour naviguer entre les différentes jsp affichées -->
			<nav
				class="navbar navbar-expand-lg bg-white mt-5 border border-dark rounded">
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="btn btn-lg btn-outline-primary"
							href="Profil">Mon profil</a></li>
						<li class="nav-item"><a
							class="btn btn-lg btn-outline-primary" href="ModifierProfil">Modifier
								profil</a></li>
						<li class="nav-item"><a
							class="btn btn-lg btn-outline-primary" href="MaListe">Ma liste</a></li>
						<li class="nav-item"><a
							class="btn btn-lg btn-outline-primary" href="historique.jsp">Mon
								historique</a></li>
						<li class="nav-item"><a
							class="btn btn-lg btn-outline-primary" href="mesReviews.jsp">Mes reviews</a></li>
						<li class="nav-item"><a
							class="btn btn-lg btn-outline-primary" href="mesAmis.jsp">Mes amis</a></li>
						<li class="nav-item"><a
							class="btn btn-lg btn-warning" href="passPremium.jsp">Pass premium</a>
						</li>
					</ul>
				</div>
			</nav>

		</section>

		<section class="teasers">
			<div class="wrapper">
				<ul>
					<li>
						<div class="callout">
							<h3>OFFRE GRATUITE</h3>
							<h5>0€ par mois</h5>

							<a>Fonctionnalité : note, review</a> <a>Accès à la liste</a> <a>Accès
								aux amis</a> <a>Accès aux cadres des contributeurs</a>

						</div>
					</li>
					<li>
						<div class="callout">
							<h3>OFFRE PREMIUM</h3>
							<h5>12€ par mois</h5>

							<a>Fonctionnalités de l’offre gratuite</a> <a>Accès lien
								partenaire streaming</a> <a>Option : cacher des item de la liste</a>
							<a>Cadre et badge : Contributeur premium</a> <a>accès aux
								animes ADN</a>
						</div>
					</li>
					<li>
						<div class="callout">
							<h3>OFFRE PREMIUM +</h3>
							<h5>50€ par mois</h5>
							<a>Fonctionnalités de l’offre payante</a> <a>Soutien à notre
								site internet</a> <a>Cadre et badge : Contributeur premium +</a> <a>possibilité
								de mettre un avatar animé</a> <a>accès aux anime ADN,
								crunchyroll, Wakanim, Netflix</a> <a>Offre promotionnelles aux
								évènements partenaires (SERIES MANIA, JAPAN EXPO...)</a>
						</div>
					</li>

				</ul>
			</div>
			
			<h3 align="center" class="mt-3">Découvrez les avantages des pass premium !!! </h3>
			
		</section>


	</main>
	<footer>
		<%@ include file="footer.jsp"%>
	</footer>

	<%@ include file="script.jsp"%>

</body>
</html>
