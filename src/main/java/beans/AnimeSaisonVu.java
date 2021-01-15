package beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="AnimeSaisonVu")
public class AnimeSaisonVu {

	//Attributs
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ID")
		private int id;
		@Column(name = "ID_ANIME")
		private int idAnime;
		@Column(name = "TITRE")
		private String titre;
		
		@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//		@JoinTable(
//				name = "AnimeSaisonVu_AnimeReview",
//				joinColumns = {@JoinColumn(name = "AnimeSaisonVu_ID")},
//				inverseJoinColumns = {@JoinColumn(name = "AnimeReview_ID_ANIME")}
//				)
		private List<AnimeReview> listAnimeReviews = new ArrayList<AnimeReview>();
		
	//Constructor
	
		public AnimeSaisonVu() {
			super();
		}

		public AnimeSaisonVu(int idAnime, String titre) {
			this.idAnime = idAnime;
			this.titre = titre;
		}

	//Methods

		@Override
		public String toString() {
			return "AnimeSaison [id=" + id + ", idAnime" + idAnime + ", titre=" + titre + "]";
		}

		public void addAnimeReview(AnimeReview animeReview) {
			this.listAnimeReviews.add(animeReview);
			animeReview.setAnimeSaisonVu(this);
		}
		
		public void supprimeAnimeReview(AnimeReview animeReview) {
			this.listAnimeReviews.remove(animeReview);
			animeReview.setAnimeSaisonVu(null);
		}

	//G&S
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}



		public String getTitre() {
			return titre;
		}



		public void setTitre(String titre) {
			this.titre = titre;
		}



		public int getIdAnime() {
			return idAnime;
		}



		public void setIdAnime(int idAnime) {
			this.idAnime = idAnime;
		}

		public List<AnimeReview> getListAnimeReviews() {
			return listAnimeReviews;
		}

		public void setListAnimeReviews(List<AnimeReview> listAnimeReviews) {
			this.listAnimeReviews = listAnimeReviews;
		}
		
		

	
}
