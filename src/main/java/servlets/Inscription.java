package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Utilisateur;
import services.RequeteBDD;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class Inscription
 */
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pseudo = request.getParameter("pseudo");
		String sexe = request.getParameter("sexe");
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String dateNaissance = request.getParameter("dateNaissance");
		String pays = request.getParameter("pays");
		String fuseauHoraire = request.getParameter("fuseauHoraire");
		String mdp = request.getParameter("mdp");
		String mail = request.getParameter("mail");
		String qSecrete = request.getParameter("qSecrete");
		String rSecrete = request.getParameter("rSecrete");
		
		if (pseudo == null) {
			this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
		}
		else {
			if (RequeteBDD.verifCompteExiste(pseudo) == false) {
//				String vide si champ non rempli
				if (prenom == null) {
					prenom = "";
				}		
				if (nom == null) {
					nom = "";
				}
				if (dateNaissance == null) {
					dateNaissance = "";
				}
				if (pays == null) {
				pays = "";
				}
				if (fuseauHoraire == null) {
					fuseauHoraire = "";
				}
//				Création du compte
				Utilisateur nouveauCompte = new Utilisateur(pseudo, mdp, mail, nom, prenom, sexe, pays, fuseauHoraire, dateNaissance, qSecrete, rSecrete, false, false, false, 0);
		
//				Preparation de la constrution de sessions
				Configuration config = new Configuration();
				SessionFactory sessionFactory = config.configure().buildSessionFactory();
		
//				Ouverture de session
				Session session = sessionFactory.openSession();
		
//				Debut d'une transaction
				session.beginTransaction();
//				Sauvegarde en base de l'instance
				session.save(nouveauCompte);
				session.getTransaction().commit();
//				Fermeture de session
				session.close();

//				response.getWriter().append("Compte créé").append(request.getContextPath());

				this.getServletContext().getRequestDispatcher("/InscriptionReussie?identifiant=" + pseudo + "&mdp=" + mdp).forward(request, response);

			}
			else {
				this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
