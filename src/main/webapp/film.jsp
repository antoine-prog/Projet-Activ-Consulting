<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="fr">
<head>
<meta charset="utf-8">
<title>Film</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="linkStyleSheetCSS.jsp"%>
<link rel="stylesheet" href="./css/stylesFilm.css">
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
				<h1><c:out value="${titre}"/></h1>
			</div>

			<!-- Nom de l'épisode + logo VU ou NonVU -->
			<div class="d-flex justify-content-center">
				<a class="img-deJaVu" href="#">
					<img src="./img/logoNonVU.png" width="30px" alt="Logo non VU" id="logoVU">
				</a>
			</div>
		</section>

		<!-- ---------------------------affiche-evaluation-------------------- -->
		<section class="affiche-evaluation">
			<div class="img-affiche">
				<img alt="Affiche film"
					src="<c:out value="${image}"/>"
					width="295px" class="img-affiche">
			</div>
			<div class="evaluation my-5">
				<div>
					<h5>Note Moyenne :</h5>
					<!-- <h5>Classement :</h5>
					<h5>Recommandé à :</h5> -->
				</div>
				<div>
					<p>Tag : <c:out value="${genres}"/></p>
					<div id="ajoutListe">
					<c:if test="${booleanConnexion == true}">
							<c:if test="${booleanAjout == false}">
								<button class="btn btn-primary btn-lg btn-block my-5" id="ajoutFilmListe" >Ajouter à ma liste</button>
							</c:if>
							
					</c:if>
				</div>
				</div>
				<!-- Div pour ajout de la note -->
				<div class="text-center my-5">
				<!-- https://codepen.io/andreacrawford/pen/NvqJXW -->
    			<div class="rating-group" id="rating-group1">
        			<input class="rating__input rating__input--none" checked name="rating2" id="rating2-0" value="0" type="radio">
        			<label aria-label="0 stars" class="rating__label" for="rating2-0">&nbsp;</label> <!-- &nbsp; = espace -->
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
			</div>
			</div>
		</section>

		<!-- ---------------caracteristique-acteurs-video-------------------- -->
		<section class="caracteristique-acteurs-video">
			<div class="caracteristique">
				<h5>Date de sortie : <c:out value="${dateSortie}"/></h5>
				<h5>Genre film :
					<c:out value="${genres}"/>
				</h5>
				<h5 align="justify">Synopsis : <c:out value="${synopsis}"/></h5>
				<h5>Origine : 
					<c:forEach items="${listeOrigines}" var="currentOrigines">
						<c:out value="${currentOrigines}"/>
					</c:forEach>
				</h5>
				<h5>Durée : <c:out value="${durée}"/></h5>
			</div>

			<div class="acteurs">
				<h3>Acteurs :</h3>
				<section class="centerActeurs slider">
					<c:forEach items="${acteurs}" var="currentActeurs">
						<div class="card text-center cards-personnage">
						  	<img src="https://image.tmdb.org/t/p/w500<c:out value="${currentActeurs.image}"/>" class="card-img-top" alt="Acteur">

						  	<div class="card-footer">
						 		<i><c:out value="${currentActeurs.role}"/></i>
						  		<br>
						 		<c:out value="${currentActeurs.name}"/>
						  	</div>
						</div>
					</c:forEach>
				</section>
			</div>
			<div class="video">
				<h3>Vidéos :</h3>
				<section class="centerVideos slider">
					<c:forEach items="${videos}" var="currentVideos">
						<div class="card text-center">
							<iframe src="https://www.youtube.com/embed/<c:out value="${currentVideos.video}"/>" width="100%"></iframe> 
						</div>
					</c:forEach>
				</section>
			</div>
		</section>


		<!-- ---------------RecommandationFilm-------------------- -->
		<section class="recommandationFilm">
			<h3>Vous pourriez aussi aimer :</h3>
			<div class="centerReco slider filmPropose">
				<c:forEach items="${reco}" var="currentReco">
					<div class="card text-center cards-reco">
			
						  		<img src="https://image.tmdb.org/t/p/w500<c:out value="${currentReco.image}"/>" class="card-img-top" alt="Affiche">

						  	<!-- <div class="card-body">
						    <h5 class="card-title"></h5>
						  	</div> -->
						  	<div class="card-footer">
						 		<c:out value="${currentReco.titre}"/>
						 		<a class="btn btn-info btn-sm my-2"  href="http://localhost:8080/projet_SAJ/JsonFilmReader?idFilm=<c:out value="${currentReco.id}"/>">En savoir plus</a>
						  	</div>
						</div>
				</c:forEach>
			</div>
		</section>

		<!-- ---------------reviews-ajouterReviews-------------------- -->
		<section class="reviews-ajouterReviews">

			<!-- Contenedor Principal -->
			<div class="comments-container">

				<ul id="comments-list" class="comments-list">
					<li>
						<div class="comment-main-level">
							<!-- Avatar -->
							<div class="comment-avatar">
								<img
									src="http://i9.photobucket.com/albums/a88/creaticode/avatar_1_zps8e1c80cd.jpg"
									alt="">
							</div>
							<!-- Contenedor del Comentario -->
							<div class="comment-box">
								<div class="comment-head">
									<h5 class="comment-name by-author">
										<a href="http://creaticode.com/blog">Agustin Ortiz</a>
									</h5>
									<span>hace 20 minutos</span> <i class="fa fa-reply"></i> <i
										class="fa fa-heart"></i>
								</div>
								<div class="comment-content">Lorem ipsum dolor sit amet,
									consectetur adipisicing elit. Velit omnis animi et iure
									laudantium vitae, praesentium optio, sapiente distinctio illo?
								</div>
							</div>
						</div> <!-- Respuestas de los comentarios -->
					</li>

					<li>
						<div class="comment-main-level">
							<!-- Avatar -->
							<div class="comment-avatar">
								<img
									src="http://i9.photobucket.com/albums/a88/creaticode/avatar_2_zps7de12f8b.jpg"
									alt="">
							</div>
							<!-- Contenedor del Comentario -->
							<div class="comment-box">
								<div class="comment-head">
									<h5 class="comment-name">
										<a href="http://creaticode.com/blog">Lorena Rojero</a>
									</h5>
									<span>hace 10 minutos</span> <i class="fa fa-reply"></i> <i
										class="fa fa-heart"></i>
								</div>
								<div class="comment-content">Lorem ipsum dolor sit amet,
									consectetur adipisicing elit. Velit omnis animi et iure
									laudantium vitae, praesentium optio, sapiente distinctio illo?
								</div>
							</div>
						</div>
					</li>
				</ul>
			</div>

			<div class="AjouterReviews">
				<form>
					<div class="form-group">
						<h3>
							<label for="comment">Ajouter un commentaire sur le film :</label>
						</h3>
						<textarea name="comment" class="form-control" rows="3"></textarea>
					</div>
					<button type="submit" class="btn btn-primary btn-lg btn-block">Envoyer</button>
				</form>

			</div>

		</section>

		<input type="hidden" name="idFilm" value="<c:out value="${idFilm}"/>"
			id="idFilm" /> <input type="hidden" name="titreFilm"
			value="<c:out value="${titre}"/>" id="titreFilm" />


	</main>
	<footer>
		<%@ include file="footer.jsp"%>
	</footer>

	<%@ include file="script.jsp"%>
	<script src="./js/scriptAddComment.js"></script>
	<script src="./js/scriptFilm.js"></script>
	<script src="https://code.jquery.com/jquery-2.2.0.min.js"
		type="text/javascript"></script>
	<script src="./slick/slick.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$(document).on('ready', function() {
			$(".regular").slick({
				dots : true,
				infinite : true,
				slidesToShow : 3,
				slidesToScroll : 3
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
