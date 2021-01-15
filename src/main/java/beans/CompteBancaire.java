package beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="CompteBancaire")

public class CompteBancaire {

	//Attributs
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ID")
		private int id;
		@Column(name = "TITULAIRE")
		private String titulaire;
		@Column(name = "CODE_BANCAIRE")
		private String CodeBancaire;
		@Column(name = "CVC")
		private int cvc;
		@Column(name = "MOIS_EXPIRATION")
		private int moisExpiration;
		@Column(name = "ANNEE_EXPIRATION")
		private int anneeExpiration;
		
	//Constructor
		public CompteBancaire() {
			super();
		}
		
		public CompteBancaire(String titulaire, String codeBancaire, int cvc, int moisExpiration,
				int anneeExpiration) {
			this.titulaire = titulaire;
			this.CodeBancaire = codeBancaire;
			this.cvc = cvc;
			this.moisExpiration = moisExpiration;
			this.anneeExpiration = anneeExpiration;
		}
			
	//Methods
		@Override
		public String toString() {
		return "CompteBancaire [id=" + id + ", titulaire=" + titulaire + ", CodeBancaire=" + CodeBancaire
				+ ", cvc=" + cvc + ", moisExpiration=" + moisExpiration + ", anneeExpiration=" + anneeExpiration
				+ "]";
		}

	//G&S
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitulaire() {
			return titulaire;
		}

		public void setTitulaire(String titulaire) {
			this.titulaire = titulaire;
		}

		public String getCodeBancaire() {
			return CodeBancaire;
		}

		public void setCodeBancaire(String codeBancaire) {
			CodeBancaire = codeBancaire;
		}

		public int getCvc() {
			return cvc;
		}

		public void setCvc(int cvc) {
			this.cvc = cvc;
		}

		public int getMoisExpiration() {
			return moisExpiration;
		}

		public void setMoisExpiration(int moisExpiration) {
			this.moisExpiration = moisExpiration;
		}

		public int getAnneeExpiration() {
			return anneeExpiration;
		}

		public void setAnneeExpiration(int anneeExpiration) {
			this.anneeExpiration = anneeExpiration;
		}
	
}
