package beans;

import javax.persistence.*;

@Entity
@Table(name="EpisodeSerieReview")
public class EpisodeSerieReview {

	//Attributs
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ID")
		private int id;
		@Column(name = "ID_SERIE")
		private int idSerie;
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
		@JoinColumn(name = "EpisodeSerieSaisonVu_ID")
		private EpisodeSerieSaisonVu episodeSerieSaisonVu;
		
		
	//Constructor
		public EpisodeSerieReview() {
		}
		
		public EpisodeSerieReview(int idSerie, int idEpisode) {
			this.idSerie = idSerie;
			this.idEpisode = idEpisode;
		}
	
		public EpisodeSerieReview(int idSerie, int idEpisode, int note, String commentaire) {
			this.idSerie = idSerie;
			this.idEpisode = idEpisode;
			this.note = note;
			this.commentaire = commentaire;
		}
	
	//Methods	
		@Override
		public String toString() {
			return "EpisodeSerieReview [id=" + id + ", idSerie=" + idSerie
					+ ", idEpisode=" + idEpisode + ", note=" + note + ", commentaire=" + commentaire + "]";
		}
	
		public void addSmiley (int numero) {
			if(numero == 1)
				episodeSerieSaisonVu.setSmiley1(episodeSerieSaisonVu.getSmiley1()+1);
			else if(numero == 2)
				episodeSerieSaisonVu.setSmiley2(episodeSerieSaisonVu.getSmiley2()+1);
			else if(numero == 3)
				episodeSerieSaisonVu.setSmiley3(episodeSerieSaisonVu.getSmiley3()+1);
			else if(numero == 4)
				episodeSerieSaisonVu.setSmiley4(episodeSerieSaisonVu.getSmiley4()+1);
			else if(numero == 5)
				episodeSerieSaisonVu.setSmiley5(episodeSerieSaisonVu.getSmiley5()+1);
			else if(numero == 6)
				episodeSerieSaisonVu.setSmiley6(episodeSerieSaisonVu.getSmiley6()+1);
			else if(numero == 7)
				episodeSerieSaisonVu.setSmiley7(episodeSerieSaisonVu.getSmiley7()+1);
			else if(numero == 8)
				episodeSerieSaisonVu.setSmiley8(episodeSerieSaisonVu.getSmiley8()+1);
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
	
		public int getIdSerie() {
			return idSerie;
		}

		public void setIdSerie(int idSerie) {
			this.idSerie = idSerie;
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

		public EpisodeSerieSaisonVu getEpisodeSerieSaisonVu() {
			return episodeSerieSaisonVu;
		}

		public void setEpisodeSerieSaisonVu(EpisodeSerieSaisonVu episodeSerieSaisonVu) {
			this.episodeSerieSaisonVu = episodeSerieSaisonVu;
		}

}
