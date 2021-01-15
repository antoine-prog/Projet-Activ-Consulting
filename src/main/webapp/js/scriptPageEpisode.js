// Changer oeil fermé en oeil ouvert
$("#logoVU").on("click", function() {
  if ($("#logoVU").attr("src") == "./img/logoNonVU.png") {
	  $("#logoVU").attr("src","./img/logoVUU.png");
	  $("#afficheSiEpisodeVu").show();
  }
  else {
	  $("#logoVU").attr("src","./img/logoNonVU.png");
	  $("#afficheSiEpisodeVu").hide();
  }
});


// Griser autres smileys au clic
$("#smileyRire").on("click", function() {
	$(".boutonSmiley").css("filter","grayscale(100%)");
	$("#smileyRire").css("filter","grayscale(0%)");
});
$("#smileyCoeur").on("click", function() {
	$(".boutonSmiley").css("filter","grayscale(100%)");
	$("#smileyCoeur").css("filter","grayscale(0%)");
});
$("#smileyPeur").on("click", function() {
	$(".boutonSmiley").css("filter","grayscale(100%)");
	$("#smileyPeur").css("filter","grayscale(0%)");
});
$("#smileyEndormi").on("click", function() {
	$(".boutonSmiley").css("filter","grayscale(100%)");
	$("#smileyEndormi").css("filter","grayscale(0%)");
});
$("#smileyPleurs").on("click", function() {
	$(".boutonSmiley").css("filter","grayscale(100%)");
	$("#smileyPleurs").css("filter","grayscale(0%)");
});
$("#smileyReflechi").on("click", function() {
	$(".boutonSmiley").css("filter","grayscale(100%)");
	$("#smileyReflechi").css("filter","grayscale(0%)");
});
$("#smileyContent").on("click", function() {
	$(".boutonSmiley").css("filter","grayscale(100%)");
	$("#smileyContent").css("filter","grayscale(0%)");
});
$("#smileyEnerve").on("click", function() {
	$(".boutonSmiley").css("filter","grayscale(100%)");
	$("#smileyEnerve").css("filter","grayscale(0%)");
});



// Editeur zone review
$(document).ready(function() {
	$("#summernote").summernote({
		lang: 'fr-FR',
		placeholder: 'Ecrire une review',
		tabsize: 2,
		heigth: 300,
		toolbar: [
			["font", ["bold","italic","underline","strikethrough", "superscript", "subscript","clear"]],
			["fontname", ["fontname"]],
			['font', []],
		    ['fontsize', ['fontsize']],
			["color", ["color"]],
			["para", ["ul","ol","paragraph"]],
			["height", ["height"]],
			["table", ["table"]],
			["insert", ["link","hr"]],
			["help", ["help"]]
		]
	});
});
