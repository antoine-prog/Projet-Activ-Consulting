var modifNationaliteVisible = false;
var modifAnimeVisible = false;
var modifFilmVisible = false;
var modifSerieVisible = false;
var modifDescVisible = false;



$("#modifierNationalite").on("click", function() {
	if (modifNationaliteVisible) {
		$("#affichageModifNationalite").hide();
		modifNationaliteVisible = false;
	}
	else {
		$("#affichageModifNationalite").show();
		modifNationaliteVisible = true;
	}
});

$("#modifierAnimePrefere").on("click", function() {
	if (modifAnimeVisible) {
		$("#affichageModifAnimePrefere").hide();
		modifAnimeVisible = false;
	}
	else {
		$("#affichageModifAnimePrefere").show();
		modifAnimeVisible = true;
	}
});

$("#modifierFilmPrefere").on("click", function() {
	if (modifFilmVisible) {
		$("#affichageModifFilmPrefere").hide();
		modifFilmVisible = false;
	}
	else {
		$("#affichageModifFilmPrefere").show();
		modifFilmVisible = true;
	}
});

$("#modifierSeriePreferee").on("click", function() {
	if (modifSerieVisible) {
		$("#affichageModifSeriePreferee").hide();
		modifSerieVisible = false;
	}
	else {
		$("#affichageModifSeriePreferee").show();
		modifSerieVisible = true;
	}
});

$("#modifierDescription").on("click", function() {
	if (modifDescVisible) {
		$("#affichageModifDesc").hide();
		modifDescVisible = false;
	}
	else {
		$("#affichageModifDesc").show();
		modifDescVisible = true;
	}
});




// Supprimer CB
$("#supprCompteBanc0").on("click", function() {
	$.get("http://localhost:8080/projet_SAJ/SupprimerCarteCredit?numero=0" , function(data) {
		
	});
	setTimeout(function(){ location.reload(); }, 500);
});
$("#supprCompteBanc1").on("click", function() {
	$.get("http://localhost:8080/projet_SAJ/SupprimerCarteCredit?numero=1" , function(data) {
		
	});
	setTimeout(function(){ location.reload(); }, 500);
});
$("#supprCompteBanc2").on("click", function() {
	$.get("http://localhost:8080/projet_SAJ/SupprimerCarteCredit?numero=2" , function(data) {
		
	});
	setTimeout(function(){ location.reload(); }, 500);
});
$("#supprCompteBanc3").on("click", function() {
	$.get("http://localhost:8080/projet_SAJ/SupprimerCarteCredit?numero=3" , function(data) {
		
	});
	setTimeout(function(){ location.reload(); }, 500);
});
$("#supprCompteBanc4").on("click", function() {
	$.get("http://localhost:8080/projet_SAJ/SupprimerCarteCredit?numero=4" , function(data) {
		
	});
	setTimeout(function(){ location.reload(); }, 500);
});