<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="UTF-8">
		<title>Profil</title>
		<%@ include file="linkStyleSheetCSS.jsp"%>
		<link rel="stylesheet" href="./css/styleProfil.css">
	</head>
	
	
	<body class="container">
		<header>
			<%@ include file="header.jsp"%>
		</header>

		<main>
			<!-- "Navbar" pour naviguer entre les différentes jsp affichées -->
			<nav class="navbar navbar-expand-lg bg-white mt-5 border border-dark rounded p-3">
  				<div class="collapse navbar-collapse" id="navbarSupportedContent">
    				<ul class="navbar-nav">
      					<li class="nav-item">
        					<a class="btn btn-lg btn-primary" href="Profil">Mon profil</a>
      					</li>
      					<li class="nav-item">
       						<a class="btn btn-lg btn-outline-primary" href="ModifierProfil">Modifier profil</a>
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
			
			<!-- Contenu de la page -->
			<!-- Article pour image + infos + mail + localisation + prénom + fuseau + sexe + date naissance -->
			<article class="d-flex justify-content-between flex-wrap">
				<!-- div avatar -->
				<div class="border border-dark rounded p-3" id="contenu-article">
					<c:choose>
						<c:when test="${avatar == false}">
							<div class="text-center">
								<svg class="bi bi-person-square" width="20em" height="20em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg%22%3E">
  									<path fill-rule="evenodd" d="M14 1H2a1 1 0 00-1 1v12a1 1 0 001 1h12a1 1 0 001-1V2a1 1 0 00-1-1zM2 0a2 2 0 00-2 2v12a2 2 0 002 2h12a2 2 0 002-2V2a2 2 0 00-2-2H2z" clip-rule="evenodd"/>
  									<path fill-rule="evenodd" d="M2 15v-1c0-1 1-4 6-4s6 3 6 4v1H2zm6-6a3 3 0 100-6 3 3 0 000 6z" clip-rule="evenodd"/>
								</svg>
							</div>
						</c:when>
						<c:otherwise>
							<div class="text-center">
								<!-- /!\ Il ne faut upload que jpg !!!! -->
								<!-- Marche mais obligé de refresh dossier img..... -->
								<img src="img/avatars/<c:out value="${sessionScope.id}"/>.jpg" alt="Avatar" id="avatar">
							</div>
						</c:otherwise>
					</c:choose>
					<form action="<c:url value="/Profil" />" method="post" enctype="multipart/form-data">
            			<fieldset>
                			<legend>Changer d'avatar</legend>
                			
                			<input type="file" id="fichier" name="fichier" value="<c:out value="${fichier.nom}"/>" />
                			<span class="erreur">${form.erreurs['fichier']}</span>
                			<br />
                			
                			<input type="submit" value="Envoyer" class="sansLabel" />
                			<br />
                
                			<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>        
           				</fieldset>
        			</form>
				</div>
				<!-- div infos -->
				<div class="border border-dark rounded p-3" id="contenu-article">
					<h3>Infos</h3>
					<!-- Pseudo -->
					<p><strong class="mr-1">Pseudo :</strong><c:out value="${pseudo}"/></p>
					<!-- Points contrib -->
					<p><strong class="mr-1">Points de contribution :</strong><c:out value="${points}"/></p>
					<!-- Mail -->
					<p><strong class="mr-1">Mail :</strong><c:out value="${mail}"/></p>
					<!-- Prénom -->		
					<p><strong class="mr-1">Prénom :</strong><c:out value="${prenom}"/></p>		
					<!-- Nom -->
					<p><strong class="mr-1">Nom :</strong><c:out value="${nom}"/></p>		
					<!-- Sexe -->
					<p><strong class="mr-1">Sexe :</strong><c:out value="${sexe}"/></p>
					<!-- Date de naissance -->	
					<p><strong class="mr-1">Date de naissance :</strong><c:out value="${date}"/></p>
					<!-- Nationalité + bouton modifier (affichage sur la même ligne) -->
										<!-- <div class="d-flex justify-content-between"> -->
					<p><strong class="mr-1">Nationalité :</strong><c:out value="${nationalite}"/></p>
											<!-- <button class="btn btn-warning largeur-bouton-modif border border-dark" id="modifierNationalite">Modifier</button> -->
										<!-- </div> -->
					<!-- Fuseau horaire -->
					<p><strong class="mr-1">Fuseau horaire (UTC) :</strong><c:out value="${fuseau}"/></p>		
									<!-- Affichage du form servant à modifier nationalité -->
									<!-- <form class="form-group mt-3" id="affichageModifNationalite">
  										p class="form-control" id="choix-nationalite" rows="2"><i>A changer pour liste de pays</i></p>
  									</form> -->
									<!-- Anime préféré + bouton modifier (affichage sur la même ligne) -->
									<!-- <div class="d-flex justify-content-between">
										<p><strong>Anime préféré : </strong>*****animePrefere*****</p>
										<button class="btn btn-warning largeur-bouton-modif border border-dark" id="modifierAnimePrefere">Modifier</button>
									</div>
									Affichage du form servant à modifier anime préféré
									<form class="form-group mt-3" id="affichageModifAnimePrefere">
  										<p class="form-control" id="choix-anime-prefere" rows="2"><i>A changer pour liste animes</i></p>
  									</form>
									Film préféré + bouton modifier (affichage sur la même ligne)
									<div class="d-flex justify-content-between">
										<p><strong>Film préféré : </strong>*****filmPrefere*****</p>
										<button class="btn btn-warning largeur-bouton-modif border border-dark" id="modifierFilmPrefere">Modifier</button>
									</div>
									Affichage du form servant à modifier film préféré
									<form class="form-group mt-3" id="affichageModifFilmPrefere">
  										<p class="form-control" id="choix-film-prefere" rows="2"><i>A changer pour liste films</i></p>
  									</form>
									Série préférée + bouton modifier (affichage sur la même ligne)
									<div class="d-flex justify-content-between">
										<p><strong>Série préféré : </strong>*****seriePrefere*****</p>
										<button class="btn btn-warning largeur-bouton-modif border border-dark" id="modifierSeriePreferee">Modifier</button>
									</div>
									Affichage du form servant à modifier série préférée
									<form class="form-group mt-3" id="affichageModifSeriePreferee">
  										<p class="form-control" id="choix-film-prefere" rows="2"><i>A changer pour liste séries</i></p>
  									</form> -->
									<!-- Description + bouton modifier (affichage sur la même ligne) -->
									<!-- <div class="d-flex justify-content-between">
    									<p><strong>Description : </strong></p>
    									<p>Blablabla description à afficher</p>
    									<button class="btn btn-warning largeur-bouton-modif border border-dark" id="modifierDescription">Modifier</button>
  									</div>
  									<div class="form-group mt-3" id="affichageModifDesc">
  										<textarea class="form-control" id="description-textarea" rows="2" placeholder="Entrez votre nouvelle description"></textarea>
  									</div> -->
  									<!-- Bouton valid. modifications -->
									<!-- <div class="d-flex justify-content-end mt-2">
										<button type="submit" class="btn btn-primary align-self-end" id="bouton-fixe">Valider les modifications</button>
									</div> -->
				</div>
			</article>
			
			<!-- Article pour paypal ou CB (affichage en colonne) -->
			<article class="d-flex flex-column">
				<!-- Affichage infos sur le paypal + supprimer en ligne -->
				<!-- <div class="d-flex justify-content-between">
					<div class="border border-dark rounded" id="taille-flex-info-banc-texte">
						<h5>PAYPAL</h5>
					</div>
					<div class="border border-dark rounded" id="taille-flex-info-banc-texte">
						<h5>Nom compte PAYPAL lié</h5>
					</div>
					<div>
						<a href="#">
							<img src="./img/logoNON.png" alt="Supprimer compte PAYPAL">
						</a>
					</div>
				</div> -->
				<!-- Affichage infos sur le compte bancaire + supprimer en ligne -->
				<c:choose>
					<c:when test="${nombre_CB == 0}">
						<div class="d-flex justify-content-between">
							<div class="border border-dark rounded p-3" id="taille-flex-info-banc-texte">
								<h5 class="text-center"><c:out value="${code_banc}"/></h5>
							</div>
							<div class="border border-dark rounded p-3" id="taille-flex-info-banc-texte">
								<h5 class="text-center"><c:out value="${titulaire}"/></h5>
							</div>
						</div>
					</c:when>
					<c:otherwise>
						<div class="d-flex flex-column">
							<c:forEach items="${comptes}" var="currentCompte">
								<div class="d-flex justify-content-between">
									<div class="border border-dark rounded p-3" id="taille-flex-info-banc-texte">
										<h5 class="text-center"><c:out value="${currentCompte.code}"/></h5>
									</div>
									<div class="border border-dark rounded p-3" id="taille-flex-info-banc-texte">
										<h5 class="text-center"><c:out value="${currentCompte.titulaire}"/></h5>
									</div>
									<input type="hidden" name="idCompte" value="<c:out value="${currentCompte.id}"/>" id="inputIDCompteCB<c:out value="${currentCompte.numero}"/>">
									<button class="btn" id="supprCompteBanc<c:out value="${currentCompte.numero}"/>">
										<img src="./img/logoNoOoN.png" alt="Supprimer compte bancaire">
									</button>
								</div>
							</c:forEach>
						</div>
					</c:otherwise>
				</c:choose>
			</article>
			
			<!-- Article pour autorisation -->
			<!-- <article class="d-flex flex-column border border-dark rounded">
				div autorisation mail
				<div class="d-flex justify-content-center">
					<div>
						<h5>Autoriser les mails pour : </h5>
					</div>
					<div>
						<div class="form-check form-check-inline">
  							<input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
  							<label class="form-check-label" for="inlineCheckbox1">Messages privés</label>
						</div>
						<div class="form-check form-check-inline">
  							<input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
  							<label class="form-check-label" for="inlineCheckbox2">Ajout amis</label>
						</div>
						<div class="form-check form-check-inline">
  							<input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
  							<label class="form-check-label" for="inlineCheckbox3">Ajout épisodes/ films/ etc... </label>
						</div>
					</div>
				</div>
				div qui peut voir la liste
				<div class="d-flex justify-content-center">
					<div>
						<h5>Qui peut voir ma liste : </h5>
					</div>
					<div>
						<div class="form-check form-check-inline">
  							<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
  							<label class="form-check-label" for="inlineRadio1">Tout le monde</label>
						</div>
						<div class="form-check form-check-inline">
  							<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
  							<label class="form-check-label" for="inlineRadio2">Mes amis</label>
						</div>
						<div class="form-check form-check-inline">
  							<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3">
  							<label class="form-check-label" for="inlineRadio3">Personne</label>
						</div>
					</div>
				</div>
				div autoriser demandes amis
				<div class="d-flex justify-content-center">
					<div>
						<h5>Autoriser les demandes d'amis : </h5>
					</div>
					<div>
						<div class="form-check form-check-inline">
  							<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
  							<label class="form-check-label" for="inlineRadio1">Oui</label>
						</div>
						<div class="form-check form-check-inline">
  							<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
  							<label class="form-check-label" for="inlineRadio2">Non</label>
						</div>
					</div>
				</div>
				div autoriser messages de
				<div class="d-flex justify-content-center">
					<div>
						<h5>Autoriser les messages de : </h5>
					</div>
					<div>
						<div class="form-check form-check-inline">
  							<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
  							<label class="form-check-label" for="inlineRadio1">Tout le monde</label>
						</div>
						<div class="form-check form-check-inline">
  							<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
  							<label class="form-check-label" for="inlineRadio2">Mes amis</label>
						</div>
						<div class="form-check form-check-inline">
  							<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3">
  							<label class="form-check-label" for="inlineRadio3">Personne</label>
						</div>
					</div>
				</div>
				<div class="d-flex justify-content-end">
					<button type="submit" class="btn btn-primary align-self-end" id="bouton-fixe">Valider</button>
				</div>
			</article> -->
			
			<!-- Article pour premium -->
