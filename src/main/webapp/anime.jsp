<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="fr">
<head>
<meta charset="utf-8">
<title>Anime</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="linkStyleSheetCSS.jsp"%>
<link rel="stylesheet" href="./css/stylesAnime.css">
<link rel="stylesheet" href="./css/stylesAddComment.css">
<link rel="stylesheet" type="text/css" href="./slick/slick.css">
<link rel="stylesheet" type="text/css" href="./slick/slick-theme.css">
<link rel="stylesheet" href="./css/stylePageEpisode.css">
</head>


<body class="container">

	<header>
		<%@ include file="header.jsp"%>
	</header>
	<main class="mainFilm">

		<!-- -------------------------titre-indicateurDeVu------------------------- -->
		<section class="titre-indicateurDeVu">
			<div class="titre">
				<h1> <c:out value="${titre}" /> </h1>
			</div>

			<div class="indicateurDeVu" id="indicateur">	
							<c:choose>
								<c:when test="${booleanAjout == false}">
									<img alt="Non Vu" src="img/logoNonVU.png" class="img-deJaVu">
								</c:when>
								<c:otherwise>
									<img alt="Vu" src="img/logoVU.png"  class="img-deJaVu">
								</c:otherwise>
							</c:choose>
			</div>	
		</section>

		<!-- ---------------------------affiche-evaluation-------------------- -->
		<section class="affiche-evaluation">
			<div class="img-affiche">
				<img alt="Nanatsu no Taizai : Fundo no Shinpan "
					src= "<c:out value="${image}" />" class="img-affiche">
			</div>
			<div class="evaluation my-3">
				<div>
					<h4 id="h4Type"><span id="spanType"><c:out value="${type}"/></span></h4>
					<c:choose>
						<c:when test="${noteBoolean == true}">
							<h5>Note Moyenne : <c:out value="${note}"/> / 10 </h5>
						</c:when>
						<c:otherwise>
							<h5>Note Moyenne : Indisponible </h5>
						</c:otherwise>
					</c:choose>
					<!-- <h5>Classement :</h5>
					<h5>Recommandé à :</h5> -->
				</div>
				<div>
					<p>Tag : <c:out value="${genres}"/></p>
				</div>
				
				<div id="ajoutListe">
					<c:if test="${booleanConnexion == true}">
							<c:if test="${booleanAjout == false}">
								<button class="btn btn-primary btn-lg btn-block my-5" id="ajoutAnimeListe" >Ajouter à ma liste</button>
							</c:if>
							
					</c:if>
				</div>
				<!-- Div pour ajout de la note -->
			<!-- <div class="text-center my-5">
				https://codepen.io/andreacrawford/pen/NvqJXW
    			<div class="rating-group" id="rating-group1">
        			<input class="rating__input rating__input--none" checked name="rating2" id="rating2-0" value="0" type="radio">
        			<label aria-label="0 stars" class="rating__label" for="rating2-0">&nbsp;</label> &nbsp; = espace
        			<label aria-label="0.5 stars" class="rating__label rating__label--half" for="rating2-05"><i class="rating__icon rating__icon--star fa fa-star-half"></i></label>
        			<input class="rating__input" name="rating2" id="rating2-05" value="0.5" type="radio">
       				<label aria-label="1 star" class="rating__label" for="rating2-10"><i class="rating__icon rating__icon--star fa fa-star"></i></label>
        			<input class="rating__input" name="rating2" id="rating2-10" value="1" type="radio">
        			<label aria-label="1.5 stars" class="rating__label rating__label--half" for="rating2-15"><i class="rating__icon rating__icon--star fa fa-star-half"></i></label>
        			<input class="rating__input" name="rating2" id="rating2-15" value="1.5" type="radio">
        			<label aria-label="2 stars" class="rating__label" for="rating2-20"><i class="rating__icon rating__icon--star fa fa-star"></i></label>
        			<input class="rating__input" name="rating2" id="rating2-20" value="2" type="radio">
        			<label aria-label="2.5 stars" class="rating__label rating__label--half" for="rating2-25"><i class="rating__icon rating__icon--star fa fa-star-half"></i></label>
        			<input class="rating__input" name="rating2" id="rating2-25" value="2.5" type="radio">
        			<label aria-label="3 stars" class="rating__label" for="rating2-30"><i class="rating__icon rating__icon--star fa fa-star"></i></label>
        			<input class="rating__input" name="rating2" id="rating2-30" value="3" type="radio">
        			<label aria-label="3.5 stars" class="rating__label rating__label--half" for="rating2-35"><i class="rating__icon rating__icon--star fa fa-star-half"></i></label>
        			<input class="rating__input" name="rating2" id="rating2-35" value="3.5" type="radio">
        			<label aria-label="4 stars" class="rating__label" for="rating2-40"><i class="rating__icon rating__icon--star fa fa-star"></i></label>
        			<input class="rating__input" name="rating2" id="rating2-40" value="4" type="radio">
        			<label aria-label="4.5 stars" class="rating__label rating__label--half" for="rating2-45"><i class="rating__icon rating__icon--star fa fa-star-half"></i></label>
        			<input class="rating__input" name="rating2" id="rating2-45" value="4.5" type="radio">
        			<label aria-label="5 stars" class="rating__label" for="rating2-50"><i class="rating__icon rating__icon--star fa fa-star"></i></label>
        			<input class="rating__input" name="rating2" id="rating2-50" value="5" type="radio">
    			</div>
				</div> -->
			</div>
		</section>

		<!-- ---------------caracteristique-acteurs-video-------------------- -->
		<section class="caracteristique-acteurs-video">
			<div class="caracteristique">
				<h5 align="justify">synopsis : <c:out value="${synopsis}"/></h5>
				<h5>Date de sortie : <c:out value="${jDebut}"/> / <c:out value="${mDebut}"/> / <c:out value="${aDebut}"/></h5>
				<c:choose>
					<c:when test="${airing == true}">
						<h5>Status : En cours</h5>
					</c:when>
				
				<c:otherwise>
					<h5>Status : Terminé</h5>
					 <c:if test = "${jFin != 0}">
						<h5>Date de fin : <c:out value="${jFin}"/> / <c:out value="${mFin}"/> / <c:out value="${aFin}"/> </h5>
					 </c:if>
				</c:otherwise>
				</c:choose>
				<h5>Durée : <c:out value="${duration}"/></h5>
				<c:if test = "${studioPresent == true}">
						<h5>Studio : <c:out value="${studios}"/></h5>
					 </c:if>
				
			</div>
	<!-- PERSONNAGE////////////////	 -->		
			<div class="acteurs">
				<h3>Personnages :</h3>
				<section class="centerActeurs slider">
					<c:forEach items="${personnages}" var="current">
						<div>
						<div class="card text-center cards-personnage">
							  <img src="<c:out value="${current.image}"/>" class="card-img-top" alt="Personnage">
							  <div class="card-footer">
							  <c:out value="${current.name}"/>
							  </div>
						</div>
					
						</div>
					</c:forEach>
				</section>
			</div>
			
		<!-- Trailer////////////////	 -->		
			
			<c:if test = "${trailerPresent ==true}">
				<div class="video">
					<h3>Bandes Annonces :</h3>
						<div class="row d-flex justify-content-center">
	   						<div>
	        					<div embed-responsive embed-responsive-16by9>
	          					<iframe width="560" height="315" src="<c:out value="${trailer}"/>?autoplay=0&rel=0" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
	        					</div>
	      					</div>
	    				</div>
				</div>
			</c:if>
		</section>

	<!-- EPISODES////////////////	 -->		
		<section class="saison">
			<div class="saison1 d-flex justify-content-center">

				<div class="btn-toolbar" role="toolbar"
					aria-label="Toolbar with button groups">

					<div class="btn-group" role="group">
						<button id="btnGroupDrop1" type="button" class="btn btn-secondary boutton-titre" disabled>
							<c:choose>
								<c:when test="${film == true}">Film</c:when>
										
								<c:otherwise>Episodes</c:otherwise>
							</c:choose>
						</button>
			
						<div class= "d-flex flex-wrap ">
							
								<c:forEach var="i" begin="1" end="${episodes}" step="1"> 
									<form action="JsonEpisodeAnimeReader" method="get" target="_blank"> 
										 <input  type="hidden" name="idEpisode"  value="<c:out value="${i}"/>"/>
										 <input  type="hidden" name="idAnime"  value="<c:out value="${idAnime}"/>" id="idAnime"/>
										 <input  type="hidden" name="titreAnime"  value="<c:out value="${titre}"/>" id="titreAnime"/>
										 <button  class="btn btn-secondary boutton-episode" type="submit" ><c:out value="${i}"/></button>
									</form> 
								</c:forEach>
							
						</div>
					</div>

				</div>

			</div>

		</section>


		<!-- ---------------RecommandationFilm-------------------- -->
		<section class="recommandationFilm">
			<div>
				<h3>Vous pourriez aussi aimer :</h3>
			</div>

			<div class="centerReco slider filmPropose">
				<c:forEach items="${recommandation}" var="currentReco">
					<div class="card text-center cards-reco">
						<img src="<c:out value="${currentReco.image}"/>"
							class="card-img-top" alt="Affiche">
						<div class="card-footer">
						<div id="titreReco">
							<c:out value="${currentReco.title}" />
						</div>
							  <a class="btn btn-info btn-sm my-2" href="http://localhost:8080/projet_SAJ/JsonAnimeReader?idAnime=<c:out value="${currentReco.id}"/>">En savoir plus</a>
						</div>
					</div>

				</c:forEach>
			</div>
		</section>

