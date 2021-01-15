<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Modifier profil</title>
		<%@ include file="linkStyleSheetCSS.jsp"%>
		<link rel="stylesheet" href="./css/styleModifierProfil.css">
		<link rel="stylesheet" href="https://unpkg.com/js-datepicker/dist/datepicker.min.css">
  		<link rel="stylesheet" href="//unpkg.com/bootstrap-select@1.12.4/dist/css/bootstrap-select.min.css" type="text/css" />
  		<link rel="stylesheet" href="//unpkg.com/bootstrap-select-country@4.0.0/dist/css/bootstrap-select-country.min.css" type="text/css"/>
  		<link rel="stylesheet" href="./css/styleSelectCountryInscription.css" type="text/css"/>
	</head>
	
	
	<body class="container">
		<header>
			<%@ include file="header.jsp"%>
		</header>

		<main>
		<!-- "Navbar" pour naviguer entre les différentes jsp affichées -->
			<nav class="navbar navbar-expand-lg bg-white my-5 border border-dark rounded">
  				<div class="collapse navbar-collapse" id="navbarSupportedContent">
    				<ul class="navbar-nav">
      					<li class="nav-item">
        					<a class="btn btn-lg btn-outline-primary" href="Profil">Mon profil</a>
      					</li>
      					<li class="nav-item">
       						<a class="btn btn-lg btn-primary" href="ModifierProfil">Modifier profil</a>
      					</li>
     					<li class="nav-item">
        					<a class="btn btn-lg btn-outline-primary" href="MaListe">Ma liste</a>
      					</li>
      					<li class="nav-item">
        					<a class="btn btn-lg btn-outline-primary" href="historique.jsp">Mon historique</a>
      					</li>
      					<li class="nav-item">
        					<a class="btn btn-lg btn-outline-primary" href="mesReviews.jsp">Mes reviews</a>
      					</li>
      					<li class="nav-item">
        					<a class="btn btn-lg btn-outline-primary" href="mesAmis.jsp">Mes amis</a>
      					</li>
      					<li class="nav-item">
        					<a class="btn btn-lg btn-outline-warning" href="passPremium.jsp">Pass premium</a>
      					</li>
    				</ul>
  				</div>
			</nav>
			
			<form action="ModifierInformations" method="post" id="formModifProfil">
				<!-- Ecriture du mot de passe pour valider les modifs -->
				<div class="form-group">
					<label class="sr-only" for="inlineFormInputGroup">Mot de passe actuel</label>
      				<div class="input-group mb-2">
        				<div class="input-group-prepend">
          					<div class="input-group-text">Tapez votre mot de passe actuel</div>
        				</div>
        				<input type="password" class="form-control" id="inlineFormInputGroup" name="mdpActuel" required>
        			</div>
				</div>
			
			
				<!-- Formulaire nouveau mot de passe (contenu à dérouler) -->
				<nav class="navbar navbar-light bg-light">
					<!-- Titre barre déroulante -->
					<h3 class="navbar-brand mx-auto">Modifier mot de passe</h3>
					<!-- Bouton pour dérouler la liste -->
					<button class="navbar-toggler" type="bouton" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<!-- Contenu à dérouler -->
					<div class="collapse navbar-collapse bg-light" id="navbarCollapse">					
						<!-- Mot de passe -->
						<div class="form-row">
							<div class="col">
								<label for="mdp">Nouveau mot de passe</label>
								<input type="password" class="form-control" id="mdp" placeholder="Entrer nouveau mot de passe" name="nouveauMdp">
								<input type="checkbox" class="mt-1" id="afficherMDP">Afficher MDP
							</div>
							<div class="col">
								<label for="confirmerMDP">Confirmer nouveau mot de passe</label>
								<input type="password" class="form-control" id="confirmerMDP" name="confirmNouveauMdp">
							</div>
						</div>
						<!-- Question secrète + Réponse secrète (affichage sur la même ligne) -->
						<div class="form-row">
							<div class="col">
								<label for="qSecrete">Question secrète</label>
								<p><c:out value="${qSecrete}"/></p>
							</div>
							<div class="col">
								<label for="rSecrete">Réponse secrète</label>
								<input type="text" class="form-control" id="rSecrete" placeholder="Entrer réponse secrète" name="rSecrete">
							</div>
						</div>
					</div>
					<!-- Fin contenu à dérouler -->
				</nav>
			
				<div class="form-row mt-3">
					<div class="col border border-dark rounded">
						<label for="mail">Mail :</label>
						<p><c:out value="${mail}"/></p>
						<input type="email" class="form-control" id="mail" placeholder="Entrer nouveau mail" name="mail">
					</div>
					<div class="col border border-dark rounded">
						<label for="pays">Pays :</label>
						<p><c:out value="${pays}"/></p>
						<select class="form-control selectpicker countrypicker" data-default="FR" data-flag="true" name="pays"></select>
					</div>
				</div>
				<div class="form-row mt-3">
					<div class="col d-flex justify-content-around border border-dark rounded">
						<div>
							<label for="prenom">Prénom :</label>
							<p><c:out value="${prenom}"/></p>
							<input type="text" class="form-control" id="prenom" placeholder="Entrer nouveau prénom" name="prenom">
						</div>
						<div>
							<label for="nom">Nom :</label>
							<p><c:out value="${nom}"/></p>
							<input type="text" class="form-control" id="nom" placeholder="Entrer nouveau nom" name="nom">
						</div>
					</div>
					<div class="col border border-dark rounded">
						<label for="pays">Fuseau horaire (UTC) :</label>
						<p><c:out value="${fuseau}"/></p>
						<select class="form-control" id="fuseauHoraire" name="fuseau">
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
				<div class="form-row mt-3 mb-3">
					<div class="col border border-dark rounded">
						<label for="sexe">Sexe :</label>
						<p><c:out value="${sexe}"/></p>
    					<select class="form-control" id="sexe" name="sexe">
    						<option selected></option>
      						<option value="F">F</option>
      						<option value="M">M</option>
      						<option value="0">Non spécifié</option>
    					</select>
					</div>
					<div class="col border border-dark rounded">
						<label for="pays">Date de naissance :</label>
						<p><c:out value="${date}"/></p>
						<input type="text" class="form-control" id="datePicker" name="date">
					</div>
				</div>
				<button type="submit" class="btn btn-primary my-4">Valider</button>
			</form>
				
			<!-- Formulaire nouvelle méthode de paiement (contenu à dérouler) -->
			<nav class="navbar navbar-light bg-light">
				<!-- Titre barre déroulante -->
				<h3 class="navbar-brand mx-auto">Ajouter méthode de paiement</h3>
				<!-- Bouton pour dérouler la liste -->
				<button class="navbar-toggler" type="bouton" data-toggle="collapse" data-target="#navbarCollapse2" aria-controls="navbarCollapse2" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<!-- Contenu à dérouler -->
				<div class="collapse navbar-collapse bg-light" id="navbarCollapse2">					
					<!-- Choix de la méthode de paiement -->
					<div class="d-flex justify-content-around mb-3">
						<div class="form-check form-check-inline">
  							<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
  							<label class="form-check-label" for="inlineRadio1">PAYPAL</label>
						</div>
						<div class="form-check form-check-inline">
  							<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
  							<label class="form-check-label" for="inlineRadio2">Carte de crédit</label>
						</div>
					</div>
					<!-- Div pour paiement paypal -->
					<form class="text-center" id="formRadioPaypal">
						<!-- Set up a container element for the button -->
    					<span id='cwppButton'></span>
    					<button type="submit" class="btn btn-primary col-9 mt-4">Valider</button>
					</form>
					<!-- Div pour paiement carte bancaire -->
					<form id="formRadioCB" action="AjouterCarteCredit" method="post">
						<div class="form-row">
							<div class="col">
								<label for="numeroCarte">Numéro de carte bancaire</label>
      							<input type="number" class="form-control" id="numeroCarte" name="numeroCarte" required>
      						</div>
      						<div class="col">
      							<label for="titulaireCB">Titulaire de la carte</label>
      							<input type="text" class="form-control" id="titulaireCB" name="titulaireCB" required>
      						</div>
      					</div>
      					<div class="form-row">
							<div class="col">
								<label>Date d'expiration</label>
								<div class="d-flex justify-content-between">
      								<select class="form-control" id="moisExpiration" name="moisExpiration" required>
                    					<option value="01">Janvier</option>
                    					<option value="02">Février</option>
                    					<option value="03">Mars</option>
                   						<option value="04">Avril</option>
                    					<option value="05">Mai</option>
                    					<option value="06">Juin</option>
                    					<option value="07">Juillet</option>
                    					<option value="08">Août</option>
                    					<option value="09">Septembre</option>
                    					<option value="10">Octobre</option>
                    					<option value="11">Novembre</option>
                    					<option value="12">Décembre</option>
                					</select>
                					<select class="form-control" id="anneeExpiration" name="anneeExpiration" required>
                    					<option value="2020">2020</option>
                    					<option value="2021">2021</option>
                    					<option value="2022">2022</option>
                    					<option value="2023">2023</option>
                    					<option value="2024">2024</option>
                    					<option value="2025">2025</option>
                					</select>
                				</div>
      						</div>
      						<div class="col">
      							<label for="cvc">CVC</label>
      							<input type="number" class="form-control" id="cvc" name="cvc" required>
      						</div>
      					</div>
      					<div class="form-row mt-4">
      						<div class="col">
      							<div class="form-check">
    								<input type="checkbox" class="form-check-input" id="checkConditionsCB" required>
    								<label class="form-check-label" for="checkConditionsCB">J'ai lu et j'accepte les conditions</label>
  								</div>
      						</div>
      						<div class="col">
      							<button type="submit" class="btn btn-primary form-control">Valider</button>
      						</div>
      					</div>
    				</form>
				</div>
				<!-- Fin contenu à dérouler -->
			</nav>
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
  		<script src="./js/scriptModifierProfil.js"></script>
  		<!-- Include the PayPal JavaScript SDK -->
    	<script src='https://www.paypalobjects.com/js/external/connect/api.js'></script>
    	<script src="./js/scriptPaypal.js"></script>
	</body>
</html>