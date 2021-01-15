package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.json.JSONException;
import org.json.JSONObject;

import beans.AnimeSaisonVu;
import beans.Utilisateur;

public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Home() {
        super();
        
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
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Pour Les trendy anime
		JSONObject jsonAnimeSearch = readJsonFromUrl("https://private-anon-6267a9dc27-jikan.apiary-proxy.com/v3/top/anime");
		@SuppressWarnings("rawtypes")
		ArrayList listAnime = new ArrayList();
		JSONArray jsonArrayAnime = jsonAnimeSearch.getJSONArray("top");
		for (int i = 0; i < 4; i++) {
			@SuppressWarnings("rawtypes")
			Map attributAnime  = new HashMap();
			JSONObject obj = jsonArrayAnime.getJSONObject(i);
			attributAnime.put("titre", obj.getString("title"));
			attributAnime.put("image", obj.getString("image_url"));
			attributAnime.put("idAnime", obj.getInt("mal_id"));
			JSONObject jsonAnimeSearch2 = readJsonFromUrl("https://api.jikan.moe/v3/anime/"+obj.getInt("mal_id"));
			String synopsis = jsonAnimeSearch2.getString("synopsis");
			attributAnime.put("synopsis", synopsis);
			listAnime.add(attributAnime);
		}
		/////////////////// ENVOI DONNEES A LA JSP
		request.setAttribute("categorie", 1);
		request.setAttribute("rechercheAnime", listAnime);
		
		
		
	
	// API KEY pour Série et Film !!!!!!!!!!!
		String cleAPI = "8bc5f304f3c448e636cf678d5d75d7e2";
	
		//Pour les trendy Film 
		JSONObject jsonFilmSearch = readJsonFromUrl("https://api.themoviedb.org/3/trending/movie/week?api_key=" + cleAPI + "&language=fr-FR");
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
		request.setAttribute("categorie", 2);
		request.setAttribute("rechercheFilm", listFilm);
		
		//Pour les trendy série
		JSONObject jsonSerieSearch = readJsonFromUrl("https://api.themoviedb.org/3/trending/tv/week?api_key=" + cleAPI + "&language=fr-FR");
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
		request.setAttribute("categorie", 3);
		request.setAttribute("rechercheSerie", listSerie);
		
		
		//Appel de la page index
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
