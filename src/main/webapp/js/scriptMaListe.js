$('.dropdown-menu').on('click', function(e) {
	e.stopPropagation();
});

var cleAPI = "8bc5f304f3c448e636cf678d5d75d7e2";
$("#boutonRechercheDirecte").on("click", function() {
	// Recherche anime
	$.get("https://api.jikan.moe/v3/search/anime?q="+ $("#inputRechercheDirecte").val() + "&limit=16", function(dataAnime) {
		// Anime 1
		$("#imgResultatRechercheAnimeAjout1").attr("src", dataAnime.results[0].image_url);
		$("#titreResultatRechercheAnimeAjout1").html(dataAnime.results[0].title);
		$("#inputIDResultatRechercheAnimeAjout1").val(dataAnime.results[0].mal_id);
		$("#inputTitreResultatRechercheAnimeAjout1").val(dataAnime.results[0].title);
		// Anime 2
		$("#imgResultatRechercheAnimeAjout2").attr("src", dataAnime.results[1].image_url);
		$("#titreResultatRechercheAnimeAjout2").html(dataAnime.results[1].title);
		$("#inputIDResultatRechercheAnimeAjout2").val(dataAnime.results[1].mal_id);
		$("#inputTitreResultatRechercheAnimeAjout2").val(dataAnime.results[1].title);
		// Anime 3
		$("#imgResultatRechercheAnimeAjout3").attr("src", dataAnime.results[2].image_url);
		$("#titreResultatRechercheAnimeAjout3").html(dataAnime.results[2].title);
		$("#inputIDResultatRechercheAnimeAjout3").val(dataAnime.results[2].mal_id);
		$("#inputTitreResultatRechercheAnimeAjout3").val(dataAnime.results[2].title);
		// Anime 4
		$("#imgResultatRechercheAnimeAjout4").attr("src", dataAnime.results[3].image_url);
		$("#titreResultatRechercheAnimeAjout4").html(dataAnime.results[3].title);
		$("#inputIDResultatRechercheAnimeAjout4").val(dataAnime.results[3].mal_id);
		$("#inputTitreResultatRechercheAnimeAjout4").val(dataAnime.results[3].title);
		// Afficher la recherche anime
		$("#animeRecherche").show();
	});
	// Recherche films
	$.get("https://api.themoviedb.org/3/search/movie?api_key=" + cleAPI + "&query=" + $("#inputRechercheDirecte").val() + "&language=fr-FR", function(dataFilm) {
		// Film 1
		$("#imgResultatRechercheFilmAjout1").attr("src", "https://image.tmdb.org/t/p/w500" + dataFilm.results[0].poster_path);
		$("#titreResultatRechercheFilmAjout1").html(dataFilm.results[0].title);
		$("#inputIDResultatRechercheFilmAjout1").val(dataFilm.results[0].id);
		$("#inputTitreResultatRechercheFilmAjout1").val(dataFilm.results[0].title);
		// Film 2
		$("#imgResultatRechercheFilmAjout2").attr("src", "https://image.tmdb.org/t/p/w500" + dataFilm.results[1].poster_path);
		$("#titreResultatRechercheFilmAjout2").html(dataFilm.results[1].title);
		$("#inputIDResultatRechercheFilmAjout2").val(dataFilm.results[1].id);
		$("#inputTitreResultatRechercheFilmAjout2").val(dataFilm.results[1].title);
		// Film 3
		$("#imgResultatRechercheFilmAjout3").attr("src", "https://image.tmdb.org/t/p/w500" + dataFilm.results[2].poster_path);
		$("#titreResultatRechercheFilmAjout3").html(dataFilm.results[2].title);
		$("#inputIDResultatRechercheFilmAjout3").val(dataFilm.results[2].id);
		$("#inputTitreResultatRechercheFilmAjout3").val(dataFilm.results[2].title);
		// Film 4
		$("#imgResultatRechercheFilmAjout4").attr("src", "https://image.tmdb.org/t/p/w500" + dataFilm.results[3].poster_path);
		$("#titreResultatRechercheFilmAjout4").html(dataFilm.results[3].title);
		$("#inputIDResultatRechercheFilmAjout4").val(dataFilm.results[3].id);
		$("#inputTitreResultatRechercheFilmAjout4").val(dataFilm.results[3].title);
		// Afficher la recherche anime
		$("#filmRecherche").show();
	});
	// Recherche séries
	$.get("https://api.themoviedb.org/3/search/tv?api_key=" + cleAPI + "&query=" + $("#inputRechercheDirecte").val() + "&language=fr-FR", function(dataSerie) {
		// Série 1
		$("#imgResultatRechercheSerieAjout1").attr("src", "https://image.tmdb.org/t/p/w500" + dataSerie.results[0].poster_path);
		$("#titreResultatRechercheSerieAjout1").html(dataSerie.results[0].name);
		$("#inputIDResultatRechercheSerieAjout1").val(dataSerie.results[0].id);
		$("#inputTitreResultatRechercheSerieAjout1").val(dataSerie.results[0].name);
		// Série 2
		$("#imgResultatRechercheSerieAjout2").attr("src", "https://image.tmdb.org/t/p/w500" + dataSerie.results[1].poster_path);
		$("#titreResultatRechercheSerieAjout2").html(dataSerie.results[1].name);
		$("#inputIDResultatRechercheSerieAjout2").val(dataSerie.results[1].id);
		$("#inputTitreResultatRechercheSerieAjout2").val(dataSerie.results[1].name);
		// Série 3
		$("#imgResultatRechercheSerieAjout3").attr("src", "https://image.tmdb.org/t/p/w500" + dataSerie.results[2].poster_path);
		$("#titreResultatRechercheSerieAjout3").html(dataSerie.results[2].name);
		$("#inputIDResultatRechercheSerieAjout3").val(dataSerie.results[2].id);
		$("#inputTitreResultatRechercheSerieAjout3").val(dataSerie.results[2].name);
		// Série 4
		$("#imgResultatRechercheSerieAjout4").attr("src", "https://image.tmdb.org/t/p/w500" + dataSerie.results[3].poster_path);
		$("#titreResultatRechercheSerieAjout4").html(dataSerie.results[3].name);
		$("#inputIDResultatRechercheSerieAjout4").val(dataSerie.results[3].id);
		$("#inputTitreResultatRechercheSerieAjout4").val(dataSerie.results[3].name);
		// Afficher la recherche anime
		$("#serieRecherche").show();
	});
});

