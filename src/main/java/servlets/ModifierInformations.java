package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Utilisateur;
import services.RequeteBDD;

/**
 * Servlet implementation class ModifierInformations
 */
public class ModifierInformations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierInformations() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mdpActuel = request.getParameter("mdpActuel");
		String nouveauMdp = request.getParameter("nouveauMdp");
		String rSecrete = request.getParameter("rSecrete");
		String mail = request.getParameter("mail");
		String pays = request.getParameter("pays");
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String fuseau = request.getParameter("fuseau");
		String sexe = request.getParameter("sexe");
		String date = request.getParameter("date");
		
		HttpSession sessionHTTP = request.getSession();
		int idUtilisateur = (int) sessionHTTP.getAttribute("id");
		
		if (RequeteBDD.verifMdp(idUtilisateur, mdpActuel) == true) {
			// Session Hibernate
			Configuration config = new Configuration();
			SessionFactory sessionFactory = config.configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
				   	
			session.beginTransaction();
			// Récup. utilisateur
			Utilisateur user = session.get(Utilisateur.class, idUtilisateur);
			if (nouveauMdp != null) {
				if (RequeteBDD.verifRSecrete(idUtilisateur, rSecrete)) {
					user.setMotDePasse(nouveauMdp);
				}
			}
			if (mail != null) {
				user.seteMail(mail);
			}
			if (pays != null) {
				user.setPays(pays);
			}
			if (prenom != null) {
				user.setPrenom(prenom);
			}
			if (nom != null) {
				user.setNom(nom);
			}
			if (fuseau != null) {
				user.setFuseauHoraire(fuseau);
			}
			if (sexe != null) {
				user.setSexe(sexe);
			}
			if (date != null) {
				user.setDateNaissance(date);
			}
			session.update(user);
			session.getTransaction().commit();
			session.close();
		}
		
		this.getServletContext().getRequestDispatcher("/ModifierProfil").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
