package services;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.sun.org.apache.xpath.internal.compiler.PsuedoNames;

import beans.AnimeReview;
import beans.AnimeSaisonVu;
import beans.Utilisateur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequeteBDD {
	
	
	// Méthodes
	public static String verifPseudo(String pseudo) {
		// Init. resultat
		String resultat = "";
	   	// Init. session Hibernate
	   	Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session session = sessionFactory.openSession();
	   	// Si pas pas de pseudo
	   	if (pseudo == null) {
	   		resultat="Pseudo disponible";
	   	}
	   	else {
	   		Query query = session.createQuery("FROM Utilisateur U WHERE U.pseudonyme = :pseudo");
	   		query.setParameter("pseudo", pseudo);
	   		List<Utilisateur> liste = query.list();
	   		//
	   		if(liste.size() == 0){
	   			resultat="Pseudo disponible";
	   		}
	   		else {
	   			resultat="Pseudo déjà pris";
	   		}
	   	}
		session.close();
		return resultat;
	}
	
	
	public static int verifConnexion(String pseudo, String mdp) {
		// Init. session Hibernate
		int result;
	   	Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session session = sessionFactory.openSession();
	   	Query query = session.createQuery("FROM Utilisateur U WHERE U.pseudonyme = :pseudo AND U.motDePasse = :mdp");
   		query.setParameter("pseudo", pseudo);
   		query.setParameter("mdp", mdp);
   		result = query.list().size();
   		session.close();
   		return result;
   	}
	
	
	public static int getID(String pseudo, String mdp) {
		// Init. session Hibernate
		int result;
	   	Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session session = sessionFactory.openSession();
	   	Query query = session.createQuery("FROM Utilisateur U WHERE U.pseudonyme = :pseudo AND U.motDePasse = :mdp");
   		query.setParameter("pseudo", pseudo);
   		query.setParameter("mdp", mdp);
   		List listeResultat = query.list();
   		Utilisateur user = (Utilisateur) listeResultat.get(0);
   		result = user.getId();
   		session.close();
   		return result;
   	}
	
	
	public static boolean getAnimeVu(int idAnime, int idUtilisateur) {
		Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session session = sessionFactory.openSession();
	   	Query query = session.createQuery("FROM AnimeSaisonVu A WHERE A.idAnime = :idAnime AND Utilisateur_ID = :id");
   		query.setParameter("idAnime", idAnime);
   		query.setParameter("id", idUtilisateur);
   		int result = query.list().size();
   		session.close();
   		if (result != 0) {
   			return true;
   		}
   		return false;
	}
	
	public static boolean getFilmVu(int idFilm, int idUtilisateur) {
		Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session session = sessionFactory.openSession();
	   	Query query = session.createQuery("FROM FilmVu A WHERE A.idFilm = :idFilm AND Utilisateur_ID = :id");
   		query.setParameter("idFilm", idFilm);
   		query.setParameter("id", idUtilisateur);
   		int result = query.list().size();
   		session.close();
   		if (result != 0) {
   			return true;
   		}
   		return false;
	}
	public static boolean getSerieVu(int idSerie, int idUtilisateur) {
		Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session session = sessionFactory.openSession();
	   	Query query = session.createQuery("FROM SerieSaisonVu A WHERE A.idSerie = :idSerie AND Utilisateur_ID = :id");
   		query.setParameter("idSerie", idSerie);
   		query.setParameter("id", idUtilisateur);
   		int result = query.list().size();
   		session.close();
   		if (result != 0) {
   			return true;
   		}
   		return false;
	}
	
	
	public static Utilisateur getUtilisateur(int idUtilisateur) {
		Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session session = sessionFactory.openSession();
   		Utilisateur user = session.get(Utilisateur.class, idUtilisateur);
   		session.close();
   		
   		return user;
	}
	
	public static boolean verifMdp(int idUtilisateur, String mdp) {
		Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session session = sessionFactory.openSession();
	   	Query query = session.createQuery("FROM Utilisateur U WHERE U.id = :id AND U.motDePasse = :mdp");
   		query.setParameter("id", idUtilisateur);
   		query.setParameter("mdp", mdp);
   		int result = query.list().size();
   		session.close();
   		if (result != 0) {
   			return true;
   		}
   		return false;
	}
	
	
	public static boolean verifRSecrete(int idUtilisateur, String rSecrete) {
		Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session session = sessionFactory.openSession();
	   	Query query = session.createQuery("FROM Utilisateur U WHERE U.id = :id AND U.reponseSecrete = :rSecrete");
   		query.setParameter("id", idUtilisateur);
   		query.setParameter("rSecrete", rSecrete);
   		int result = query.list().size();
   		session.close();
   		if (result != 0) {
   			return true;
   		}
   		return false;
	}
	
	
	public static boolean verifAnimeReview(int idUtilisateur, int idAnime) {
		Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session session = sessionFactory.openSession();
	   	Query query = session.createQuery("FROM AnimeReview WHERE ID_ANIME = :idAnime AND Utilisateur_ID = :idUtilisateur");
   		query.setParameter("idUtilisateur", idUtilisateur);
   		query.setParameter("idAnime", idAnime);
   		int result = query.list().size();
   		session.close();
   		if (result != 0) {
   			return true;
   		}
   		return false;
	}
	
	public static boolean verifFilmReview(int idUtilisateur, int idFilm) {
		Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session session = sessionFactory.openSession();
	   	Query query = session.createQuery("FROM FilmReview WHERE ID_FILM = :idFilm AND Utilisateur_ID = :idUtilisateur");
   		query.setParameter("idUtilisateur", idUtilisateur);
   		query.setParameter("idFilm", idFilm);
   		int result = query.list().size();
   		session.close();
   		if (result != 0) {
   			return true;
   		}
   		return false;
	}
	
	public static boolean verifSerieReview(int idUtilisateur, int idSerie) {
		Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session session = sessionFactory.openSession();
	   	Query query = session.createQuery("FROM SerieReview WHERE ID_SERIE = :idSerie AND Utilisateur_ID = :idUtilisateur");
   		query.setParameter("idUtilisateur", idUtilisateur);
   		query.setParameter("idSerie", idSerie);
   		int result = query.list().size();
   		session.close();
   		if (result != 0) {
   			return true;
   		}
   		return false;
	}
	
	
	@SuppressWarnings("deprecation")
	public static AnimeReview getAnimeReview(int idUtilisateur, int idAnime) {
		Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session session = sessionFactory.openSession();
	   	Query query = session.createQuery("SELECT COMMENTAIRE, NOTE, UPVOTE FROM animereview WHERE ID_ANIME = :idAnime AND Utilisateur_ID = :idUtilisateur");
   		query.setParameter("idUtilisateur", idUtilisateur);
   		query.setParameter("idAnime", idAnime);
   		List resultInterm = query.list();
   		AnimeReview result = (AnimeReview) resultInterm.get(0);
   		session.close();
   		return result;
	}
	
	@SuppressWarnings("deprecation")
	public static AnimeReview getFilmReview(int idUtilisateur, int idFilm) {
		Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session session = sessionFactory.openSession();
	   	Query query = session.createQuery("SELECT COMMENTAIRE, NOTE, UPVOTE FROM filmreview WHERE ID_FILM = :idFilm AND Utilisateur_ID = :idUtilisateur");
   		query.setParameter("idUtilisateur", idUtilisateur);
   		query.setParameter("idFilm", idFilm);
   		List resultInterm = query.list();
   		AnimeReview result = (AnimeReview) resultInterm.get(0);
   		session.close();
   		return result;
	}
	
	@SuppressWarnings("deprecation")
	public static AnimeReview getSerieReview(int idUtilisateur, int idSerie) {
		Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session session = sessionFactory.openSession();
	   	Query query = session.createQuery("SELECT COMMENTAIRE, NOTE, UPVOTE FROM filmreview WHERE ID_SERIE = :idSerie AND Utilisateur_ID = :idUtilisateur");
   		query.setParameter("idUtilisateur", idUtilisateur);
   		query.setParameter("idSerie", idSerie);
   		List resultInterm = query.list();
   		AnimeReview result = (AnimeReview) resultInterm.get(0);
   		session.close();
   		return result;
	}
	
	public static int getAnimeId(int idUtilisateur, int idAnime) {
		Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session session = sessionFactory.openSession();
	   	Query query = session.createQuery("FROM AnimeSaisonVu WHERE ID_ANIME = :idAnime AND Utilisateur_ID = :idUtilisateur");
   		query.setParameter("idUtilisateur", idUtilisateur);
   		query.setParameter("idAnime", idAnime);
   		List resultInterm = query.list();
   		AnimeSaisonVu anime = (AnimeSaisonVu) resultInterm.get(0);
   		int result = anime.getId();
   		session.close();
   		return result;
	}
	
	public static List<Integer> getListAnimeId(int idAnime) {
		List <Integer> result = new ArrayList<Integer>();
		Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session session = sessionFactory.openSession();
	   	Query query = session.createQuery("FROM AnimeSaisonVu WHERE ID_ANIME = :idAnime");
   		query.setParameter("idAnime", idAnime);
   		List<AnimeSaisonVu> resultInterm = query.list();
   		
   		for(AnimeSaisonVu c : resultInterm) {
   			result.add(c.getId());
   		}
   		session.close();
   		return result;
	}
	
	public static boolean getAnimeIdBoolean(int idUtilisateur, int idAnime) {
		boolean result = false;
		Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session session = sessionFactory.openSession();
	   	Query query = session.createQuery("FROM AnimeSaisonVu WHERE ID_ANIME = :idAnime AND Utilisateur_ID = :idUtilisateur");
   		query.setParameter("idUtilisateur", idUtilisateur);
   		query.setParameter("idAnime", idAnime);
   		List resultInterm = query.list();
   		if(!resultInterm.isEmpty()) {
   		result = true;
   		}
   		session.close();
   		return result;
	}
	
	public static boolean getListAnimeIdBoolean(int idAnime) {
		boolean result = false;
		Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session session = sessionFactory.openSession();
	   	Query query = session.createQuery("FROM AnimeSaisonVu WHERE ID_ANIME = :idAnime");
   		query.setParameter("idAnime", idAnime);
   		List<AnimeSaisonVu> resultInterm = query.list();
   		if(!resultInterm.isEmpty()) {
   			result = true;
   		}
   		session.close();
   		return result;
	}

	public static boolean verifCompteExiste(String pseudo) {
		Configuration config = new Configuration();
	   	SessionFactory sessionFactory = config.configure().buildSessionFactory();
	   	Session session = sessionFactory.openSession();
	   	Query query = session.createQuery("FROM Utilisateur U WHERE U.pseudonyme = :pseudo");
   		query.setParameter("pseudo", pseudo);
   		int resultInt = query.list().size();
   		session.close();
   		if (resultInt != 0) {
   			return true;
   		}
   		return false;
	}
	
}
