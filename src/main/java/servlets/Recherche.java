package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import beans.AnimeReview;
import beans.AnimeSaisonVu;
import services.RequeteBDD;

/**
 * Servlet implementation class Recherche
 */
public class Recherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Recherche() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    // Méthodes
    private static String readAll(Reader rd) throws IOException {
    	StringBuilder sb = new StringBuilder();
    	int cp;
    	while ((cp = rd.read()) != -1) {
    		sb.append((char) cp);
	    }
    	return sb.toString();
    }

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cleAPI = "8bc5f304f3c448e636cf678d5d75d7e2";
		String categorie = request.getParameter("categorie");
		String rechercheEspace = request.getParameter("search");
		String[] splitRechercheEspace = rechercheEspace.split(" ");
		String recherche = String.join("+", splitRechercheEspace);
		
		/////////////////// SEARCH SUR LES DIFFERENTES API
		///// ANIME
		if (categorie.equals("1")) {
			JSONObject jsonAnimeSearch = readJsonFromUrl("https://api.jikan.moe/v3/search/anime?q="+ recherche + "&limit=16");
			@SuppressWarnings("rawtypes")
			ArrayList listAnime = new ArrayList();
			JSONArray jsonArrayAnime = jsonAnimeSearch.getJSONArray("results");
			String noteStg = "";
			boolean noteBoolean = false;
			for (int i = 0; i < jsonArrayAnime.length(); i++) {
				@SuppressWarnings("rawtypes")
				Map attributAnime  = new HashMap();
				JSONObject obj = jsonArrayAnime.getJSONObject(i);
				attributAnime.put("titre", obj.getString("title"));
				attributAnime.put("image", obj.getString("image_url"));
				attributAnime.put("synopsis", obj.getString("synopsis"));
				attributAnime.put("idAnime", obj.getInt("mal_id"));
				listAnime.add(attributAnime);
			
////////////////////////////////////////////////////////////////////////////////////////////				
//////////////////////////A SUPPRIMER SI RECHERCHE NE MARCHE PAS///////////////////////////
//Unable to create requested service [org.hibernate.engine.jdbc.env.spi.JdbcEnvironment]//
///////////////servlets.Recherche.doGet(Recherche.java:112)//////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////
				
//			//Recuperation note
//				int idAnime = obj.getInt("mal_id");
//				
//				
//			//Preparation de la constrution de sessions
//				Configuration config = new Configuration();
//				SessionFactory sessionFactory = config.configure().buildSessionFactory();
//			//Ouverture de session
//				Session session = sessionFactory.openSession();
//			//Debut d'une transaction
//				session.beginTransaction();
//			//Contenue code
//				
//				if(RequeteBDD.getListAnimeIdBoolean(idAnime)) {
//					List <Integer> id2 = RequeteBDD.getListAnimeId(idAnime);
//					List<AnimeSaisonVu> animeAAfficher = new ArrayList<AnimeSaisonVu>();
//					for (Integer curseur: id2) {
//					 animeAAfficher.add(session.get(AnimeSaisonVu.class, curseur));
//					}
//					List<AnimeReview> listeAnimeReview = new ArrayList<AnimeReview>();
//					for(AnimeSaisonVu curseur2: animeAAfficher) {
//					listeAnimeReview.addAll(curseur2.getListAnimeReviews());
//					}
//					List<Integer> noteAnime = new ArrayList<Integer>();
//					for (int t = 0; t < listeAnimeReview.size(); t++) 
//						noteAnime.add(listeAnimeReview.get(t).getNote());	
//						double note = 0.0;
//						if (!noteAnime.isEmpty()) {
//							for(int curseur3: noteAnime) 
//								note += curseur3;
//							note = note / noteAnime.size();
//							DecimalFormat df = new DecimalFormat("0.00");
//							noteStg = df.format(note);
//							noteBoolean = true;
//						}
//				}
//				session.getTransaction().commit();	
//				//Fermeture de session
//				session.close();		
				
///////////////////////////////////////////////////////////////////////				
//////////////////////////////////////////////////////////////////////
//////FIN DE A SUPPRIMER SI RECHERCHE NE MARCHE PAS//////////////////
////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////
				
			}
			
			
			
			/////////////////// ENVOI DONNEES A LA JSP
			request.setAttribute("categorie", 1);
			request.setAttribute("rechercheAnime", listAnime);
			request.setAttribute("noteBoolean", noteBoolean);
			request.setAttribute("note", noteStg);
		}
		///// FILMS
		if (categorie.equals("2")) {
			JSONObject jsonFilmSearch = readJsonFromUrl("https://api.themoviedb.org/3/search/movie?api_key=" + cleAPI + "&query=" + recherche + "&language=fr-FR");
			@SuppressWarnings("rawtypes")
			ArrayList listFilm = new ArrayList();
			JSONArray jsonArrayFilm = jsonFilmSearch.getJSONArray("results");
			for (int i = 0; i < jsonArrayFilm.length(); i++) {
				if (i == 16) {
					break;
				}
				@SuppressWarnings("rawtypes")
				Map attributFilm  = new HashMap();
				JSONObject obj = jsonArrayFilm.getJSONObject(i);
				if (obj.get("poster_path").getClass().getName().equals("java.lang.String")) {
					attributFilm.put("titre", obj.getString("title"));
					attributFilm.put("image", obj.getString("poster_path"));
					attributFilm.put("synopsis", obj.getString("overview"));
					attributFilm.put("idFilm", obj.getInt("id"));
					listFilm.add(attributFilm);
				}
			}
			/////////////////// ENVOI DONNEES A LA JSP
			request.setAttribute("categorie", 2);
			request.setAttribute("rechercheFilm", listFilm);
		}
		///// SERIES
		if (categorie.equals("3")) {
			JSONObject jsonSerieSearch = readJsonFromUrl("https://api.themoviedb.org/3/search/tv?api_key=" + cleAPI + "&query=" + recherche + "&language=fr-FR");
			@SuppressWarnings("rawtypes")
			ArrayList listSerie = new ArrayList();
			JSONArray jsonArraySerie = jsonSerieSearch.getJSONArray("results");
			for (int i = 0; i < jsonArraySerie.length(); i++) {
				@SuppressWarnings("rawtypes")
				Map attributSerie  = new HashMap();
				JSONObject obj = jsonArraySerie.getJSONObject(i);
				if (obj.get("poster_path").getClass().getName().equals("java.lang.String")) {
					attributSerie.put("titre", obj.getString("name"));
					attributSerie.put("image", obj.getString("poster_path"));
					attributSerie.put("synopsis", obj.getString("overview"));
					attributSerie.put("idSerie", obj.getInt("id"));
					listSerie.add(attributSerie);
				}
			}
			/////////////////// ENVOI DONNEES A LA JSP
			request.setAttribute("categorie", 3);
			request.setAttribute("rechercheSerie", listSerie);
		}
		
		this.getServletContext().getRequestDispatcher("/recherche.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
