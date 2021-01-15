// Titre "Tout" en gras au départ
$(document).ready(function() {
	$("#reviewsTout").css("font-weight","bold");
});

// Titre "Tout" en gras au clic
$("#reviewsTout").on("click", function() {
	$("#reviewsTout").css("font-weight","bold");
	$("#reviewsAnime").css("font-weight","normal");
	$("#reviewsFilm").css("font-weight","normal");
	$("#reviewsSerie").css("font-weight","normal");
});

//Titre "Anime" en gras au clic
$("#reviewsAnime").on("click", function() {
	$("#reviewsTout").css("font-weight","normal");
	$("#reviewsAnime").css("font-weight","bold");
	$("#reviewsFilm").css("font-weight","normal");
	$("#reviewsSerie").css("font-weight","normal");
});

//Titre "Film" en gras au clic
$("#reviewsFilm").on("click", function() {
	$("#reviewsTout").css("font-weight","normal");
	$("#reviewsAnime").css("font-weight","normal");
	$("#reviewsFilm").css("font-weight","bold");
	$("#reviewsSerie").css("font-weight","normal");
});

//Titre "Série" en gras au clic
$("#reviewsSerie").on("click", function() {
	$("#reviewsTout").css("font-weight","normal");
	$("#reviewsAnime").css("font-weight","normal");
	$("#reviewsFilm").css("font-weight","normal");
	$("#reviewsSerie").css("font-weight","bold");
});