<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="fr">
	<head>
		<meta charset="utf-8">
		<title>SAJ HOME PAGE</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%@ include file="linkStyleSheetCSS.jsp"%>
		<link rel="stylesheet" href="./css/stylesWrapper.css">
		<link rel="stylesheet" type="text/css" href="./slick/slick.css">
		<link rel="stylesheet" type="text/css" href="./slick/slick-theme.css">
	</head>


<body class="container">

	<header>
		<%@ include file="header.jsp"%>
	</header>
	<main>
		<section class="debuterSurNotreSite mt-5">
			<img alt="Bienvenue" src="img/bienvenueTranspa.png">
		</section>
		
			<div class="question">
				<h1 align="center" class="mt-5">Animes, Films et Séries les plus vus de 2020 !!! </h1>
			</div>
		
	
		<section class="questionFilm">
			<div class="regularFilm slider filmPropose">
				<c:forEach items="${rechercheFilm}" var="currentReco">
					<div class="card text-center cards-reco">
						  	<img src="https://image.tmdb.org/t/p/w500<c:out value="${currentReco.image}"/>" class="card-img-top" alt="Affiche">
						  	<div class="card-footer">
						 		<c:out value="${currentReco.titre}"/>
						 		<a class="btn btn-info btn-sm my-2" href="http://localhost:8080/projet_SAJ/JsonFilmReader?idFilm=<c:out value="${currentReco.id}"/>">En savoir plus</a>
						</div>
						</div>
				</c:forEach>
			</div>

		</section>


		<section class="questionSerie">


			<div>
				<div class="regularSerie slider filmPropose">
					<c:forEach items="${rechercheSerie}" var="currentReco">
						<div class="card text-center cards-reco">
							<a href="JsonSerieReader"> <img
								src="https://image.tmdb.org/t/p/w500<c:out value="${currentReco.image}"/>"
								class="card-img-top" alt="Affiche">
							</a>

							<div class="card-footer">
								<c:out value="${currentReco.titre}" />
								<a class="btn btn-info btn-sm my-2" href="http://localhost:8080/projet_SAJ/JsonSerieReader?idSerie=<c:out value="${currentReco.id}"/>">En savoir plus</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

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
				lazyLoad : 'ondemand', // on demand progressive anticipated
				infinite : true
			});
		});
	</script>
</body>
</html>
