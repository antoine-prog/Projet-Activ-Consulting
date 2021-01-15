<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!doctype html>
<html lang="fr">
<head>
<meta charset="utf-8">
<title>Recherche</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="linkStyleSheetCSS.jsp"%>
<link rel="stylesheet" href="./css/styleRecherche.css">
</head>


<body class="container">

	<header>
		<%@ include file="header.jsp"%>
	</header>
	<main> 
	
<!-- DEBUT FILTRE EN HAUT A CHOISIR !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
		<section class="filtre-recherche">
			<div class="filtre text-left">
				<div class="container-fluid row pt-3">
					<span >Liste de choix uniques :   </span>
					<div class="row mx-0">
						<div class="custom-control custom-radio mx-4 ">
		 					<input type="radio" id="customRadio1" name="customRadio1" class="custom-control-input">
		 					<label class="custom-control-label" for="customRadio1">Ordre alphabétique</label>
						</div>
						<div class="custom-control custom-radio mx-4">
		  					<input type="radio" id="customRadio2" name="customRadio1" class="custom-control-input">
		  					<label class="custom-control-label" for="customRadio2">Ordre inverse alphabétique</label>
						</div>
						<div class="custom-control custom-radio mx-4">
		  					<input type="radio" id="customRadio3" name="customRadio1" class="custom-control-input">
		  					<label class="custom-control-label" for="customRadio3">Par top</label>
						</div>
						<div class="custom-control custom-radio mx-4">
		  					<input type="radio" id="customRadio4" name="customRadio1" class="custom-control-input">
		  					<label class="custom-control-label" for="customRadio4">Par flop</label>
						</div>
					</div>
				</div>
				<div class="container-fluid row">
					<span> Liste de choix pas unique :   </span>
					<div class="row mx-0">
						<div class="custom-control custom-checkbox mx-4">
		 					<input type="checkbox" class="custom-control-input" id="customCheck1">
		 					<label class="custom-control-label" for="customCheck1">Anime</label>
						</div>
						<div class="custom-control custom-checkbox mx-4">
		 					<input type="checkbox" class="custom-control-input" id="customCheck2">
		 					<label class="custom-control-label" for="customCheck2">Film</label>
						</div>
						<div class="custom-control custom-checkbox mx-4">
		 					<input type="checkbox" class="custom-control-input" id="customCheck3">
		 					<label class="custom-control-label" for="customCheck3">Manga</label>
						</div>
						<div class="custom-control custom-checkbox mx-4">
		 					<input type="checkbox" class="custom-control-input" id="customCheck4">
		 					<label class="custom-control-label" for="customCheck4">Série</label>
						</div>
					</div>
				</div>
				
<!-- ECHELLE FAITE MAIN POUR LE CHOIX DE LA NOTE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
				<div class="legendes-range-globale align-items-center justify-content-center">
					<div class="legendes-range legendes-range1 pl-3 pr-2">
						<span class="legende-range">0</span>
						<span class="legende-range">1</span>
						<span class="legende-range">2</span>
						<span class="legende-range">3</span>
						<span class="legende-range">4</span>
						<span class="legende-range">5</span>
						<span class="legende-range">6</span>
						<span class="legende-range">7</span>
						<span class="legende-range">8</span>
						<span class="legende-range">9</span>
						<span class="legende-range">10</span>
					</div>
					<div class="legendes-range legendes-range2 px-3 ">
						<span class="legende-range">|</span>
						<span class="legende-range">|</span>
						<span class="legende-range">|</span>
						<span class="legende-range">|</span>
						<span class="legende-range">|</span>
						<span class="legende-range">|</span>
						<span class="legende-range">|</span>
						<span class="legende-range">|</span>
						<span class="legende-range">|</span>
						<span class="legende-range">|</span>
						<span class="legende-range">|</span>
					</div>
				</div>
				<div id="range-line">
					<label for="customRange3">
						<select class="select-range">
	 						<option>Note minimale</option>
	 						<option>Note maximale</option>
						</select>
					</label>
					<div class="slidecontainer mx-2">
						<input type="range" class="slider" min="0" max="10" step="0.5" value="0" id="customRange">
					</div>
					<span id="rangeValue" class="mx-4">0</span>
				</div>
			</div>

<!-- BARRE DE RECHERCHE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
			<form action="Recherche" method="get" id="formRecherche2" class="my-3">
				<div
					class="form-row align-items-center ml-3 no-gutter justify-content-center">
					<div>
						<select class="btn btn-secondary dropdown-toggle mr-sm-2 px-2"
							role="button" id="selectRecherche" name="categorie">
							<option class="dropdown-item bg-dark text-light" value="0">Catégorie</option>
							<option class="dropdown-item bg-dark text-light" value="1">Anime</option>
							<option class="dropdown-item bg-dark text-light" value="2">Film</option>
							<option class="dropdown-item bg-dark text-light" value="3">Série</option>
						</select>
					</div>
					<div class="col-sm-4 col-md-6 col-lg-8">
						<input class="form-control mr-sm-2 px-2" type="search"
							placeholder="Recherche" aria-label="Search" name="search">
					</div>
					<div>
						<button class="btn btn-secondary ml-2" type="submit">Recherche</button>
					</div>
				</div>
			</form>
		</section>
