$("#ajoutFilmListe").on("click", function() {
	console.log("coucou");
	$.get("http://localhost:8080/projet_SAJ/AjoutFilmListe?idFilm=" + $("#idFilm").val() + "&titreFilm=" + $("#titreFilm").val(), function(data) {
	});
	setTimeout(function(){ location.reload(); }, 500);
});