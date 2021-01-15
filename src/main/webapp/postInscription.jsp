<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!doctype html>
<html lang="fr">
<head>
<meta charset="utf-8">
<title>Qu'avez-vous déjà vu ?</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="linkStyleSheetCSS.jsp"%>
<link rel="stylesheet" href="./css/stylePostInscription.css">
<link rel="stylesheet" type="text/css" href="./slick/slick.css">
<link rel="stylesheet" type="text/css" href="./slick/slick-theme.css">
</head>


<body class="container">

	<header>
		<%@ include file="header.jsp"%>
	</header>
	<main>
		<section class="debuterSurNotreSite">
			<img alt="Bienvenue" src="img/bienvenueTranspa.png">
		</section>
		<section class="questionAnime">
			<div class="question">
				<h4>Avez-vous déja vu ces animes ?</h4>
			</div>
			<div class="regularAnime slider filmPropose">
				<c:forEach items="${recoAnime}" var="currentReco">
					<div class="card text-center cards-reco">
						 <img src="<c:out value="${currentReco.image}"/>"
							class="card-img-top" alt="Affiche">
						
						<!-- <div class="card-body">
						    <h5 class="card-title"></h5>
						  	</div> -->
						<div class="card-footer">
							<c:out value="${currentReco.title}" />
							<a class="btn btn-info btn-sm my-2" target="_blank" href="http://localhost:8080/projet_SAJ/JsonAnimeReader?idAnime=<c:out value="${currentReco.id}"/>">En savoir plus</a>
							
							
							<button class="btn btn-secondary btn-sm my-2" id="ajoutAnimeListe">Ajouter à ma liste</button>
								
						<!-- 	<div class="form-check">
									<input type="checkbox" class="form-check-input"
										id="exampleCheck1"> <label class="form-check-label ml-3 pt-1"
										for="exampleCheck1">Je veux le voir</label>
								</div> -->

						</div>
						
					</div>
				</c:forEach>
			</div>
		</section>

		<section class="questionFilm">
			<div class="question">
				<h4>Avez-vous déja vu ces films ?</h4>
			</div>

			<div class="regularFilm slider filmPropose">
				<c:forEach items="${recoFilm}" var="currentReco">
					<div class="card text-center cards-reco">
						  		<img src="https://image.tmdb.org/t/p/w500<c:out value="${currentReco.image}"/>" class="card-img-top" alt="Affiche">

						  	<div class="card-footer">
						 		<c:out value="${currentReco.titre}"/>
						 		<a class="btn btn-info btn-sm my-2" target="_blank" href="http://localhost:8080/projet_SAJ/JsonFilmReader?idFilm=<c:out value="${currentReco.id}"/>">En savoir plus</a>
							
								<button class="btn btn-secondary btn-sm my-2" id="ajoutFilmListe" >Ajouter à ma liste</button>
<!-- 							<div class="form-check">
								<input type="checkbox" class="form-check-input"
									id="exampleCheck1"> <label class="form-check-label ml-3 pt-1"
									for="exampleCheck1">Je veux le voir</label>
							</div> -->


						</div>
						</div>
				</c:forEach>
			</div>

		</section>


		<section class="questionSerie">
			<div class="question">
				<h4>Avez-vous déja vu ces séries ?</h4>
			</div>

			<div>
				<div class="regularSerie slider filmPropose">
					<c:forEach items="${recoSerie}" var="currentReco">
						<div class="card text-center cards-reco">
							<a href="JsonSerieReader"> <img
								src="https://image.tmdb.org/t/p/w500<c:out value="${currentReco.image}"/>"
								class="card-img-top" alt="Affiche">
							</a>

							<div class="card-footer">
								<c:out value="${currentReco.titre}" />
								<a class="btn btn-info btn-sm my-2" target="_blank" href="http://localhost:8080/projet_SAJ/JsonSerieReader?idSerie=<c:out value="${currentReco.id}"/>">En savoir plus</a>
								
								<button class="btn btn-secondary btn-sm my-2" id="ajoutSerieListe">Ajouter à ma liste</button>
<!-- 								<div class="form-check">
									<input type="checkbox" class="form-check-input"
										id="exampleCheck1"> <label class="form-check-label ml-3 pt-1"
										for="exampleCheck1">Je veux le voir</label>
								</div> -->

							</div>
						</div>
					</c:forEach>
				</div>
			</div>

		</section>


		<br> <br>


		<%-- <c:if test="${booleanAjout == false}"> --%>
			<button id="ajoutAnimeListe" type="submit"
				class="btn btn-primary btn-lg btn-block">Mon Profil</button>
		<%-- </c:if> --%>


	</main>
	<footer>
		<%@ include file="footer.jsp"%>
	</footer>

	<%@ include file="script.jsp"%>
	<script src="./js/scriptAddComment.js"></script>
	<script src="https://code.jquery.com/jquery-2.2.0.min.js"
		type="text/javascript"></script>
	<script src="./slick/slick.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		$(document).on('ready', function() {
			$(".regularAnime").slick({
				dots : true,
				infinite : true,
				slidesToShow : 6,
				slidesToScroll : 1
			});
			$(".regularFilm").slick({
				dots : true,
				infinite : true,
				slidesToShow : 6,
				slidesToScroll : 1
			});
			$(".regularSerie").slick({
				dots : true,
				infinite : true,
				slidesToShow : 6,
				slidesToScroll : 1
			});
			$(".center").slick({
				dots : true,
				infinite : true,
				centerMode : true,
				slidesToShow : 3,
				slidesToScroll : 3
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