<!-- FIN FILTRE EN HAUT A CHOISIR !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
 
<!-- DEBUT AFFICHAGE EN BAS RESULTANT DU FILTRE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
		<section class="resultat-recherche border border-dark ">

<!--DEBUT CATEGORIES !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! --> 	
<!--PARTIE ANIME !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
		<c:if test="${categorie == 1}">
			<h2 class="text-center bg-secondary m-0"> ANIMES</h2>

				<div class="container rech-anime ">
				<div class="row row-cols-sm-2 row-cols-md-3 row-cols-lg-4">
					<c:forEach items="${rechercheAnime}" var="currentAnime">
						<div class="col mb-4 ">
		 					<div class="card ">
		 						<div class="card-header"><c:out value="${currentAnime.titre}"/></div>
		 						<div class="img-conteneur">
		    						<img src="<c:out value="${currentAnime.image}"/>" class="card-img-top" alt="Logo Anime">
		    					</div>
		    					<div class="card-body p-0 pt-3">
		    						<div class="card-synopsis">
		      							<p class="card-text p-2" align="justify"><c:out value="${currentAnime.synopsis}"/></p>
		      						</div>
		      						<a class="btn bouton-info btn-info btn-sm my-2" href="http://localhost:8080/projet_SAJ/JsonAnimeReader?idAnime=<c:out value="${currentAnime.idAnime}"/>">En savoir plus</a>
		      					</div>
		      					<div class="card-footer card-info row p-0 mx-0 mt-2">
			      					<div>Note Moyenne :<span class="info">
													<c:choose>
														<c:when test="${noteBoolean == true}">
															<h5><c:out value="${note}"/> / 10 </h5>
														</c:when>
														<c:otherwise>
															<h5>Indisponible </h5>
														</c:otherwise>
													</c:choose>
												</span>
									</div>
		    					</div>
		    				</div>
		  				</div>
		  			</c:forEach>
		  		</div>
		  	</div>

		</c:if>
		 
<!--PARTIE FILM !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! --> 	
		<c:if test="${categorie == 2}">
		  	<h2 class="text-center  bg-secondary m-0"> FILM</h2>
			<div class="container rech-film ">
				<div class="row row-cols-sm-2 row-cols-md-3 row-cols-lg-4">
					<c:forEach items="${rechercheFilm}" var="currentFilm">
						<div class="col mb-4">
		 					<div class="card">
		 						<div class="card-header"><c:out value="${currentFilm.titre}"/></div>
		 						<div class="img-conteneur">
		    						<img src="https://image.tmdb.org/t/p/w500<c:out value="${currentFilm.image}"/>" class="card-img-top" alt="Affiche film">
		    					</div>
		    					<div class="card-body p-0 pt-3">

			    					<div class="card-synopsis">
			      						<p class="card-text p-2" align="justify"><c:out value="${currentFilm.synopsis}"/></p>
			      					</div>
			      					<a class="btn bouton-info btn-info btn-sm my-2" href="http://localhost:8080/projet_SAJ/JsonFilmReader?idFilm=<c:out value="${currentFilm.idFilm}"/>">En savoir plus</a>
		      					</div>
		      					<div class="card-footer card-info row p-0 mx-0 mt-2">
			      					<div>Note :<span class="info">A RAJOUTER</span></div>
		    					</div>
		    				</div>
		  				</div>
		  			</c:forEach>
		  		</div>
		  	</div>	
		</c:if>
		  	
<!-- Partie manga commentée et déplacée en dehors de la balise html (à la fin de la jsp) -->

<!--PARTIE SERIE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! --> 			
		<c:if test="${categorie == 3}">
		  	<h2 class="text-center bg-secondary m-0">SERIE</h2>
			<div class="container rech-serie ">
				<div class="row row-cols-sm-2 row-cols-md-3 row-cols-lg-4">
					<c:forEach items="${rechercheSerie}" var="currentSerie">
						<div class="col mb-4">
		 					<div class="card ">
		 						<div class="card-header"><c:out value="${currentSerie.titre}"/></div>
		 						<div class="img-conteneur">
		    						<img src="https://image.tmdb.org/t/p/w500<c:out value="${currentSerie.image}"/>" class="card-img-top" alt="Affiche série">
		    					</div>
			    					<div class="card-body p-0 pt-3">
				    					<div class="card-synopsis">
				      						<p class="card-text p-2" align="justify"><c:out value="${currentSerie.synopsis}"/></p>
				      					</div>
				      					<a class="btn bouton-info btn-info btn-sm my-2" href="http://localhost:8080/projet_SAJ/JsonSerieReader?idSerie=<c:out value="${currentSerie.idSerie}"/>">En savoir plus</a>
		      					</div>
		      					<div class="card-footer card-info row p-0 mx-0 mt-2">
			      					<div>Note :<span class="info">A RAJOUTER</span></div>
		    					</div>
		    				</div>
		  				</div>
		  			</c:forEach>
		  		</div>	
		  	</div>
		</c:if>
