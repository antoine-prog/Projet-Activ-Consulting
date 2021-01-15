package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import beans.Utilisateur;
import services.Fichier;
import services.RequeteBDD;
import services.UploadForm;

/**
 * Servlet implementation class Profil
 */
public class Profil extends HttpServlet {
	public static final String CHEMIN      = "chemin";

    public static final String ATT_FICHIER = "fichier";
    public static final String ATT_FORM    = "form";

    public static final String VUE         = "/profil.jsp";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sessionHTTP = request.getSession();
		int idUtilisateur = (int) sessionHTTP.getAttribute("id");
		// Récup utilisateur pour afficher son profil
		Utilisateur user = RequeteBDD.getUtilisateur(idUtilisateur);
		
		// Envoi données à la page
		request.setAttribute("pseudo", user.getPseudonyme());
		request.setAttribute("points", user.getPointsContrib());
		request.setAttribute("mail", user.geteMail());
		request.setAttribute("prenom", user.getPrenom());
		request.setAttribute("nom", user.getNom());
		request.setAttribute("sexe", user.getSexe());
		request.setAttribute("date", user.getDateNaissance());
		request.setAttribute("nationalite", user.getPays());
		request.setAttribute("fuseau", user.getFuseauHoraire());
		request.setAttribute("qSecrete", user.getQuestionSecrete());
		if (user.isImage() == false) {
			request.setAttribute("avatar", false);
		}
		else {
			request.setAttribute("avatar", true);
		}
		request.setAttribute("nombre_CB", user.getListComptesBancaires().size());
		if (user.getListComptesBancaires().size() != 0) {
			List listeComptes = new ArrayList();
			Map attributCB  = new HashMap();
			for (int i = 0; i < user.getListComptesBancaires().size(); i++) {
				attributCB.put("code", user.getListComptesBancaires().get(i).getCodeBancaire());
				attributCB.put("titulaire", user.getListComptesBancaires().get(i).getTitulaire());
				attributCB.put("id", user.getListComptesBancaires().get(i).getId());
				attributCB.put("numero", i);
				listeComptes.add(attributCB);
			}
			request.setAttribute("comptes", listeComptes);
		}
		else {
			request.setAttribute("code_banc", "Pas de compte bancaire");
			request.setAttribute("titulaire", "Pas de titulaire");
		}
		
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
         * Lecture du paramètre 'chemin' passé à la servlet via la déclaration
         * dans le web.xml
         */
        String chemin = this.getServletConfig().getInitParameter( CHEMIN );

        /* Préparation de l'objet formulaire */
        UploadForm form = new UploadForm();

        HttpSession sessionHTTP = request.getSession();
	   	int idUtilisateur = (int) sessionHTTP.getAttribute("id");
	   	
        /* Traitement de la requête et récupération du bean en résultant */
        Fichier fichier = form.enregistrerFichier( request, chemin, idUtilisateur );

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_FICHIER, fichier );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

}
