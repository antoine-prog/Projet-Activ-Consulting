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

/**
 * Servlet implementation class SupprimerProfil
 */
public class SupprimerProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerProfil() {
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
		
		// Récupération élément vérif
		String mdp = request.getParameter("mdp");
		String rSecrete = request.getParameter("rSecrete");
		
		// Session Hibernate
		Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session session = sessionFactory.openSession();
	   	
	   	session.beginTransaction();
   		Utilisateur user = session.get(Utilisateur.class, idUtilisateur);
   		session.delete(user);
   		session.getTransaction().commit();
   		session.close();
   		
   		sessionHTTP.invalidate();
   		
   		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
