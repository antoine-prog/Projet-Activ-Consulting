<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Episode</title>
		<%@ include file="linkStyleSheetCSS.jsp"%>
		<link rel="stylesheet" href="./css/stylePageEpisode.css">
		<!-- CSS textarea -->
		<link href="./css/summernote-bs4.min.css" rel="stylesheet">
	</head>
	
	
	<body class="container">
		<header>
			<%@ include file="header.jsp"%>
		</header>


		<main>
			<!-- Nom de l'épisode + logo VU ou NonVU -->
			<div class="d-flex justify-content-center mb-5">
				<a class="img-deJaVu" href="#">
					<img src="./img/logoNonVU.png" alt="Logo non VU" id="logoVU">
				</a>
			</div>
			
			
			
			<!-- Image de l'épisode (le grand espace blanc est du à l'image -->
			<div class="text-center">
				<img src="./img/episode.png" alt="Image épisode" id="imageEpisodeA">
			
				<div class="text-center">
					<img src="<c:out value="${image}" />" alt="Image épisode" id="imageEpisodeB">
				</div>
				
				<h1> <c:out value="${titre}" /> </h1>
				<h2> <c:out value="${nom}" /></h2>
				
				<div class="pb-5 pt-5">
				
				<c:choose>
					<c:when test="${videoPresent == false}">
						<span class="span-episode"> VIDEO INDISPONIBLE </span>
					</c:when>
				
				<c:otherwise>
					<a href="<c:out value="${video}"/>" target="_blank"  >	
						<span class="span-episode"> VIDEO DISPONIBLE </span>
					</a>
				</c:otherwise>
				</c:choose>
				
				
						
				</div>
			</div>
			
			<!-- Div pour ajout de la note -->
			<div class="text-center">
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
			
			<!-- Div pour ajouter un smiley (&# + numéro smiley + ;) https://www.w3schools.com/charsets/ref_emoji_smileys.asp -->
			<div class="d-flex justify-content-center align-items-center" id="choixSmiley">
				<div class="d-flex flex-column">
					<button id="smileyContent" class="boutonSansDeco boutonSmiley">&#128515;</button> <!-- Content -->
					<span class="text-center desc-smiley">(Content)</span>
				</div>
				<div class="d-flex flex-column">
					<button id="smileyRire" class="boutonSansDeco boutonSmiley">&#128514;</button> <!-- Rire -->
					<span class="text-center desc-smiley">(Drôle)</span>
				</div>
				<div class="d-flex flex-column">
					<button id="smileyCoeur" class="boutonSansDeco boutonSmiley">&#128525;</button> <!-- Yeux en coeur -->
					<span class="text-center desc-smiley">(Fan)</span>
				</div>
				<div class="d-flex flex-column">
					<button id="smileyPeur" class="boutonSansDeco boutonSmiley">&#128561;</button> <!-- Peur -->
					<span class="text-center desc-smiley">(Effrayant)</span>
				</div>
				<div class="d-flex flex-column">
					<button id="smileyEndormi" class="boutonSansDeco boutonSmiley">&#128564;</button> <!-- Endormi -->
					<span class="text-center desc-smiley">(Ennuyant)</span>
				</div>
				<div class="d-flex flex-column">
					<button id="smileyPleurs" class="boutonSansDeco boutonSmiley">&#128557;</button> <!-- Pleurs -->
					<span class="text-center desc-smiley">(Triste)</span>
				</div>
				<div class="d-flex flex-column">
					<button id="smileyReflechi" class="boutonSansDeco boutonSmiley">&#129300;</button> <!-- Réfléchi -->
					<span class="text-center desc-smiley">(Dubitatif)</span>
				</div>
				<div class="d-flex flex-column">
					<button id="smileyEnerve" class="boutonSansDeco boutonSmiley">&#129324;</button> <!-- Enervé -->
					<span class="text-center desc-smiley">(Nul)</span>
				</div>
			</div>
			
			<div id="afficheSiEpisodeVu">
				<!-- Div acteurs principaux -->
				<div class="acteurs d-flex justify-content-between border border-dark mx-auto">
					<div class="d-flex flex-column">
						<p>Photo acteur/actrice</p>
						<p>Nom acteur/actrice</p>
						<p>Description</p>
					</div>
					<div class="d-flex flex-column">
						<p>Photo acteur/actrice</p>
						<p>Nom acteur/actrice</p>
						<p>Description</p>
					</div>
					<div class="d-flex flex-column">
						<p>Photo acteur/actrice</p>
						<p>Nom acteur/actrice</p>
						<p>Description</p>
					</div>
					<div class="d-flex flex-column">
						<p>Photo acteur/actrice</p>
						<p>Nom acteur/actrice</p>
						<p>Description</p>
					</div>
					<div class="d-flex flex-column">
						<p>Photo acteur/actrice</p>
						<p>Nom acteur/actrice</p>
						<p>Description</p>
					</div>
					<div class="d-flex flex-column">
						<p>Photo acteur/actrice</p>
						<p>Nom acteur/actrice</p>
						<p>Description</p>
					</div>
				</div>
				
				<!-- Div note + reco + classement -->
				<div class="d-flex justify-content-around mx-auto mt-4">
					<div class="d-flex flex-column align-items-center">
						<h4>Note</h4>
						<p>4</p>
					</div>
					<div class="d-flex flex-column align-items-center ">
						<h4>% Recommandation</h4>
						<p>87</p>
					</div>
					<div class="d-flex flex-column align-items-center ">
						<h4>Classement</h4>
						<p>10e</p>
					</div>
				</div>
			
				<!-- Div pour les reviews etc... -->
				<div class="review d-flex flex-column border border-dark mt-4">
					<div class="d-flex justify-content-between">
						<h3 class="tableReviewDate text-center">Date</h3>
						<h3 class="tableReviewUtilisateur text-center">Utilisateur</h3>
						<h3 class="tableReviewReview text-center">Commentaire</h3>
						<h3 class="tableReviewNote text-center">Noter le commentaire</h3>
					</div>
					<div class="d-flex justify-content-between">
						<p class="tableReviewDate text-center">Date</p>
						<p class="tableReviewUtilisateur text-center">Utilisateur</p>
						<p class="tableReviewReview text-center">Commentaire</p>
						<div class="d-flex justify-content-center">
							<button class="boutonSansDeco">
								<img src="./img/logoLIKE.png" alt="+1 commentaire" id="logoLike">
							</button>
							<button class="boutonSansDeco">
								<img src="./img/logoDISLIKE.png" alt="-1 commentaire" id="logoDislike">
							</button>
						</div>
					</div>
				</div>
				
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
									<h6 class="comment-name by-author">
										<a href="http://creaticode.com/blog">Agustin Ortiz</a>
									</h6>
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
									<h6 class="comment-name">
										<a href="http://creaticode.com/blog">Lorena Rojero</a>
									</h6>
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
				
				<!-- Formulaire nouveau mot de passe (contenu à dérouler) -->
				<nav class="navbar navbar-light" id="navbarReview">
					<!-- Titre barre déroulante -->
					<h3 class="navbar-brand mx-auto">Ajouter une review</h3>
					<!-- Bouton pour dérouler la liste -->
					<button class="navbar-toggler" type="bouton" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<!-- Contenu à dérouler -->
					<div class="collapse navbar-collapse" id="navbarCollapse">					
						<!-- Textarea customisable -->
						<form>
							<textarea id="summernote" name="editordata"></textarea>
							<div class="text-center">
								<button type="submit" class="btn btn-light mt-4">Envoyer</button>
							</div>
						</form>
					</div>
					<!-- Fin contenu à dérouler -->
				</nav>
			</div>
		</main>
		
		
		<footer>
			<%@ include file="footer.jsp"%>
		</footer>
		
		<!-- Pas de include script.js car zone review ne marche pas en jquery 3.5.1 -->
		<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
  		<script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
		<script src="./js/summernote-bs4.min.js"></script>
		<script src="./js/summernote-fr-FR.min.js"></script>
		<script src="./js/scriptPageEpisode.js"></script>
	</body>
</html>