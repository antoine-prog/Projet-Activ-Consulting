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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.JSONArray;
import org.json.JSONObject;

import beans.AnimeReview;
import beans.AnimeSaisonVu;
import beans.CompteBancaire;
import beans.FilmVu;
import beans.SerieSaisonVu;
import beans.Utilisateur;
import services.RequeteBDD;

/**
 * Servlet implementation class MaListe
 */
public class MaListe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaListe() {
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
		
		// Session Hibernate
		Configuration config = new Configuration();
		SessionFactory sessionFactory = config.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
					   	
		// Récup. utilisateur
		Utilisateur user = session.get(Utilisateur.class, idUtilisateur);
		//////////////// ANIME
		List<AnimeSaisonVu> listeAnime = user.getListAnimesSaisonVus();
		List listeAnimeReview = new ArrayList();
		for (int i = 0; i < listeAnime.size(); i++) {
			Map attributAnime = new HashMap();
			attributAnime.put("idAnime", listeAnime.get(i).getIdAnime());
			attributAnime.put("titre", listeAnime.get(i).getTitre());
			if (RequeteBDD.verifAnimeReview(idUtilisateur, listeAnime.get(i).getIdAnime()) == true) {
//				attributAnime.put("note", RequeteBDD.getAnimeReview(idUtilisateur, listeAnime.get(i).getIdAnime()).getNote());
//				attributAnime.put("commentaire", RequeteBDD.getAnimeReview(idUtilisateur, listeAnime.get(i).getIdAnime()).getCommentaire());
				listeAnimeReview.add(attributAnime);
			}
			else {
				attributAnime.put("note", "Non noté");
				attributAnime.put("commentaire", "Pas de review");
				listeAnimeReview.add(attributAnime);
			}
		}
		//////////////// FILM
		List<FilmVu> listeFilm = user.getListFilmsVus();
		List listeFilmReview = new ArrayList();
		for (int i = 0; i < listeFilm.size(); i++) {
			Map attributFilm = new HashMap();
			attributFilm.put("idAnime", listeFilm.get(i).getIdFilm());
			attributFilm.put("titre", listeFilm.get(i).getTitre());
			if (RequeteBDD.verifFilmReview(idUtilisateur, listeFilm.get(i).getIdFilm()) == true) {
			//	attributFilm.put("note", RequeteBDD.getFilmReview(idUtilisateur, listeFilm.get(i).getIdFilm()).getNote());
			//	attributFilm.put("commentaire", RequeteBDD.getFilmReview(idUtilisateur, listeFilm.get(i).getIdFilm()).getCommentaire());
				listeFilmReview.add(attributFilm);
			}
			else {
				attributFilm.put("note", "Non noté");
				attributFilm.put("commentaire", "Pas de review");
				listeFilmReview.add(attributFilm);
			}
		}
		////////////////FILM
		List<SerieSaisonVu> listeSerie = user.getListSeriesSaisonVus();
		List listeSerieReview = new ArrayList();
		for (int i = 0; i < listeSerie.size(); i++) {
			Map attributSerie = new HashMap();
			attributSerie.put("idAnime", listeSerie.get(i).getIdSerie());
			attributSerie.put("titre", listeSerie.get(i).getTitre());
			if (RequeteBDD.verifSerieReview(idUtilisateur, listeSerie.get(i).getIdSerie()) == true) {
			//	attributSerie.put("note", RequeteBDD.getSerieReview(idUtilisateur, listeSerie.get(i).getIdSerie()).getNote());
			//	attributSerie.put("commentaire", RequeteBDD.getSerieReview(idUtilisateur, listeSerie.get(i).getIdSerie()).getCommentaire());
				listeSerieReview.add(attributSerie);
			}
			else {
				attributSerie.put("note", "Non noté");
				attributSerie.put("commentaire", "Pas de review");
				listeSerieReview.add(attributSerie);
			}
		}
		session.close();
		
		request.setAttribute("listeAnimeReview", listeAnimeReview);
		request.setAttribute("listeFilmReview", listeFilmReview);
		request.setAttribute("listeSerieReview", listeSerieReview);
		
		this.getServletContext().getRequestDispatcher("/maListe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
