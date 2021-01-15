package beans;

import javax.persistence.*;

@Entity
@Table(name="EpisodeAnimeReview")
public class EpisodeAnimeReview {

	//Attributs
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ID")
		private int id;
		@Column(name = "ID_ANIME")
		private int idAnime;
		@Column(name = "ID_EPISODE")
		private int idEpisode;
		@Column(name = "NOTE")
		private int note;
		@Column(name = "COMMENTAIRE")
		private String commentaire;
		@Column(name = "UPVOTE")
		private int upVote;
	
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "Utilisateur_ID")
		private Utilisateur utilisateur;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "EpisodeAnimeSaisonVu_ID")
		private EpisodeAnimeSaisonVu episodeAnimeSaisonVu;
		
		
	//constructor
		public EpisodeAnimeReview() {
		}
	
		public EpisodeAnimeReview(int idAnime, int idEpisode) {
			this.idAnime = idAnime;
			this.idEpisode = idEpisode;
		}
		
		public EpisodeAnimeReview(int idAnime, int idEpisode, int note,
				String commentaire) {
			this.idAnime = idAnime;
			this.idEpisode = idEpisode;
			this.note = note;
			this.commentaire = commentaire;
		}
	//Methods
		@Override
		public String toString() {
			return "EpisodeAnimeReview [id=" + id + ", idAnime=" + idAnime
					+ ", idEpisode=" + idEpisode + ", note=" + note + ", commentaire=" + commentaire + "]";
		}
		
		
		public void addSmiley (int numero) {
			if(numero == 1)
				episodeAnimeSaisonVu.setSmiley1(episodeAnimeSaisonVu.getSmiley1()+1);
			else if(numero == 2)
				episodeAnimeSaisonVu.setSmiley2(episodeAnimeSaisonVu.getSmiley2()+1);
			else if(numero == 3)
				episodeAnimeSaisonVu.setSmiley3(episodeAnimeSaisonVu.getSmiley3()+1);
			else if(numero == 4)
				episodeAnimeSaisonVu.setSmiley4(episodeAnimeSaisonVu.getSmiley4()+1);
			else if(numero == 5)
				episodeAnimeSaisonVu.setSmiley5(episodeAnimeSaisonVu.getSmiley5()+1);
			else if(numero == 6)
				episodeAnimeSaisonVu.setSmiley6(episodeAnimeSaisonVu.getSmiley6()+1);
			else if(numero == 7)
				episodeAnimeSaisonVu.setSmiley7(episodeAnimeSaisonVu.getSmiley7()+1);
			else if(numero == 8)
				episodeAnimeSaisonVu.setSmiley8(episodeAnimeSaisonVu.getSmiley8()+1);
			else
				System.out.println("Erreur : veuillez choisir un numéro de smiley valide");
		}
		
		public void addUpVote() {
			this.upVote = getUpVote()+1;
		}
		
		public void supprimeUpVote() {
			this.upVote = getUpVote()-1;
		}
		
	//G&S
		public int getId() {
			return id;
		}
	
		public void setId(int id) {
			this.id = id;
		}
	
		public int getIdAnime() {
			return idAnime;
		}
	
		public void setIdAnime(int idAnime) {
			this.idAnime = idAnime;
		}
	
		public int getIdEpisode() {
			return idEpisode;
		}
	
		public void setIdEpisode(int idEpisode) {
			this.idEpisode = idEpisode;
		}
	
		public int getNote() {
			return note;
		}
	
		public void setNote(int note) {
			this.note = note;
		}
	
		public String getCommentaire() {
			return commentaire;
		}
	
		public void setCommentaire(String commentaire) {
			this.commentaire = commentaire;
		}

		public int getUpVote() {
			return upVote;
		}

		public void setUpVote(int upVote) {
			this.upVote = upVote;
		}

		public Utilisateur getUtilisateur() {
			return utilisateur;
		}

		public void setUtilisateur(Utilisateur utilisateur) {
			this.utilisateur = utilisateur;
		}

		public EpisodeAnimeSaisonVu getEpisodeAnimeSaisonVu() {
			return episodeAnimeSaisonVu;
		}

		public void setEpisodeAnimeSaisonVu(EpisodeAnimeSaisonVu episodeAnimeSaisonVu) {
			this.episodeAnimeSaisonVu = episodeAnimeSaisonVu;
		}

	

}
