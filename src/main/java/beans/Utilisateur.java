package beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Utilisateur")

public class Utilisateur {

	//Attribut
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ID")
		private int id;
		@Column(name = "PSEUDONYME")
		private String pseudonyme;
		@Column(name = "MOT_DE_PASSE")
		private String motDePasse;
		@Column(name = "E_MAIL")
		private String eMail;
		@Column(name = "NOM")
		private String nom;
		@Column(name = "PRENOM")
		private String prenom;
		@Column(name = "SEXE")
		private String sexe;
		@Column(name = "PAYS")
		private String pays;
		@Column(name = "FUSEAU_HORAIRE")
		private String fuseauHoraire;
		@Column(name = "DATE_NAISSANCE")
		private String dateNaissance;
		@Column(name = "QUESTION_SECRETE")
		private String questionSecrete;
		@Column(name = "REPONSE_SECRETE")
		private String reponseSecrete;
		@Column(name = "PREMIUM")
		private boolean premium;
		@Column(name = "PREMIUM_PLUS")
		private boolean premiumPlus;
		@Column(name = "IMAGE")
		private boolean image;
		@Column(name = "POINTS_CONTRIB")
		private int pointsContrib;
		
		//AMIS/////////////////////////////////////////////////
		@ManyToMany(cascade = {CascadeType.ALL})
		@JoinTable(
				name = "Utilisateur_Relationship",
				joinColumns = {@JoinColumn(name = "Utilisateur_ID")},
				inverseJoinColumns = {@JoinColumn(name = "Utilisateur_Amis_ID")}
				)
		private List<Utilisateur> listAmis = new ArrayList<Utilisateur>();

