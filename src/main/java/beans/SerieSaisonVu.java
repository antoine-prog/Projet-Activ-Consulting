package beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="SerieSaisonVu")
public class SerieSaisonVu {

	//Attribut
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ID")
		private int id;
		@Column(name = "ID_SERIE")
		private int idSerie;
		@Column(name = "TITRE")
		private String titre;

		@OneToMany(mappedBy = "serieSaisonVu", cascade = CascadeType.ALL, orphanRemoval = true)
		private List<SerieReview> listSerieReviews = new ArrayList<SerieReview>();
	
	//Constructor
		public SerieSaisonVu() {
				super();
			}
		
		public SerieSaisonVu(int idSerie, String titre) {
			this.idSerie = idSerie;
			this.titre = titre;
	}

	//Methods
		@Override
		public String toString() {
			return "EpisodeAnimeSaison [id=" + id + ", idSerie" + idSerie + ", titre=" + titre + "]";
		}

		public void addSerieReview(SerieReview serieReview) {
			this.listSerieReviews.add(serieReview);
			serieReview.setSerieSaisonVu(this);
		}
		
		public void supprimeSerieReview(SerieReview serieReview) {
			this.listSerieReviews.remove(serieReview);
			serieReview.setSerieSaisonVu(null);
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

		public String getTitre() {
			return titre;
		}

		public void setTitre(String titre) {
			this.titre = titre;
		}

}

	

