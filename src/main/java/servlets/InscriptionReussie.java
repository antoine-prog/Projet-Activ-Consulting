package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.RequeteBDD;

/**
 * Servlet implementation class InscriptionReussie
 */
public class InscriptionReussie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionReussie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pseudo = request.getParameter("identifiant");
		String mdp = request.getParameter("mdp");
		
		///// Vérif si compte existe
		if (RequeteBDD.verifConnexion(pseudo, mdp) != 0) {
			///// Identifiant + ID en base dans la session pour le passer entre les pages
			int id = RequeteBDD.getID(pseudo, mdp);
			HttpSession session = request.getSession();
			session.setAttribute("pseudo", pseudo);
			session.setAttribute("id", id);
			
			this.getServletContext().getRequestDispatcher("/PostInscription").forward(request, response);
		}
		
		this.getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
