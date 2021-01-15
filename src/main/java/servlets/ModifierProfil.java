package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import services.RequeteBDD;

/**
 * Servlet implementation class ModifierProfil
 */
public class ModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sessionHTTP = request.getSession();
		int idUtilisateur = (int) sessionHTTP.getAttribute("id");
		
		// Récup. utilisateur
		Utilisateur user = RequeteBDD.getUtilisateur(idUtilisateur);
		
		// Envoie données à la jsp
		request.setAttribute("mail", user.geteMail());
		request.setAttribute("pays", user.getPays());
		request.setAttribute("prenom", user.getPrenom());
		request.setAttribute("nom", user.getNom());
		request.setAttribute("fuseau", user.getFuseauHoraire());
		request.setAttribute("sexe", user.getSexe());
		request.setAttribute("date", user.getDateNaissance());
		request.setAttribute("qSecrete", user.getQuestionSecrete());
		
		this.getServletContext().getRequestDispatcher("/modifierProfil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