<!--FIN CATEGORIES !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! --> 				  		
		  		  	
		</section>
	 <!-- FIN AFFICHAGE EN BAS RESULTANT DU FILTRE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->	
		
		
		
	</main>	
	<footer>
		<%@ include file="footer.jsp"%>
	</footer>
		<%@ include file="script.jsp"%>
		 <script src=".\js\scriptRecherche.js"></script>
</body>
</html>


<!--PARTI MANGA !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! --> 		
  	
		  	<!-- <h2 class="text-center border border-dark bg-secondary m-0"> MANGA</h2>
			<div class="container rech-manga border border-dark bg-success">
				<div class="row row-cols-sm-2 row-cols-md-3 row-cols-lg-4">
					<div class="col mb-4">
		 				<div class="card border border-dark">
		 					<div class="card-header">Titre</div>
		 					<div class="img-conteneur">
		    					<img src="..." class="card-img-top" alt="...">
		    				</div>
		    				<div class="card-body p-0 pt-3">
		    					<div class="tags">
		      						<span class="tag">Tag 1</span>
		      						<span class="tag">Tag 2</span>
		      					</div>
		      					<p class="card-text p-2">Synopsis de la carte</p>
		      				</div>
		      				<div class="card-footer card-info row p-0 mx-0 mt-2">
			      					<div>Classement :<span class="info">1</span></div>
			      					<div>Note :<span class="info">8,25</span></div>
		    				</div>
		    			</div>
		  			</div>
		  			<div class="col mb-4">
		 				<div class="card border border-dark">
		 					<div class="card-header">Titre</div>
		 					<div class="img-conteneur">
		    					<img src="..." class="card-img-top" alt="...">
		    				</div>
		    				<div class="card-body p-0 pt-3">
		    					<div class="tags">
		      						<span class="tag">Tag 1</span>
		      						<span class="tag">Tag 2</span>
		      					</div>
		      					<p class="card-text p-2">Synopsis de la carte</p>
		      				</div>
		      				<div class="card-footer card-info row p-0 mx-0 mt-2">
			      					<div>Classement :<span class="info">1</span></div>
			      					<div>Note :<span class="info">8,25</span></div>
		    				</div>
		    			</div>
		  			</div><div class="col mb-4">
		 				<div class="card border border-dark">
		 					<div class="card-header">Titre</div>
		 					<div class="img-conteneur">
		    					<img src="..." class="card-img-top" alt="...">
		    				</div>
		    				<div class="card-body p-0 pt-3">
		    					<div class="tags">
		      						<span class="tag">Tag 1</span>
		      						<span class="tag">Tag 2</span>
		      					</div>
		      					<p class="card-text p-2">Synopsis de la carte</p>
		      				</div>
		      				<div class="card-footer card-info row p-0 mx-0 mt-2">
			      					<div>Classement :<span class="info">1</span></div>
			      					<div>Note :<span class="info">8,25</span></div>
		    				</div>
		    			</div>
		  			</div><div class="col mb-4">
		 				<div class="card border border-dark">
		 					<div class="card-header">Titre</div>
		 					<div class="img-conteneur">
		    					<img src="..." class="card-img-top" alt="...">
		    				</div>
		    				<div class="card-body p-0 pt-3">
		    					<div class="tags">
		      						<span class="tag">Tag 1</span>
		      						<span class="tag">Tag 2</span>
		      					</div>
		      					<p class="card-text p-2">Synopsis de la carte</p>
		      				</div>
		      				<div class="card-footer card-info row p-0 mx-0 mt-2">
			      					<div>Classement :<span class="info">1</span></div>
			      					<div>Note :<span class="info">8,25</span></div>
		    				</div>
		    			</div>
		  			</div><div class="col mb-4">
		 				<div class="card border border-dark">
		 					<div class="card-header">Titre</div>
		 					<div class="img-conteneur">
		    					<img src="..." class="card-img-top" alt="...">
		    				</div>
		    				<div class="card-body p-0 pt-3">
		    					<div class="tags">
		      						<span class="tag">Tag 1</span>
		      						<span class="tag">Tag 2</span>
		      					</div>
		      					<p class="card-text p-2">Synopsis de la carte</p>
		      				</div>
		      				<div class="card-footer card-info row p-0 mx-0 mt-2">
			      					<div>Classement :<span class="info">1</span></div>
			      					<div>Note :<span class="info">8,25</span></div>
		    				</div>
		    			</div>
		  			</div>
		  		</div>
		  	</div> -->