		//CARTE BLEUE/////////////////////////////////////////////////
		@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.EAGER)
		@JoinColumn(name="Utilisateur_ID")
		private List<CompteBancaire> listComptesBancaires = new ArrayList<CompteBancaire>();

		//ANIME/////////////////////////////////////////////////
		@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
		private List<AnimeReview> listAnimeReviews = new ArrayList<AnimeReview>();
		
		@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
		@JoinColumn(name="Utilisateur_ID")
		private List<AnimeSaisonVu> listAnimesSaisonVus = new ArrayList<AnimeSaisonVu>();
		
		//EPISODES ANIME/////////////////////////////////////////////////
		@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
		private List<EpisodeAnimeReview> listEpisodeAnimeReviews = new ArrayList<EpisodeAnimeReview>();
		
		@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
		@JoinColumn(name="Utilisateur_ID")
		private List<EpisodeAnimeSaisonVu> listEpisodesAnimeSaisonVus = new ArrayList<EpisodeAnimeSaisonVu>();
		
		//SERIE/////////////////////////////////////////////////
		@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
		private List<SerieReview> listSerieReviews = new ArrayList<SerieReview>();
		
		@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
		@JoinColumn(name="Utilisateur_ID")
		private List<SerieSaisonVu> listSeriesSaisonVus = new ArrayList<SerieSaisonVu>();
		
		//EPISODES SERIE/////////////////////////////////////////////////
		@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
		private List<EpisodeSerieReview> listEpisodeSerieReviews = new ArrayList<EpisodeSerieReview>();
		
		@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
		@JoinColumn(name="Utilisateur_ID")
		private List<EpisodeSerieSaisonVu> listEpisodesSerieSaisonVus = new ArrayList<EpisodeSerieSaisonVu>();
		
		//FILM/////////////////////////////////////////////////
			
		@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
		private List<FilmReview> listFilmReviews = new ArrayList<FilmReview>();
		
		@OneToMany(cascade = {CascadeType.ALL})
		@JoinColumn(name="Utilisateur_ID")
		private List<FilmVu> listFilmsVus = new ArrayList<FilmVu>();
		
	
		
	//Constructor
		public Utilisateur() {
			super();
		}

		public Utilisateur(String pseudonyme, String motDePasse, String eMail, String nom, String prenom,
					String sexe, String pays, String fuseauHoraire, String dateNaissance, String questionSecrete,
					String reponseSecrete, boolean premium, boolean premiumPlus, boolean image, int pointsContrib) {
				this.pseudonyme = pseudonyme;
				this.motDePasse = motDePasse;
				this.eMail = eMail;
				this.nom = nom;
				this.prenom = prenom;
				this.sexe = sexe;
				this.pays = pays;
				this.fuseauHoraire = fuseauHoraire;
				this.dateNaissance = dateNaissance;
				this.questionSecrete = questionSecrete;
				this.reponseSecrete = reponseSecrete;
				this.premium = premium;
				this.premiumPlus = premiumPlus;
				this.image = image;
				this.pointsContrib = pointsContrib;
			}

	//Methods		
		@Override
		public String toString() {
			return "Utilisateur [id=" + id + ", pseudonyme=" + pseudonyme + ", motDePasse=" + motDePasse + ", eMail="
					+ eMail + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", pays=" + pays
					+ ", fuseauHoraire=" + fuseauHoraire + ", dateNaissance=" + dateNaissance + ", questionSecrete="
					+ questionSecrete + ", reponseSecrete=" + reponseSecrete + ", premium=" + premium + ", premiumPlus="
					+ premiumPlus +  ", image=" + image + "]";
		}

		//AMIS methods/////////////////////////////////////////////////
		public void addlistAmis(Utilisateur utilisateurAmi) {
			this.listAmis.add(utilisateurAmi);
			utilisateurAmi.getListAmis().add(this);
		}
		public void supprimerlistAmis(Utilisateur utilisateurAmi) {
			this.listAmis.remove(utilisateurAmi);
			utilisateurAmi.getListAmis().remove(this);
		}
		
		//CB methods/////////////////////////////////////////////////
		public void addCompteBancaire(CompteBancaire compteBancaire) {
			this.listComptesBancaires.add(compteBancaire);
		}
		public void supprimerCompteBancaire(CompteBancaire compteBancaire) {
			this.listComptesBancaires.remove(compteBancaire);
		}
		
		//ANIME methods///////////////////////////////////////////////// rajouter review dans class animesaisonVu grace a ces methodes ?
		public void addAnimeSaisonVu(AnimeSaisonVu animeSaisonVu) {
			this.listAnimesSaisonVus.add(animeSaisonVu);
		}
		public void supprimerAnimeSaisonVU(AnimeSaisonVu animeSaisonVu) {
			this.listAnimesSaisonVus.remove(animeSaisonVu);
		}
		public void addAnimeReview(AnimeReview animeReview) {
			this.listAnimeReviews.add(animeReview);
			animeReview.setUtilisateur(this);
		}
		public void supprimeAnimeReview(AnimeReview animeReview) {
			this.listAnimeReviews.remove(animeReview);
			animeReview.setUtilisateur(null);
		}
		
		//EPISODES ANIME methods/////////////////////////////////////////////////
		public void addEpisodeAnimeSaisonVu(EpisodeAnimeSaisonVu episodeAnimeSaisonVu) {
			this.listEpisodesAnimeSaisonVus.add(episodeAnimeSaisonVu);
		}
		public void supprimerEpisodeAnimeSaisonVu(EpisodeAnimeSaisonVu episodeAnimeSaisonVu) {
			this.listEpisodesAnimeSaisonVus.remove(episodeAnimeSaisonVu);
		}
		public void addEpisodeAnimeReview(EpisodeAnimeReview episodeAnimeReview) {
			this.listEpisodeAnimeReviews.add(episodeAnimeReview);
			episodeAnimeReview.setUtilisateur(this);
		}
		public void supprimeEpisodeAnimeReview(EpisodeAnimeReview episodeAnimeReview) {
			this.listEpisodeAnimeReviews.remove(episodeAnimeReview);
			episodeAnimeReview.setUtilisateur(null);
		}
		
		//SERIE methods/////////////////////////////////////////////////
		public void addSerieSaisonVu(SerieSaisonVu serieSaisonVu) {
			this.listSeriesSaisonVus.add(serieSaisonVu);
		}
		public void supprimerSerieSaisonVu(SerieSaisonVu serieSaisonVu) {
			this.listSeriesSaisonVus.remove(serieSaisonVu);
		}
		public void addSerieReview(SerieReview serieReview) {
			this.listSerieReviews.add(serieReview);
			serieReview.setUtilisateur(this);
		}
		public void supprimeSerieReview(SerieReview serieReview) {
			this.listSerieReviews.remove(serieReview);
			serieReview.setUtilisateur(null);
		}
		
		//EPISODES SERIE methods/////////////////////////////////////////////////
		public void addEpisodeSerieSaisonVu(EpisodeSerieSaisonVu episodeSerieSaisonVu) {
			this.listEpisodesSerieSaisonVus.add(episodeSerieSaisonVu);
		}
		public void supprimerEpisodeSerieSaisonVu(EpisodeSerieSaisonVu episodeSerieSaisonVu) {
			this.listEpisodesSerieSaisonVus.remove(episodeSerieSaisonVu);
		}
		public void addEpisodeSerieReview(EpisodeSerieReview episodeSerieReview) {
			this.listEpisodeSerieReviews.add(episodeSerieReview);
			episodeSerieReview.setUtilisateur(this);
		}
		public void supprimeEpisodeSerieReview(EpisodeSerieReview episodeSerieReview) {
			this.listEpisodeSerieReviews.remove(episodeSerieReview);
			episodeSerieReview.setUtilisateur(null);
		}
		
		//FILM methods/////////////////////////////////////////////////
		public void addFilmVu(FilmVu filmVu) {
			this.listFilmsVus.add(filmVu);
		}
		public void supprimerFilm(FilmVu filmVu) {
			this.listFilmsVus.remove(filmVu);
		}
		public void addFilmReview(FilmReview filmReview) {
			this.listFilmReviews.add(filmReview);
			filmReview.setUtilisateur(this);
		}
		public void supprimeFilmReview(FilmReview filmReview) {
			this.listFilmReviews.remove(filmReview);
			filmReview.setUtilisateur(null);
		}
		
	//G&S
		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getPseudonyme() {
			return pseudonyme;
		}


		public void setPseudonyme(String pseudonyme) {
			this.pseudonyme = pseudonyme;
		}


		public String getMotDePasse() {
			return motDePasse;
		}


		public void setMotDePasse(String motDePasse) {
			this.motDePasse = motDePasse;
		}


		public String geteMail() {
			return eMail;
		}


		public void seteMail(String eMail) {
			this.eMail = eMail;
		}


		public String getNom() {
			return nom;
		}


		public void setNom(String nom) {
			this.nom = nom;
		}


		public String getPrenom() {
			return prenom;
		}


		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}


		public String getSexe() {
			return sexe;
		}


		public void setSexe(String sexe) {
			this.sexe = sexe;
		}


		public String getPays() {
			return pays;
		}


		public void setPays(String pays) {
			this.pays = pays;
		}


		public String getFuseauHoraire() {
			return fuseauHoraire;
		}


		public void setFuseauHoraire(String fuseauHoraire) {
			this.fuseauHoraire = fuseauHoraire;
		}


		public String getDateNaissance() {
			return dateNaissance;
		}


		public void setDateNaissance(String dateNaissance) {
			this.dateNaissance = dateNaissance;
		}


		public String getQuestionSecrete() {
			return questionSecrete;
		}


		public void setQuestionSecrete(String questionSecrete) {
			this.questionSecrete = questionSecrete;
		}


		public String getReponseSecrete() {
			return reponseSecrete;
		}


		public void setReponseSecrete(String reponseSecrete) {
			this.reponseSecrete = reponseSecrete;
		}

		public boolean isPremium() {
			return premium;
		}

		public void setPremium(boolean premium) {
			this.premium = premium;
		}

		public boolean isPremiumPlus() {
			return premiumPlus;
		}

		public void setPremiumPlus(boolean premiumPlus) {
			this.premiumPlus = premiumPlus;
		}
		
		public boolean isImage() {
			return image;
		}

		public void setImage(boolean image) {
			this.image = image;
		}
		
		public int getPointsContrib() {
			return pointsContrib;
		}

		public void setPointsContrib(int pointsContrib) {
			this.pointsContrib = pointsContrib;
		}

		public List<Utilisateur> getListAmis() {
			return listAmis;
		}

		public void setListAmis(List<Utilisateur> listAmis) {
			this.listAmis = listAmis;
		}

		public List<CompteBancaire> getListComptesBancaires() {
			return listComptesBancaires;
		}


		public void setListComptesBancaires(List<CompteBancaire> listComptesBancaires) {
			this.listComptesBancaires = listComptesBancaires;
		}

		public List<AnimeReview> getListAnimeReviews() {
			return listAnimeReviews;
		}

		public void setListAnimeReviews(List<AnimeReview> listAnimeReviews) {
			this.listAnimeReviews = listAnimeReviews;
		}

		public List<AnimeSaisonVu> getListAnimesSaisonVus() {
			return listAnimesSaisonVus;
		}

		public void setListAnimesSaisonVus(List<AnimeSaisonVu> listAnimesSaisonVus) {
			this.listAnimesSaisonVus = listAnimesSaisonVus;
		}

		public List<EpisodeAnimeReview> getListEpisodeAnimeReviews() {
			return listEpisodeAnimeReviews;
		}

		public void setListEpisodeAnimeReviews(List<EpisodeAnimeReview> listEpisodeAnimeReviews) {
			this.listEpisodeAnimeReviews = listEpisodeAnimeReviews;
		}

		public List<EpisodeAnimeSaisonVu> getListEpisodesAnimeSaisonVus() {
			return listEpisodesAnimeSaisonVus;
		}

		public void setListEpisodesAnimeSaisonVus(List<EpisodeAnimeSaisonVu> listEpisodesAnimeSaisonVus) {
			this.listEpisodesAnimeSaisonVus = listEpisodesAnimeSaisonVus;
		}

		public List<SerieReview> getListSerieReviews() {
			return listSerieReviews;
		}

		public void setListSerieReviews(List<SerieReview> listSerieReviews) {
			this.listSerieReviews = listSerieReviews;
		}

		public List<SerieSaisonVu> getListSeriesSaisonVus() {
			return listSeriesSaisonVus;
		}

		public void setListSeriesSaisonVus(List<SerieSaisonVu> listSeriesSaisonVus) {
			this.listSeriesSaisonVus = listSeriesSaisonVus;
		}

		public List<EpisodeSerieReview> getListEpisodeSerieReviews() {
			return listEpisodeSerieReviews;
		}

		public void setListEpisodeSerieReviews(List<EpisodeSerieReview> listEpisodeSerieReviews) {
			this.listEpisodeSerieReviews = listEpisodeSerieReviews;
		}

		public List<EpisodeSerieSaisonVu> getListEpisodesSerieSaisonVus() {
			return listEpisodesSerieSaisonVus;
		}

		public void setListEpisodesSerieSaisonVus(List<EpisodeSerieSaisonVu> listEpisodesSerieSaisonVus) {
			this.listEpisodesSerieSaisonVus = listEpisodesSerieSaisonVus;
		}

		public List<FilmReview> getListFilmReviews() {
			return listFilmReviews;
		}

		public void setListFilmReviews(List<FilmReview> listFilmReviews) {
			this.listFilmReviews = listFilmReviews;
		}

		public List<FilmVu> getListFilmsVus() {
			return listFilmsVus;
		}

		public void setListFilmsVus(List<FilmVu> listFilmsVus) {
			this.listFilmsVus = listFilmsVus;
		}

	
}
