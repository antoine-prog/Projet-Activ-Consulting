package beans;

import javax.persistence.*;

@Entity
@Table(name="FilmReview")
public class FilmReview {

	//Attributs
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ID")
		private int id;
		@Column(name = "ID_FILM")
		private int idFilm;
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
		@JoinColumn(name = "FilmVu_ID")
		private FilmVu filmVu;
	//Constructor
		public FilmReview() {
			
		}
	
		public FilmReview(int idFilm) {
			this.idFilm = idFilm;
		}
		
		public FilmReview(int idFilm, int note, String commentaire) {
			this.idFilm = idFilm;
			this.note = note;
			this.commentaire = commentaire;
		}

	//Methods
		@Override
		public String toString() {
			return "FilmReview [id=" + id + ", idFilm=" + idFilm + ", note=" + note
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

		public int getIdFilm() {
			return idFilm;
		}

		public void setIdFilm(int idFilm) {
			this.idFilm = idFilm;
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

		public FilmVu getFilmVu() {
			return filmVu;
		}

		public void setFilmVu(FilmVu filmVu) {
			this.filmVu = filmVu;
		}



}
