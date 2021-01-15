<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="services.RequeteBDD"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8">
		<title>Inscription</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%@ include file="linkStyleSheetCSS.jsp"%>
		<link rel="stylesheet" href="https://unpkg.com/js-datepicker/dist/datepicker.min.css">
  		<link rel="stylesheet" href="//unpkg.com/bootstrap-select@1.12.4/dist/css/bootstrap-select.min.css" type="text/css" />
  		<link rel="stylesheet" href="//unpkg.com/bootstrap-select-country@4.0.0/dist/css/bootstrap-select-country.min.css" type="text/css"/>
  		<link rel="stylesheet" href="./css/styleSelectCountryInscription.css" type="text/css"/>
  		<link rel="stylesheet" href="./css/styleInscription.css"/>
	</head>
	
	
	<body class="container">
		<header>
			<%@ include file="header.jsp"%>
		</header>
		
		
	<main class="main-inscription">
		<h3 class="text-center mt-5 mb-3">S'INSCRIRE</h3>
		<form action="Inscription" name="formInscription" id="formInscription" onSubmit="return validationFormulaire(event);" method="post">
			<div class="form-row py-2">
  				<div class="col">
    				<label for="pseudo">Pseudo*</label>
    				<input type="text" class="form-control" id="pseudo" name="pseudo" required>
    				<span id="pseudoSpan"></span>
  				</div>
  				<div class="col">
  					<label for="sexe">Sexe*</label>
    				<select class="form-control" id="sexe" name="sexe" required>
      					<option value="F" selected>F</option>
      					<option value="M">M</option>
      					<option value="0">Non spécifié</option>
    				</select>
  				</div>
  			</div>
  			<div class="form-row py-2">
  				<div class="col">
    				<label for="prenom">Prénom</label>
    				<input type="text" class="form-control" id="prenom" name="prenom">
  				</div>
  				<div class="col">
  					<label for="nom">Nom</label>
    				<input type="text" class="form-control" id="nom" name="nom">
  				</div>
  				<div class="col">
    				<label for="datePicker">Date de naissance</label>
    				<input type="text" class="form-control" id="datePicker" name="dateNaissance">
  				</div>
  			</div>
  			<div class="form-row py-2">
  				<div class="col">
  					<label for="pays">Pays</label>
  					<select class="form-control selectpicker countrypicker" data-default="FR" data-flag="true" name="pays"></select>
  				</div>
  				<div class="col">
  					<label for="fuseauHoraire">Fuseau horaire</label>
    				<select class="form-control" id="fuseauHoraire" name="fuseauHoraire">
      					<option value="-11">UTC-11:00</option>
      					<option value="-10">UTC-10:00</option>
      					<option value="-9:30">UTC-9:30</option>
      					<option value="-9">UTC-9:00</option>
      					<option value="-8">UTC-8:00</option>
      					<option value="-7">UTC-7:00</option>
      					<option value="-6">UTC-6:00</option>
      					<option value="-5">UTC-5:00</option>
      					<option value="-4">UTC-4:00</option>
      					<option value="-3:30">UTC-3:30</option>
      					<option value="-3">UTC-3:00</option>
      					<option value="-2">UTC-2:00</option>
      					<option value="-1">UTC-1:00</option>
      					<option value="+0">UTC+0:00</option>
      					<option value="+1">UTC+1:00</option>
      					<option value="+2" selected>UTC+2:00</option>
      					<option value="+3">UTC+3:00</option>
      					<option value="+3:30">UTC+3:30</option>
      					<option value="+4">UTC+4:00</option>
      					<option value="+4:30">UTC+4:30</option>
      					<option value="+5">UTC+5:00</option>
      					<option value="+5:30">UTC+5:30</option>
      					<option value="+5:45">UTC+5:45</option>
      					<option value="+6">UTC+6:00</option>
      					<option value="+6:30">UTC+6:30</option>
      					<option value="+7">UTC+7:00</option>
      					<option value="+8">UTC+8:00</option>
      					<option value="+8:45">UTC+8:45</option>
      					<option value="+9">UTC+9:00</option>
      					<option value="+9:30">UTC+9:30</option>
      					<option value="+10">UTC+10:00</option>
      					<option value="+10:30">UTC+10:30</option>
      					<option value="+11">UTC+11:00</option>
      					<option value="+12">UTC+12:00</option>
      					<option value="+12:45">UTC+12:45</option>
      					<option value="+13">UTC+13:00</option>
      					<option value="+14">UTC+14:00</option>
    				</select>
  				</div>
  			</div>
  			<div class="form-row py-2">
  				<div class="col">
    				<label for="mdp">Mot de passe*</label>
    				<input type="password" class="form-control" id="mdp" name="mdp" required>
    				<input type="checkbox" class="mt-1" id="afficherMDP">Afficher MDP
  				</div>
  				<div class="col">
  					<label for="confirmerMdp">Confirmer mot de passe*</label>
    				<input type="password" class="form-control" id="confirmerMdp" name="confirmMDP" required>
  				</div>
  			</div>
  			<div class="form-group py-2 my-0">
    			<label for="mail">Adresse mail*</label>
    			<input type="email" class="form-control" id="mail" placeholder="prenom.nom@exemple.com" name="mail" required>
  			</div>
  			<div class="form-group py-2 my-0">
    			<label for="confirmerMail">Confirmer adresse mail*</label>
    			<input type="email" class="form-control" id="confirmerMail" name="confirmMail" required>
  			</div>
  			<div class="form-group py-2 my-0">
  				<label for="qSecrete">Question secrète*</label>
    			<select class="form-control" id="qSecrete" name="qSecrete" required>
    				<option selected></option>
      				<option>Quel est ton Animal préféré ?</option>
      				<option>Quelle est le nom de ta ville de naissance ?</option>
      				<option>Quelle est ta couleur préférée ?</option>
      				<option>Quelle était le nom de votre école primaire</option>
      				<option>Quelle est ta qualité principale</option>
    			</select>
  			</div>
  			<div class="form-group py-2 my-0">
  				<label for="rSecrete">Réponse secrète*</label>
  				<input type="text" class="form-control" id="rSecrete" name="rSecrete" required>
  			</div>
  			<small class="mb-3">(Tous les champs marqués d'une * sont obligatoires)</small>
  			<div class="form-check py-2">
    			<input type="checkbox" class="form-check-input" id="checkConditions" required>
    			<label class="form-check-label ml-2" for="checkConditions">J'ai lu et j'accepte les conditions</label>
  			</div>
  			<input type="submit" class="btn btn-primary mt-4" value="Valider">
		</form>
	</main>
	
	
	<footer>
		<%@ include file="footer.jsp"%>
	</footer>



		<%@ include file="script.jsp"%>
  		<script src="https://unpkg.com/js-datepicker"></script>
  		<script src="./js/bootstrap-select/bootstrap-select.min.js"></script>
  		<script src="//unpkg.com/bootstrap-select@1.12.4/dist/js/bootstrap-select.min.js"></script> 
  		<script src="//unpkg.com/bootstrap-select-country@4.0.0/dist/js/bootstrap-select-country.min.js"></script>
  		<script src="./js/scriptInscription.js"></script>
	</body>
</html>