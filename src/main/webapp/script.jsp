<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
<!-- 	<script src="./js/vendor/jquery.js"></script>
  <script src="./js/vendor/what-input.js"></script>
  <script src="./js/vendor/foundation.js"></script>
  <script src="./js/app.js"></script> -->
  
<script>
$(document).on("submit", "form#formRecherche", function(event) {
	event.preventDefault();
	if ($("#selectRecherche").val() == "0") {
		$("#selectRecherche").focus();
		return false;
	}
	else {
		document.getElementById("formRecherche").submit(); // Lance la validation (ne marche pas avec sélecteur jQuery)
	}
});
$(document).on("submit", "form#formRecherche2", function(event) {
	event.preventDefault();
	if ($("#selectRecherche2").val() == "0") {
		$("#selectRecherche2").focus();
		return false;
	}
	else {
		document.getElementById("formRecherche2").submit(); // Lance la validation (ne marche pas avec sélecteur jQuery)
	}
});
</script>
<script src="./js/scriptPageEpisode.js"></script>

<script>
	window.console = window.console || function(t) {
	};
</script>
<script>
	if (document.location.search.match(/type=embed/gi)) {
		window.parent.postMessage("resize", "*");
	}
</script>