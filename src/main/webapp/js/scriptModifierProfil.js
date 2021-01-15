// Affiche div Paypal ou CB
$('input[type="radio"]').click(function(){
    if($(this).attr("value")=="option1"){
        $("#formRadioPaypal").show();
        $("#formRadioCB").hide();
    }
    if($(this).attr("value")=="option2"){
        $("#formRadioPaypal").hide();
        $("#formRadioCB").show();
    }        
});

$("#formModifProfil").on("submit", function(event) {
	event.preventDefault(); // Empêche la validation
	if ($("#mdp").val() != $("#confirmerMDP").val()) {
		$("#confirmerMDP").focus();
		$("#confirmerMDP").css("background-color","#FF8080");
	}
	else {
		document.getElementById("formModifProfil").submit(); // Lance la validation (ne marche pas avec sélecteur jQuery)
	}
});
