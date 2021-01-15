$("#ajoutAnimeListe").on("click", function() {
	console.log("coucou");
	$.get("http://localhost:8080/projet_SAJ/AjoutAnimeListe?idAnime=" + $("#idAnime").val() + "&titreAnime=" + $("#titreAnime").val(), function(data) {
	});
//	setTimeout(function(){ location.reload(); }, 500);
});



var button = document.getElementById('ajoutAnimeListe')
button.addEventListener('click',hideshow,false);

function hideshow() {
    document.getElementById('ajoutListe').style.display = 'block'; 
    this.style.display = 'none';
    $("#indicateur").load(" #indicateur > * ");
    $("#boutonReview").load(" #boutonReview > * ");
}

$("#ajoutAnimeListe").click(function() {
    $("#indicateur").load(" #indicateur > * ");
    $("#boutonReview").load(" #boutonReview > * ");
  }); 