<!-- AFFICHER REVIEW ///-------------------- -->
		<section class="reviews-ajouterReviews">

			<!-- Contenedor Principal -->
			<div class="comments-container">

				<ul id="comments-list" class="comments-list">
					<c:forEach items="${listeReview}" var="currentReview">
						<li>
							<div class="comment-main-level">
								<!-- Avatar -->
								<div class="comment-avatar">
									<img
										src="<c:choose>
												<c:when test="${currentReview.imageBoolean == false}">
												img/avatars/default.jpg
												</c:when>
												<c:otherwise>
												img/avatars/<c:out value="${currentReview.id}"/>.jpg
												</c:otherwise>
											</c:choose>" alt="Avatar Utilisateur">
								</div>
								<!-- Contenue du commentaire -->
								<div class="comment-box">
									<div class="comment-head">
										<h6 class="comment-name comment-utilisateur">
											<!-- <a href="Lien vers l'utilisateur///////"> -->
												<c:out value="${currentReview.pseudonyme}"/>
										    <!-- </a> -->
										</h6>
										<span>Note : <c:out value="${currentReview.note}"/> / 10</span> 
									</div>
									<div class="comment-content"> 
										<c:out value="${currentReview.commentaire}"/>
									</div>
								</div>
							</div> <!-- Respuestas de los comentarios -->
						</li>
					</c:forEach>  
				
				</ul>
			</div>
