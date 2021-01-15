package beans;

import javax.persistence.*;

@Entity
@Table(name="SerieReview")
public class SerieReview {

	//Attributs
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ID")
		private int id;
		@Column(name = "ID_SERIE")
		private int idSerie;
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
		@JoinColumn(name = "SerieSaisonVu_ID")
		private SerieSaisonVu serieSaisonVu;
		
	//Constructor	
		public SerieReview() {
		}
	
		public SerieReview(int idSerie) {
			this.idSerie = idSerie;
		}
		
		public SerieReview(int idSerie, int note, String commentaire) {
			this.idSerie = idSerie;
			this.note = note;
			this.commentaire = commentaire;
		}
	
	//Methods	
		@Override
		public String toString() {
			return "SerieReview [id=" + id + ", idSerie=" + idSerie + ", note=" + note
					+ ", commentaire=" + commentaire + "]";
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

		public SerieSaisonVu getSerieSaisonVu() {
			return serieSaisonVu;
		}

		public void setSerieSaisonVu(SerieSaisonVu serieSaisonVu) {
			this.serieSaisonVu = serieSaisonVu;
		}

	


}
