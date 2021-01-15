
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Testbeans extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Testbeans() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Creation des instance
		Utilisateur testUtilisateur = new Utilisateur("premier", "mdp", "mail@mail.fr", "antoine", "saj", "Homme", "France", "GTM+1", "03/06/1994", "premier animal?", "chat", false, false, false, 0);
		Utilisateur testUtilisateur2 = new Utilisateur("deuxieme", "mdp2", "monmail@monmail.fr", "eniotna", "jas", "Homme", "France", "GTM+2", "06/03/1990", "premier animal?", "chien", false, false, false, 0);
		AnimeReview testAnimeReview = new AnimeReview(20,7,"c'est pas mal");
		AnimeReview testAnimeReview2 = new AnimeReview(20,9,"trop bien");
		AnimeReview testAnimeReview3 = new AnimeReview(20,9,"trop bien");
		AnimeSaisonVu testAnimeSaisonVu = new AnimeSaisonVu(20, "naruto");
		AnimeSaisonVu testAnimeSaisonVu2 = new AnimeSaisonVu(15, "autre");
		CompteBancaire testCompteBancaire = new CompteBancaire("ANTOINE", "4444444444444444", 444, 4, 4);
		CompteBancaire testCompteBancaire2 = new CompteBancaire("PHILIPPE", "8888888888888888", 888, 8, 8);
		
		//Jonctions
		testUtilisateur.addlistAmis(testUtilisateur2);
		
		testUtilisateur.addAnimeReview(testAnimeReview);
		testUtilisateur.addAnimeReview(testAnimeReview2);
		testUtilisateur2.addAnimeReview(testAnimeReview3);
		
		testUtilisateur.addCompteBancaire(testCompteBancaire);
		testUtilisateur.addCompteBancaire(testCompteBancaire2);
		
		testUtilisateur.addAnimeSaisonVu(testAnimeSaisonVu);
		testUtilisateur2.addAnimeSaisonVu(testAnimeSaisonVu);
		testUtilisateur.addAnimeSaisonVu(testAnimeSaisonVu2);
		
		testAnimeSaisonVu.addAnimeReview(testAnimeReview);
		testAnimeSaisonVu.addAnimeReview(testAnimeReview2);
		testAnimeSaisonVu2.addAnimeReview(testAnimeReview3);
		
		
		//Preparation de la constrution de sessions
		Configuration config = new Configuration();
		SessionFactory sessionFactory = config.configure().buildSessionFactory();
		
		//Ouverture de session
		Session session = sessionFactory.openSession();
		
		//Debut d'une transaction
		session.beginTransaction();
		
		//Sauvegarde en base des 2 instances
		session.save(testUtilisateur);
		session.save(testUtilisateur2);
		session.save(testAnimeSaisonVu);
		session.save(testAnimeSaisonVu2);
		session.getTransaction().commit();
		
		
		//Fermeture de session
		session.close();
		
		response.getWriter().append("Stockage réalisé grace au servlet: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

