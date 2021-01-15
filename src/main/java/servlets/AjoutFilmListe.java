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

import beans.FilmVu;
import beans.Utilisateur;

/**
 * Servlet implementation class AjoutFilmListe
 */
public class AjoutFilmListe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutFilmListe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				HttpSession session = request.getSession();
				int idFilm = Integer.parseInt(request.getParameter("idFilm"));
				String titre = request.getParameter("titreFilm");
				int IDUtilisateur = (int) session.getAttribute("id");
				Configuration config = new Configuration();
			   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
			   	Session sessionHibernate = sessionFactory.openSession();
			   	
			   	sessionHibernate.beginTransaction();
			   	FilmVu film = new FilmVu(idFilm, titre);
			   	Utilisateur utilisateur = sessionHibernate.get(Utilisateur.class, IDUtilisateur);
			   	utilisateur.addFilmVu(film);
			   	sessionHibernate.update(utilisateur);
			   	sessionHibernate.getTransaction().commit();
			   	
		   		sessionHibernate.close();
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
