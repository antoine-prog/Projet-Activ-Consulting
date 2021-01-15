<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Ma liste</title>
		<%@ include file="linkStyleSheetCSS.jsp"%>
		<link rel="stylesheet" href="./css/styleMaListe.css">
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
        					<a class="btn btn-lg btn-primary" href="MaListe">Ma liste</a>
      					</li>
      					<li class="nav-item">
        					<a class="btn btn-lg btn-outline-primary" href="historique.jsp">Mon historique</a>
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
			
			<!-- Contenu de la page -->
			<section class="d-flex justify-content-around align-items-center mt-0">
				<div class="row pt-3">
					<span >Filtres :   </span>
					<div class="row mx-0">
						<div class="custom-control custom-radio mx-4 ">
		 					<input type="radio" id="customRadio1" name="customRadio1" class="custom-control-input">
		 					<label class="custom-control-label" for="customRadio1">A à Z</label>
						</div>
						<div class="custom-control custom-radio mx-4">
		  					<input type="radio" id="customRadio2" name="customRadio1" class="custom-control-input">
		  					<label class="custom-control-label" for="customRadio2">Z à A</label>
						</div>
						<div class="custom-control custom-radio mx-4">
		  					<input type="radio" id="customRadio3" name="customRadio1" class="custom-control-input">
		  					<label class="custom-control-label" for="customRadio3">Notes croissantes</label>
						</div>
						<div class="custom-control custom-radio mx-4">
		  					<input type="radio" id="customRadio4" name="customRadio1" class="custom-control-input">
		  					<label class="custom-control-label" for="customRadio4">Notes décroissantes</label>
						</div>
					</div>
				</div>
				<div class="dropdown pt-3">
					<button class="btn" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<img id="boutonPlus" src="./img/logoAjout.png" alt="Logo ajouter">
					</button>
					<!-- Contenu pour ajouter à dérouler -->
					<div class="dropdown-menu" aria-labelledby="dropdownMenuButton" id="contenuADerouler">
					 	<div class="d-flex flex-column">
						<!-- Div recherche -->
							<div class="formNav container mt-0">
								<div class="form-row align-items-center ml-3 no-gutter justify-content-center">
									<div class="col-6">
										<input class="form-control mr-sm-2 px-2" type="search" placeholder="Recherche" aria-label="Search" id="inputRechercheDirecte">
									</div>
									<div>
										<button class="btn btn-secondary ml-2" id="boutonRechercheDirecte">Recherche</button>
									</div>
								</div>
							</div>
							<!-- Div retours de la recherche -->
							<div class="d-flex justify-content-around">
								<!-- Anime -->
								<div id="animeRecherche">
									<div class="d-flex flex-column">
										<h5 class="text-center">Anime</h5>
										<!-- Divs remplies avec jQuery au moment de la recherche -->
										<div class="d-flex align-items-center justify-content-between" id="animeRecherche1">
											<img src="./img/logoLIKE.png" alt="Affiche anime" class="imgResultatRechercheAjout" id="imgResultatRechercheAnimeAjout1">
											<h3 class="text-center" id="titreResultatRechercheAnimeAjout1"></h3>
											<button class="btn" id="boutonAjoutAnime1">
												<img src="./img/logoAjout.png" alt="Ajouter à la liste" class="logoResultatRechercheAjout">
											</button>
											<input type="hidden" value="a" id="inputIDResultatRechercheAnimeAjout1"/>
											<input type="hidden" value="a" id="inputTitreResultatRechercheAnimeAjout1"/>
										</div>
										<div class="d-flex align-items-center justify-content-between" id="animeRecherche2">
											<img src="./img/logoLIKE.png" alt="Affiche anime" class="imgResultatRechercheAjout" id="imgResultatRechercheAnimeAjout2">
											<h3 class="text-center" id="titreResultatRechercheAnimeAjout2"></h3>
											<button class="btn" id="boutonAjoutAnime2">
												<img src="./img/logoAjout.png" alt="Ajouter à la liste" class="logoResultatRechercheAjout">
											</button>
											<input type="hidden" value="a" id="inputIDResultatRechercheAnimeAjout2"/>
											<input type="hidden" value="a" id="inputTitreResultatRechercheAnimeAjout2"/>
										</div>
										<div class="d-flex align-items-center justify-content-between" id="animeRecherche3">
											<img src="./img/logoLIKE.png" alt="Affiche anime" class="imgResultatRechercheAjout" id="imgResultatRechercheAnimeAjout3">
											<h3 class="text-center" id="titreResultatRechercheAnimeAjout3"></h3>
											<button class="btn" id="boutonAjoutAnime3">
												<img src="./img/logoAjout.png" alt="Ajouter à la liste" class="logoResultatRechercheAjout">
											</button>
											<input type="hidden" value="a" id="inputIDResultatRechercheAnimeAjout3"/>
											<input type="hidden" value="a" id="inputTitreResultatRechercheAnimeAjout3"/>
										</div>
										<div class="d-flex align-items-center justify-content-between" id="animeRecherche4">
											<img src="./img/logoLIKE.png" alt="Affiche anime" class="imgResultatRechercheAjout" id="imgResultatRechercheAnimeAjout4">
											<h3 class="text-center" id="titreResultatRechercheAnimeAjout4"></h3>
											<button class="btn" id="boutonAjoutAnime4">
												<img src="./img/logoAjout.png" alt="Ajouter à la liste" class="logoResultatRechercheAjout">
											</button>
											<input type="hidden" value="a" id="inputIDResultatRechercheAnimeAjout4"/>
											<input type="hidden" value="a" id="inputTitreResultatRechercheAnimeAjout4"/>
										</div>
									</div>
								</div>
								<!-- Films -->
								<div id="filmRecherche">
									<div class="d-flex flex-column">
										<h5 class="text-center">Films</h5>
										<!-- Divs remplies avec jQuery au moment de la recherche -->
										<div class="d-flex align-items-center justify-content-between" id="filmRecherche1">
											<img src="./img/logoLIKE.png" alt="Affiche film" class="imgResultatRechercheAjout" id="imgResultatRechercheFilmAjout1">
											<h3 class="text-center" id="titreResultatRechercheFilmAjout1"></h3>
											<button class="btn" id="boutonAjoutFilm1">
												<img src="./img/logoAjout.png" alt="Ajouter à la liste" class="logoResultatRechercheAjout">
											</button>
											<input type="hidden" value="a" id="inputIDResultatRechercheFilmAjout1"/>
											<input type="hidden" value="a" id="inputTitreResultatRechercheFilmAjout1"/>
										</div>
										<div class="d-flex align-items-center justify-content-between" id="filmRecherche2">
											<img src="./img/logoLIKE.png" alt="Affiche film" class="imgResultatRechercheAjout" id="imgResultatRechercheFilmAjout2">
											<h3 class="text-center" id="titreResultatRechercheFilmAjout2"></h3>
											<button class="btn" id="boutonAjoutFilm2">	
												<img src="./img/logoAjout.png" alt="Ajouter à la liste" class="logoResultatRechercheAjout">
											</button>
											<input type="hidden" value="a" id="inputIDResultatRechercheFilmAjout2"/>
											<input type="hidden" value="a" id="inputTitreResultatRechercheFilmAjout2"/>
										</div>
										<div class="d-flex align-items-center justify-content-between" id="filmRecherche3">
											<img src="./img/logoLIKE.png" alt="Affiche film" class="imgResultatRechercheAjout" id="imgResultatRechercheFilmAjout3">
											<h3 class="text-center" id="titreResultatRechercheFilmAjout3"></h3>
											<button class="btn" id="boutonAjoutFilm3">
												<img src="./img/logoAjout.png" alt="Ajouter à la liste" class="logoResultatRechercheAjout">
											</button>
											<input type="hidden" value="a" id="inputIDResultatRechercheFilmAjout3"/>
											<input type="hidden" value="a" id="inputTitreResultatRechercheFilmAjout3"/>
										</div>
										<div class="d-flex align-items-center justify-content-between" id="filmRecherche4">
											<img src="./img/logoLIKE.png" alt="Affiche film" class="imgResultatRechercheAjout" id="imgResultatRechercheFilmAjout4">
											<h3 class="text-center" id="titreResultatRechercheFilmAjout4"></h3>
											<button class="btn" id="boutonAjoutFilm4">
												<img src="./img/logoAjout.png" alt="Ajouter à la liste" class="logoResultatRechercheAjout">
											</button>
											<input type="hidden" value="a" id="inputIDResultatRechercheFilmAjout4"/>
											<input type="hidden" value="a" id="inputTitreResultatRechercheFilmAjout4"/>
										</div>
									</div>
								</div>
								<!-- Séries -->
								<div id="serieRecherche">
									<div class="d-flex flex-column">
										<h5 class="text-center">Séries</h5>
										<!-- Divs remplies avec jQuery au moment de la recherche -->
										<div class="d-flex align-items-center justify-content-between" id="serieRecherche1">
											<img src="./img/logoLIKE.png" alt="Affiche série" class="imgResultatRechercheAjout" id="imgResultatRechercheSerieAjout1">
											<h3 class="text-center" id="titreResultatRechercheSerieAjout1"></h3>
											<button class="btn" id="boutonAjoutSerie1">
												<img src="./img/logoAjout.png" alt="Ajouter à la liste" class="logoResultatRechercheAjout">
											</button>
											<input type="hidden" value="a" id="inputIDResultatRechercheSerieAjout1"/>
											<input type="hidden" value="a" id="inputTitreResultatRechercheSerieAjout1"/>
										</div>
										<div class="d-flex align-items-center justify-content-between" id="serieRecherche2">
											<img src="./img/logoLIKE.png" alt="Affiche série" class="imgResultatRechercheAjout" id="imgResultatRechercheSerieAjout2">
											<h3 class="text-center" id="titreResultatRechercheSerieAjout2"></h3>
											<button class="btn" id="boutonAjoutSerie2">
												<img src="./img/logoAjout.png" alt="Ajouter à la liste" class="logoResultatRechercheAjout">
											</button>
											<input type="hidden" value="a" id="inputIDResultatRechercheSerieAjout2"/>
											<input type="hidden" value="a" id="inputTitreResultatRechercheSerieAjout2"/>
										</div>
										<div class="d-flex align-items-center justify-content-between" id="serieRecherche3">
											<img src="./img/logoLIKE.png" alt="Affiche série" class="imgResultatRechercheAjout" id="imgResultatRechercheSerieAjout3">
											<h3 class="text-center" id="titreResultatRechercheSerieAjout3"></h3>
											<button class="btn" id="boutonAjoutSerie3">
												<img src="./img/logoAjout.png" alt="Ajouter à la liste" class="logoResultatRechercheAjout">
											</button>
											<input type="hidden" value="a" id="inputIDResultatRechercheSerieAjout3"/>
											<input type="hidden" value="a" id="inputTitreResultatRechercheSerieAjout3"/>
										</div>
										<div class="d-flex align-items-center justify-content-between" id="serieRecherche4">
											<img src="./img/logoLIKE.png" alt="Affiche série" class="imgResultatRechercheAjout" id="imgResultatRechercheSerieAjout4">
											<h3 class="text-center" id="titreResultatRechercheSerieAjout4"></h3>
											<button class="btn" id="boutonAjoutSerie4">
												<img src="./img/logoAjout.png" alt="Ajouter à la liste" class="logoResultatRechercheAjout">
											</button>
											<input type="hidden" value="a" id="inputIDResultatRechercheSerieAjout4"/>
											<input type="hidden" value="a" id="inputTitreResultatRechercheSerieAjout4"/>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			
			<section>
				<!-- Div titres -->
				<div class="d-flex justify-content-around mt-4">
					<h5 class="text-center border py-2 titreNom">NOM</h5>
					<h5 class="text-center border py-2 titreNote">NOTE</h5>
					<h5 class="text-center border py-2 titreVisibilite">REVIEW</h5>
					<h5 class="text-center titreSuppr"></h5>
				</div>
				<!-- Article pour tous les anime -->
				<article class="d-flex flex-column" id="articleAnime">
					<!-- Div pour 1 anime -->
					<c:forEach items="${listeAnimeReview}" var="currentAnimeReview">
						<div class="d-flex justify-content-around">
							<a class="text-center animeNom" href="http://localhost:8080/projet_SAJ/JsonAnimeReader?idAnime=<c:out value="${currentAnimeReview.idAnime}"/>"><c:out value="${currentAnimeReview.titre}"/></a>
							<p class="text-center animeNote"><c:out value="${currentAnimeReview.note}"/></p>
							<p class="text-center animeVisibilite"><c:out value="${currentAnimeReview.commentaire}"/></p>
							<input type="hidden" name="idEpisode" value="<c:out value="${currentAnimeReview.idAnime}"/>"/>
							<button class="btn text-center animeSuppr">
								<img src="./img/logoNoOoN.png" alt="Supprimer de la liste" id="logoSuppr">
							</button>
						</div>	
					</c:forEach>
				</article>
				<!-- Article pour tous les films -->
				<article class="d-flex flex-column" id="articleFilm">
					<!-- Div pour 1 film -->
					<c:forEach items="${listeFilmReview}" var="currentFilmReview">
						<div class="d-flex justify-content-around">
							<a class="text-center filmNom" href="http://localhost:8080/projet_SAJ/JsonFilmReader?idFilm=<c:out value="${currentFilmReview.idAnime}"/>"><c:out value="${currentFilmReview.titre}"/></a>
							<p class="text-center filmNote"><c:out value="${currentFilmReview.note}"/></p>
							<p class="text-center filmVisibilite"><c:out value="${currentFilmReview.commentaire}"/></p>
							<input type="hidden" name="idEpisode" value="<c:out value="${currentFilmReview.idAnime}"/>"/>
							<button class="btn text-center animeSuppr">
								<img src="./img/logoNoOoN.png" alt="Supprimer de la liste" id="logoSuppr">
							</button>
						</div>	
					</c:forEach>
				</article>
				<!-- Article pour toutes les séries -->
				<article class="d-flex flex-column" id="articleSerie">
					<!-- Div pour 1 série -->
					<c:forEach items="${listeSerieReview}" var="currentSerieReview">
						<div class="d-flex justify-content-around">
							<a class="text-center filmNom" href="http://localhost:8080/projet_SAJ/JsonSerieReader?idSerie=<c:out value="${currentSerieReview.idAnime}"/>"><c:out value="${currentSerieReview.titre}"/></a>
							<p class="text-center filmNote"><c:out value="${currentSerieReview.note}"/></p>
							<p class="text-center filmVisibilite"><c:out value="${currentSerieReview.commentaire}"/></p>
							<input type="hidden" name="idEpisode" value="<c:out value="${currentSerieReview.idAnime}"/>"/>
							<button class="btn text-center animeSuppr">
								<img src="./img/logoNoOoN.png" alt="Supprimer de la liste" id="logoSuppr">
							</button>
						</div>	
					</c:forEach>	
				</article>
			</section>
		</main>
		
		
		<footer>
			<%@ include file="footer.jsp"%>
		</footer>	
		
		<%@ include file="script.jsp"%>
		<script src="./js/scriptMaListe.js"></script>
	</body>
</html>