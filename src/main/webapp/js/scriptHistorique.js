// Titre "Tout" en gras au départ
$(document).ready(function() {
	$("#historiqueTout").css("font-weight","bold");
	$("#contenuHistoriqueAutres").hide();
});

//Titre "Tout" en gras au clic + affiche les div correspondantes
$("#historiqueTout").on("click", function() {
	$("#historiqueTout").css("font-weight","bold");
	$("#historiqueAnime").css("font-weight","normal");
	$("#historiqueFilm").css("font-weight","normal");
	$("#historiqueSerie").css("font-weight","normal");
	$("#historiqueAutres").css("font-weight","normal");
	$("#contenuHistorique").show();
	$("#contenuHistoriqueAutres").hide();
	$(".historiqueNom").show();
	$(".historiqueDate").show();
	$(".historiqueCategorie").show();
	$(".historiqueSaison").show();
	$(".historiqueEpisode").show();
	$(".historiqueNote").show();
	$(".historiqueLien").show();
});

//Titre "Anime" en gras au clic + affiche les sections correspondantes
$("#historiqueAnime").on("click", function() {
	$("#historiqueTout").css("font-weight","normal");
	$("#historiqueAnime").css("font-weight","bold");
	$("#historiqueFilm").css("font-weight","normal");
	$("#historiqueSerie").css("font-weight","normal");
	$("#historiqueAutres").css("font-weight","normal");
	$("#contenuHistorique").show();
	$("#contenuHistoriqueAutres").hide();
	$(".historiqueNom").show();
	$(".historiqueDate").show();
	$(".historiqueCategorie").hide();
	$(".historiqueSaison").show();
	$(".historiqueEpisode").show();
	$(".historiqueNote").show();
	$(".historiqueLien").show();
});

//Titre "Film" en gras au clic + affiche les sections correspondantes
$("#historiqueFilm").on("click", function() {
	$("#historiqueTout").css("font-weight","normal");
	$("#historiqueAnime").css("font-weight","normal");
	$("#historiqueFilm").css("font-weight","bold");
	$("#historiqueSerie").css("font-weight","normal");
	$("#historiqueAutres").css("font-weight","normal");
	$("#contenuHistorique").show();
	$("#contenuHistoriqueAutres").hide();
	$(".historiqueNom").show();
	$(".historiqueDate").show();
	$(".historiqueCategorie").hide();
	$(".historiqueSaison").hide();
	$(".historiqueEpisode").hide();
	$(".historiqueNote").show();
	$(".historiqueLien").show();
});

//Titre "Serie" en gras au clic + affiche les sections correspondantes
$("#historiqueSerie").on("click", function() {
	$("#historiqueTout").css("font-weight","normal");
	$("#historiqueAnime").css("font-weight","normal");
	$("#historiqueFilm").css("font-weight","normal");
	$("#historiqueSerie").css("font-weight","bold");
	$("#historiqueAutres").css("font-weight","normal");
	$("#contenuHistorique").show();
	$("#contenuHistoriqueAutres").hide();
	$(".historiqueNom").show();
	$(".historiqueDate").show();
	$(".historiqueCategorie").hide();
	$(".historiqueSaison").show();
	$(".historiqueEpisode").show();
	$(".historiqueNote").show();
	$(".historiqueLien").show();
});

//Titre "Autres" en gras au clic + affiche les sections correspondantes
$("#historiqueAutres").on("click", function() {
	$("#historiqueTout").css("font-weight","normal");
	$("#historiqueAnime").css("font-weight","normal");
	$("#historiqueFilm").css("font-weight","normal");
	$("#historiqueSerie").css("font-weight","normal");
	$("#historiqueAutres").css("font-weight","bold");
	$("#contenuHistorique").hide();
	$("#contenuHistoriqueAutres").show();
});