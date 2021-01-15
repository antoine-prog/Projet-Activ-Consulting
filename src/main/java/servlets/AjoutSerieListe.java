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

import beans.SerieSaisonVu;
import beans.Utilisateur;

public class AjoutSerieListe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjoutSerieListe() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		int idSerie = Integer.parseInt(request.getParameter("idSerie"));
		String titre = request.getParameter("titreSerie");
		int IDUtilisateur = (int) session.getAttribute("id");
		Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session sessionHibernate = sessionFactory.openSession();
	   	
	   	sessionHibernate.beginTransaction();
	   	SerieSaisonVu serie = new SerieSaisonVu(idSerie, titre);
	   	Utilisateur utilisateur = sessionHibernate.get(Utilisateur.class, IDUtilisateur);
	   	utilisateur.addSerieSaisonVu(serie);
	   	sessionHibernate.update(utilisateur);
	   	sessionHibernate.getTransaction().commit();
	   	
   		sessionHibernate.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