<!-- 			<article class="border border-dark rounded d-flex justify-content-around p-3">
				<div class="d-flex flex-column">
					<h5>Premium depuis : </h5>
					<p class="text-center">A changer</p>
				</div>
				<div class="d-flex flex-column">
					<h5>Date de début de l'abonnement actuel : </h5>
					<p class="text-center">A changer</p>
				</div>
				<div class="d-flex flex-column">
					<h5>Fin de l'abonnement le : </h5>
					<p class="text-center">A changer</p>
				</div>
				<div class="d-flex flex-column">
					<h5>Renouvellement automatique :</h5>
					<p class="text-center">A changer (OUI / NON)</p>
				</div>
				<div class="my-auto">
					<a class="btn btn-danger" href="#">Mettre fin à l'abonnement</a> 
				</div>
			</article> -->
			
			<!-- Article pour supprimer profil -->
			<article>
				<!-- Barre déroulante pour supprimer le profil -->
				<nav class="navbar navbar-dark bg-danger">
					<!-- Titre barre déroulante -->
					<h3 class="navbar-brand mx-auto">Supprimer mon profil</h3>
					<!-- Bouton pour dérouler la liste -->
					<button class="navbar-toggler" type="bouton" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapase" aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<!-- Contenu à dérouler -->
					<div class="collapse navbar-collapse bg-light" id="navbarCollapse">
						<!-- Formulaire suppression compte -->
						<form class="navbar-form" action="SupprimerProfil" method="post">
							<!-- Mot de passe -->
							<div class="form-group">
								<label for="mdp">Mot de passe</label>
								<input type="password" class="form-control" id="mdp" placeholder="Entrez votre mot de passe" name="mdp" required>
							</div>
							<!-- Question secrète + Réponse secrète (affichage sur la même ligne) -->
							<div class="form-row">
								<div class="col">
									<label for="qSecrete">Question secrète</label>
									<p><c:out value="${qSecrete}"/></p>
								</div>
								<div class="col">
									<label for="rSecrete">Réponse secrète</label>
									<input type="text" class="form-control" id="rSecrete" placeholder="Entrez votre réponse secrète" name="rSecrete" required>
								</div>
							</div>
							<!-- Validation formulaire -->
							<button type="submit" class="btn btn-danger mt-4">Confirmer</button>
						</form>
						<!-- Fin formulaire -->
					</div>
					<!-- Fin contenu à dérouler -->
				</nav>
				<!-- Fin info barre déroulante -->
			</article>
		</main>
		
		<footer>
			<%@ include file="footer.jsp"%>
		</footer>
		
		<%@ include file="script.jsp"%>
		<script src="./js/scriptProfil.js"></script>
	</body>
</html>