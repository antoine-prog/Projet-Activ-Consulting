// Script calendrier date de naissance
const picker = datepicker("#datePicker",
		{
		formatter: (input, date, instance) => {
			const value = date.toLocaleDateString()
			input.value = value // => '1/1/2099'
		},
		startDay: 1,
		customDays: ['Dim', 'Lun', 'Mar', 'Mer', 'Jeu', 'Ven', 'Sam'],
		customMonths: ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'],
		customOverlayMonths: ['Jan', 'Fév', 'Mar', 'Avr', 'Mai', 'Juin', 'Juill', 'Aout', 'Sept', 'Oct ', 'Nov', 'Déc'],
		overlayPlaceholder: 'Entrer une année',
		overlayButton: "Valider",
		showAllDates: true
		}
);


// Script liste choix pays + drapeau
$(".countrypicker").countrypicker();


// Script affichage MDP
$("#afficherMDP").on("click", function() {
	var linkMDP = $("#mdp");
	if (linkMDP.attr("type") === "password") {
		linkMDP.attr("type", "text");
	}
	else {
		linkMDP.attr("type", "password");
	}
});



// Vérification que le formulaire est valide avant d'aller au servlet
function validationFormulaire(event) {
	event.preventDefault(); // Empêche la validation
	$("#confirmerMail").css("background-color","white");
	$("#confirmerMdp").css("background-color","white");
//	Vérif mail + confirm mail ET mdp + confirm mdp OK
	if (($("#mdp").val() != $("#confirmerMdp").val()) && ($("#mail").val() != $("#confirmerMail").val())) {
		$("#confirmerMdp").focus();
		$("#confirmerMdp").css("background-color","#FF8080");
		$("#confirmerMail").focus();
		$("#confirmerMail").css("background-color","#FF8080");
		return false;
	}
//	Vérif mdp + confirm mdp OK
	else if ($("#mdp").val() != $("#confirmerMdp").val()) {
		$("#confirmerMdp").focus();
		$("#confirmerMdp").css("background-color","#FF8080");
		return false;
	}
//	Vérif mail + confirm mail OK
	else if ($("#mail").val() != $("#confirmerMail").val()) {
		$("#confirmerMail").focus();
		$("#confirmerMail").css("background-color","#FF8080");
		return false;
	}
//	Si tout est OK, valide le formulaire
	else {
		document.getElementById("formInscription").submit(); // Lance la validation (ne marche pas avec sélecteur jQuery)
	}
}


$("#pseudo").on("blur", function () {
	$.get("http://localhost:8080/projet_SAJ/CheckPseudo?pseudo=" + $("#pseudo").val(), function(data) {
		$("#pseudoSpan").html(data);
		if (data == "Pseudo disponible") {
			$("#pseudoSpan").css("color","green");
		}
		else {
			$("#pseudoSpan").css("color","red");
		}
	});
});