// Bouton ajouter à la liste Anime
$("#boutonAjoutAnime1").on("click", function() {
	$.get("http://localhost:8080/projet_SAJ/AjoutAnimeListe?idAnime=" + $("#inputIDResultatRechercheAnimeAjout1").val() + "&titreAnime=" + $("#inputTitreResultatRechercheAnimeAjout1").val(), function(data) {
		setTimeout(function(){ location.reload(); }, 500);
	});
});
$("#boutonAjoutAnime2").on("click", function() {
	$.get("http://localhost:8080/projet_SAJ/AjoutAnimeListe?idAnime=" + $("#inputIDResultatRechercheAnimeAjout2").val() + "&titreAnime=" + $("#inputTitreResultatRechercheAnimeAjout2").val(), function(data) {
		setTimeout(function(){ location.reload(); }, 500);
	});
});
$("#boutonAjoutAnime3").on("click", function() {
	$.get("http://localhost:8080/projet_SAJ/AjoutAnimeListe?idAnime=" + $("#inputIDResultatRechercheAnimeAjout3").val() + "&titreAnime=" + $("#inputTitreResultatRechercheAnimeAjout3").val(), function(data) {
		setTimeout(function(){ location.reload(); }, 500);
	});
});
$("#boutonAjoutAnime4").on("click", function() {
	$.get("http://localhost:8080/projet_SAJ/AjoutAnimeListe?idAnime=" + $("#inputIDResultatRechercheAnimeAjout4").val() + "&titreAnime=" + $("#inputTitreResultatRechercheAnimeAjout4").val(), function(data) {
		setTimeout(function(){ location.reload(); }, 500);
	});
});
//Bouton ajouter à la liste Film
$("#boutonAjoutFilm1").on("click", function() {
	$.get("http://localhost:8080/projet_SAJ/AjoutFilmListe?idFilm=" + $("#inputIDResultatRechercheFilmAjout1").val() + "&titreFilm=" + $("#inputTitreResultatRechercheFilmAjout1").val(), function(data) {
		setTimeout(function(){ location.reload(); }, 500);
	});
});
$("#boutonAjoutFilm2").on("click", function() {
	$.get("http://localhost:8080/projet_SAJ/AjoutFilmListe?idFilm=" + $("#inputIDResultatRechercheFilmAjout2").val() + "&titreFilm=" + $("#inputTitreResultatRechercheFilmAjout2").val(), function(data) {
		setTimeout(function(){ location.reload(); }, 500);
	});
});
$("#boutonAjoutFilm3").on("click", function() {
	$.get("http://localhost:8080/projet_SAJ/AjoutFilmListe?idFilm=" + $("#inputIDResultatRechercheFilmAjout3").val() + "&titreFilm=" + $("#inputTitreResultatRechercheFilmAjout3").val(), function(data) {
		setTimeout(function(){ location.reload(); }, 500);
	});
});
$("#boutonAjoutFilm4").on("click", function() {
	$.get("http://localhost:8080/projet_SAJ/AjoutFilmListe?idFilm=" + $("#inputIDResultatRechercheFilmAjout4").val() + "&titreFilm=" + $("#inputTitreResultatRechercheFilmAjout4").val(), function(data) {
		setTimeout(function(){ location.reload(); }, 500);
	});
});
//Bouton ajouter à la liste Série
$("#boutonAjoutSerie1").on("click", function() {
	$.get("http://localhost:8080/projet_SAJ/AjoutSerieListe?idSerie=" + $("#inputIDResultatRechercheSerieAjout1").val() + "&titreSerie=" + $("#inputTitreResultatRechercheSerieAjout1").val(), function(data) {
		setTimeout(function(){ location.reload(); }, 500);
	});
});
$("#boutonAjoutSerie2").on("click", function() {
	$.get("http://localhost:8080/projet_SAJ/AjoutSerieListe?idSerie=" + $("#inputIDResultatRechercheSerieAjout2").val() + "&titreSerie=" + $("#inputTitreResultatRechercheSerieAjout2").val(), function(data) {
		setTimeout(function(){ location.reload(); }, 500);
	});
});
$("#boutonAjoutSerie3").on("click", function() {
	$.get("http://localhost:8080/projet_SAJ/AjoutSerieListe?idSerie=" + $("#inputIDResultatRechercheSerieAjout3").val() + "&titreSerie=" + $("#inputTitreResultatRechercheSerieAjout3").val(), function(data) {
		setTimeout(function(){ location.reload(); }, 500);
	});
});
$("#boutonAjoutSerie4").on("click", function() {
	$.get("http://localhost:8080/projet_SAJ/AjoutSerieListe?idSerie=" + $("#inputIDResultatRechercheSerieAjout4").val() + "&titreSerie=" + $("#inputTitreResultatRechercheSerieAjout4").val(), function(data) {
		setTimeout(function(){ location.reload(); }, 500);
	});
});

