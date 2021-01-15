<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!doctype html>
<html lang="fr">
<head>
<meta charset="utf-8">
<title>Recommandation</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="linkStyleSheetCSS.jsp"%>
<link rel="stylesheet" href="./css/stylePageEpisode.css">

</head>


<body class="container">

	<header>
		<%@ include file="header.jsp"%>
	</header>
	<main class="mainRecommandation">

		<section class="btn-dejaVu-et-note">
			<!-- Nom de l'épisode + logo VU ou NonVU -->
			<div class="d-flex justify-content-center">
				<a class="img-deJaVu" href="#">
					<img src="./img/logoNonVU.png" width="30px" alt="Logo non VU" id="logoVU">
				</a>
			</div>
			<br>
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

		</section>

		<section class="recommandation">
			<a class="recommandation-non" href="#">
				<img src="img/logoNON.png" alt="Je n'aime pas la recommandation"
					height="100px" />
				<%-- <c:if test="${booleanAjout == false}"> --%>
						<button class="btn btn-primary btn-lg btn-block mt-3" id="ajoutAnimeListe" >Ignorer</button>
					<%-- </c:if> --%>
			</a>
			<div class="recommandation-proposition">
				<div class="photo-de-la-recommandation">
					<a href="https://fmovies.to/film/homeland-8.yvp20/4qm0427"> <img
						alt="Homelande Saison 8"
						src="https://fr.web.img2.acsta.net/pictures/19/12/09/09/37/0555095.jpg"
						width="280px" />
					</a>
				</div>
				<div class="resume-proposition">
					<br>
					<h5>Homeland Saison 8</h5>
					<h6>SYNOPSIS</h6>
					<p align="justify">Carrie est rappelée par Saul. Devenu conseiller à la
						sécurité nationale du nouveau Président des États-Unis, Saul est
						chargé de négocier la paix avec les talibans d’Afghanistan, et
						compte sur l’expérience de sa protégée pour servir sa cause dans
						ce pays à haut risque. Carrie va affronter le puissant leader
						Haissam Haqqani qu’elle avait déjà traqué il y a des années.</p>
				</div>
			</div>
			<a class="recommandation-oui" href="#">
				<img src="img/logoOUI.png" alt="J'aime la recommandation"
					height="110px" />
				<%-- <c:if test="${booleanAjout == false}"> --%>
						<button class="btn btn-primary btn-lg btn-block mt-3" id="ajoutAnimeListe" >Ajouter à ma liste</button>
					<%-- </c:if> --%>
			</a>
			
		</section>


	</main>
	<footer>
		<%@ include file="footer.jsp"%>
	</footer>

	<%@ include file="script.jsp"%>



</body>
</html>