<!--  AJOUTER REVIEW ////////////////////////////////////// -->
		
		<c:choose>
			<c:when test="${booleanConnexion == true}">
				<div class="AjouterReviews">
					<form action="ReviewAnime" method="get">
						<div class="form-group">
							<h3>
								<label for="comment">Ajouter un commentaire sur l'anime :</label>
							</h3>
							<textarea name="comment" class="form-control" rows="3"></textarea>
							<h3>
								<label for="note">Note :</label>
							</h3>
							<select class="form-control" name ="note" required>
								<option value="1" selected>1</option>
	      						<option value="2">2</option>
      							<option value="3">3</option>
      							<option value="2">4</option>
      							<option value="3">5</option>
      							<option value="2">6</option>
      							<option value="3">7</option>
      							<option value="2">8</option>
      							<option value="3">9</option>
      							<option value="2">10</option>
      						</select>
							<input  type="hidden" name="idAnime"  value="<c:out value="${idAnime}"/>" id="idAnime"/>
						</div>
						<div id="boutonReview">
							<c:choose>
								<c:when test="${booleanAjout == true}">
									<button type="submit" value="ReviewAnime" class="btn btn-primary btn-lg btn-block">Envoyer</button>
								</c:when>
								<c:otherwise>
									<button type="submit" disabled="disabled" value="ReviewAnime" class="btn btn-primary btn-lg btn-block">Veillez ajouter l'anime à votre liste !</button>
								</c:otherwise>
							</c:choose>
						</div>
					</form>
				</div>
			</c:when>
			<c:otherwise>
				<div class="AjouterReviews">
					<h3>Connectez-vous pour donner votre avis sur l'anime</h3>		
				</div>																			
			</c:otherwise>
		</c:choose>			

		</section>

	</main>
	<footer>
		<%@ include file="footer.jsp"%>
	</footer>

	<%@ include file="script.jsp"%>
	<script src="./js/scriptAddComment.js"></script>
	<script src="https://code.jquery.com/jquery-2.2.0.min.js"
		type="text/javascript"></script>
	<script src="./slick/slick.js" type="text/javascript" charset="utf-8"></script>
	<script src="./js/scriptAnime.js"></script>
	<script type="text/javascript">
		$(document).on('ready', function() {
			$(".regular").slick({
				dots : true,
				infinite : true,
				slidesToShow : 3,
				slidesToScroll : 3
			});

			$(".regularAnime").slick({
				dots : true,
				infinite : true,
				slidesToShow : 6,
				slidesToScroll : 1
			});

			$(".centerActeurs").slick({
				dots : true,
				infinite : true,
				centerMode : true,
				slidesToShow : 3,
				slidesToScroll : 1
			});
			$(".centerVideos").slick({
				dots : true,
				infinite : true,
				centerMode : true,
				slidesToShow : 1,
				slidesToScroll : 1
			});
			$(".centerReco").slick({
				dots : true,
				infinite : true,
				centerMode : true,
				slidesToShow : 6,
				slidesToScroll : 1
			});
			$(".variable").slick({
				dots : true,
				infinite : true,
				variableWidth : true
			});
			$(".lazy").slick({
				lazyLoad : 'ondemand', // ondemand progressive anticipated
				infinite : true
			});
		});
	</script>


</body>
</html>
