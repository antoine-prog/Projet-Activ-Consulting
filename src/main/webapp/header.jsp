<!----NavBar-Début---->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<nav class="navbar">

	<a href="Home" > 
	<img src="img/logoSAJtransTV.png" alt="Logo SAJ" class="imgLogoNavBar">
	</a>


	<div>
		<ul class="ul-button-AFMS">
			<li class="li-button-AFMS"><a class="a-button-AFMS"
				href="TrendingAnime"> <span class="span-button-AFMS">Anime</span>
			</a></li>
			<li class="li-button-AFMS"><a class="a-button-AFMS"
				href="TrendingFilm"> <span class="span-button-AFMS">Film</span>
			</a></li>
			<li class="li-button-AFMS"><a class="a-button-AFMS"
				href="TrendingSerie"> <span class="span-button-AFMS">Série</span>
			</a></li>

		</ul>
	</div>

	<div class="button-recommandation" role="group" aria-label="Second group">
		<a type="button" class="btn btn-info btn-lg" href="recommandation.jsp" role="button">Recommandation</a>
	</div>



	<div class="dropdown" id="dropdown-seConnecter">
<%-- 	<c:out value="${sessionScope.id }" /> --%>
		<c:choose>
			<c:when test="${sessionScope.id != null}">
				<a class="btn btn-outline-secondar dropdown" role="button"
					id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <c:out value="${sessionScope.pseudo }" /></a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="Profil" role="button">Profil</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="Deconnexion"
						role="button">Déconnexion</a>
				</div>
			</c:when>

			<c:otherwise>
				<a class="btn btn-secondary dropdown " role="button"
					id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Se connecter </a>
				<form action="Connexion" method="post"
					class="form-inline dropdown-menu dropdown-menu">
					<div
						class="d-flex align-items-start flex-column bd-highlight align-items-end">
						<div class="d-flex align-items-start flex-column bd-highlight">
							<label for="identifiant"></label>
							<input class="form-control p-2 m-1" type="text" name="identifiant" placeholder="identifiant" />
							<label for="mdp"></label>
							<input class="form-control p-2 m-1" type="password" name="mdp" placeholder="mot de passe" />
						</div>
						<div class="d-flex mt-1 mr-sm-2">
							<button class="btn btn-outline-secondary btn-sm mr-2 btn-lg"
								type="submit">Connexion</button>
							<a class="btn btn-outline-secondary btn-sm "
								href="inscription.jsp" role="button">Inscription</a>
						</div>
					</div>
				</form>
			</c:otherwise>
		</c:choose>
	</div>


</nav>

<form class="formNav container" action="Recherche" method="get" id="formRecherche">
	<div class="form-row align-items-center ml-3 no-gutter justify-content-center">
		<div>
			<select class="btn btn-secondary dropdown-toggle mr-sm-2 px-2"
				role="button" id="selectRecherche" name="categorie">
				<option class="dropdown-item bg-dark text-light" value="0">Catégorie</option>
				<option class="dropdown-item bg-dark text-light" value="1">Anime</option>
				<option class="dropdown-item bg-dark text-light" value="2">Film</option>
				<option class="dropdown-item bg-dark text-light" value="3">Série</option>
			</select>
		</div>
		<div class="col-sm-4 col-md-6 col-lg-8">
			<input class="form-control mr-sm-2 px-2" type="search"
				placeholder="Recherche" aria-label="Search" name="search">
		</div>
		<div>
			<button class="btn btn-secondary ml-2" type="submit">Recherche</button>
		</div>
	</div>
</form>






