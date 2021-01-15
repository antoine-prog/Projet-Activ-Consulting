package beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="FilmVu")
public class FilmVu {

	//Attribut
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ID")
		private int id;
		@Column(name = "ID_FILM")
		private int idFilm;
		@Column(name = "TITRE")
		private String titre;
		
		@OneToMany(mappedBy = "filmVu", cascade = CascadeType.ALL, orphanRemoval = true)
		private List<FilmReview> listFilmReviews = new ArrayList<FilmReview>();
	
	//Constructeur
		public FilmVu() {
			super();
		}

		public FilmVu(int idFilm, String titre) {
			this.idFilm = idFilm;
			this.titre = titre;
	}

	//Methods
		@Override
		public String toString() {
			return "EpisodeAnimeSaison [id=" + id + ", titre=" + titre + "]";
		}

		public void addFilmReview(FilmReview filmReview) {
			this.listFilmReviews.add(filmReview);
			filmReview.setFilmVu(this);
		}
		
		public void supprimeEpisodeSerieReview(FilmReview filmReview) {
			this.listFilmReviews.remove(filmReview);
			filmReview.setFilmVu(null);
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

		public String getTitre() {
			return titre;
		}
	
		public void setTitre(String titre) {
			this.titre = titre;
		}

		public List<FilmReview> getListFilmReviews() {
			return listFilmReviews;
		}

		public void setListFilmReviews(List<FilmReview> listFilmReviews) {
			this.listFilmReviews = listFilmReviews;
		}
	
	
}
