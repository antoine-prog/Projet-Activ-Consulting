package beans;

import javax.persistence.*;

@Entity
@Table(name="AnimeReview")
public class AnimeReview {

	//Attributs
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ID")
		private int id;
		@Column(name = "ID_ANIME")
		private int idAnime;
		@Column(name = "NOTE")
		private int note;
		@Column(name = "COMMENTAIRE")
		private String commentaire;
		@Column(name = "UPVOTE")
		private int upVote;
		
		//optional : ,referencedColumnName="id",nullable=false,unique=true
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "Utilisateur_ID")
		private Utilisateur utilisateur;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "AnimeSaisonVu_ID")
		private AnimeSaisonVu animeSaisonVu;
		
	//constructor
		public AnimeReview() {
		}
		
		public AnimeReview(int idAnime) {
			this.idAnime = idAnime;
		}
	
		public AnimeReview(int idAnime, int note, String commentaire) {
			this.idAnime = idAnime;
			this.note = note;
			this.commentaire = commentaire;
		}

	//Methods
		@Override
		public String toString() {
			return "AnimeReview [id=" + id + ", idAnime=" + idAnime + ", note=" + note
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
	
	
		public int getIdAnime() {
			return idAnime;
		}


		public void setIdAnime(int idAnime) {
			this.idAnime = idAnime;
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


		public AnimeSaisonVu getAnimeSaisonVu() {
			return animeSaisonVu;
		}


		public void setAnimeSaisonVu(AnimeSaisonVu animeSaisonVu) {
			this.animeSaisonVu = animeSaisonVu;
		}

	

}
