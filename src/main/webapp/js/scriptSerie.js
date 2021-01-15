$("#ajoutSerieListe").on("click", function() {
	console.log("coucou");
	$.get("http://localhost:8080/projet_SAJ/AjoutSerieListe?idSerie=" + $("#idSerie").val() + "&titreSerie=" + $("#titreSerie").val(), function(data) {
	});
	setTimeout(function(){ location.reload(); }, 500);
});