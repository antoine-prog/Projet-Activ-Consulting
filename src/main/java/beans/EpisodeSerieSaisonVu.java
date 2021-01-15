package beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="EpisodeSerieSaisonVu")
public class EpisodeSerieSaisonVu {

	//Attributs
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ID")
		private int id;
		@Column(name = "ID_EPISODE_SERIE")
		private int idEpisodeSerie;
		@Column(name = "ID_SERIE")
		private int idSerie;
		@Column(name = "TITRE")
		private String titre;
		@Column(name = "smiley_1")
		private int smiley1;
		@Column(name = "smiley_2")
		private int smiley2;
		@Column(name = "smiley_3")
		private int smiley3;
		@Column(name = "smiley_4")
		private int smiley4;
		@Column(name = "smiley_5")
		private int smiley5;
		@Column(name = "smiley_6")
		private int smiley6;
		@Column(name = "smiley_7")
		private int smiley7;
		@Column(name = "smiley_8")
		private int smiley8;

		@OneToMany(mappedBy = "episodeSerieSaisonVu", cascade = CascadeType.ALL, orphanRemoval = true)
		private List<EpisodeSerieReview> listEpisodeSerieReviews = new ArrayList<EpisodeSerieReview>();
		
	//Constructor
	
		public EpisodeSerieSaisonVu() {
			super();
		}

		public EpisodeSerieSaisonVu(int idEpisodeSerie,int idSerie, String titre) {
			this.idEpisodeSerie = idEpisodeSerie;
			this.idSerie = idSerie;
			this.titre = titre;
	}
		
	//Methods
		@Override
		public String toString() {
			return "EpisodeAnimeSaison [id=" + id + ", idEpisodeSerie" + idEpisodeSerie + ", titre=" + titre + "]";
		}

		public void addEpisodeSerieReview(EpisodeSerieReview episodeSerieReview) {
			this.listEpisodeSerieReviews.add(episodeSerieReview);
			episodeSerieReview.setEpisodeSerieSaisonVu(this);
		}
		
		public void supprimeEpisodeSerieReview(EpisodeSerieReview episodeSerieReview) {
			this.listEpisodeSerieReviews.remove(episodeSerieReview);
			episodeSerieReview.setEpisodeSerieSaisonVu(null);
		}
		
	//G&S
		public int getId() {
		return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public int getIdEpisodeSerie() {
			return idEpisodeSerie;
		}

		public void setIdEpisodeSerie(int idEpisodeSerie) {
			this.idEpisodeSerie = idEpisodeSerie;
		}

		public int getIdSerie() {
			return idSerie;
		}

		public void setIdSerie(int idSerie) {
			this.idSerie = idSerie;
		}

		public String getTitre() {
			return titre;
		}
		
		public void setTitre(String titre) {
			this.titre = titre;
		}

		public int getSmiley1() {
			return smiley1;
		}

		public void setSmiley1(int smiley1) {
			this.smiley1 = smiley1;
		}

		public int getSmiley2() {
			return smiley2;
		}

		public void setSmiley2(int smiley2) {
			this.smiley2 = smiley2;
		}

		public int getSmiley3() {
			return smiley3;
		}

		public void setSmiley3(int smiley3) {
			this.smiley3 = smiley3;
		}

		public int getSmiley4() {
			return smiley4;
		}

		public void setSmiley4(int smiley4) {
			this.smiley4 = smiley4;
		}

		public int getSmiley5() {
			return smiley5;
		}

		public void setSmiley5(int smiley5) {
			this.smiley5 = smiley5;
		}

		public int getSmiley6() {
			return smiley6;
		}

		public void setSmiley6(int smiley6) {
			this.smiley6 = smiley6;
		}

		public int getSmiley7() {
			return smiley7;
		}

		public void setSmiley7(int smiley7) {
			this.smiley7 = smiley7;
		}

		public int getSmiley8() {
			return smiley8;
		}

		public void setSmiley8(int smiley8) {
			this.smiley8 = smiley8;
		}

		public List<EpisodeSerieReview> getListEpisodeSerieReviews() {
			return listEpisodeSerieReviews;
		}

		public void setListEpisodeSerieReviews(List<EpisodeSerieReview> listEpisodeSerieReviews) {
			this.listEpisodeSerieReviews = listEpisodeSerieReviews;
		}
		
}
