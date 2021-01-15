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

import beans.CompteBancaire;
import beans.Utilisateur;
import services.RequeteBDD;

/**
 * Servlet implementation class AjouterCarteCredit
 */
public class AjouterCarteCredit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterCarteCredit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String numeroCarte = request.getParameter("numeroCarte");
		String titulaireCB = request.getParameter("titulaireCB");
		int moisExpi = Integer.parseInt(request.getParameter("moisExpiration"));
		int anneeExpi = Integer.parseInt(request.getParameter("anneeExpiration"));
		int cvc = Integer.parseInt(request.getParameter("cvc"));
		
		// Récup ID utilisateur session HTTP
		HttpSession sessionHTTP = request.getSession();
		int idUtilisateur = (int) sessionHTTP.getAttribute("id");
		
		// Session Hibernate
		Configuration config = new Configuration();
		SessionFactory sessionFactory = config.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
			   	
		session.beginTransaction();
		// Récup. utilisateur
		Utilisateur user = session.get(Utilisateur.class, idUtilisateur);
		// Creation carte crédit et ajout à utilisateur
		CompteBancaire nouveauCompteBancaire = new CompteBancaire(titulaireCB, numeroCarte, cvc, moisExpi, anneeExpi);
		user.addCompteBancaire(nouveauCompteBancaire);
		session.update(user);
		session.getTransaction().commit();
		session.close();
		
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
