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

import beans.AnimeSaisonVu;
import beans.Utilisateur;

public class AjoutAnimeListe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjoutAnimeListe() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int idAnime = Integer.parseInt(request.getParameter("idAnime"));
		String titre = request.getParameter("titreAnime");
		
		HttpSession session = request.getSession();
		int IDUtilisateur = (int) session.getAttribute("id");
		Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session sessionHibernate = sessionFactory.openSession();
	   	
	   	sessionHibernate.beginTransaction();
	   	AnimeSaisonVu anime = new AnimeSaisonVu(idAnime, titre);
	   	Utilisateur utilisateur = sessionHibernate.get(Utilisateur.class, IDUtilisateur);
	   	utilisateur.addAnimeSaisonVu(anime);
	   	sessionHibernate.update(utilisateur);
	   	sessionHibernate.getTransaction().commit();
	   	
   		sessionHibernate.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
