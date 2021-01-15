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
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import services.RequeteBDD;


public class JsonSerieReader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public JsonSerieReader() {
        super();
     
    }


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

		// Preparation des données
		//URL (avec URI) de l'API anime pointant vers un anime précis grace à l'ID
		int idSerie = Integer.parseInt(request.getParameter("idSerie"));
		
		//pour récuperer série
		HttpSession sessionHTTP = request.getSession();

		boolean booleanConnexion = false;
		boolean booleanAjout = false;
		
		if(sessionHTTP.getAttribute("id") != null) {
			booleanAjout = RequeteBDD.getSerieVu(idSerie, (int) sessionHTTP.getAttribute("id"));
			System.out.println(RequeteBDD.getSerieVu(idSerie, (int) sessionHTTP.getAttribute("id")));
			booleanConnexion = true;
		}
		
		JSONObject json2 = readJsonFromUrl("https://api.themoviedb.org/3/tv/"+idSerie+"?api_key=8bc5f304f3c448e636cf678d5d75d7e2&language=fr-FR");

		//Titre
		String titre = json2.getString("name");
		//Synopsis
		String synopsis = json2.getString("overview");
		//Image
		String image = json2.getString("poster_path");

		//Date de sortie
		String dateSortie = json2.getString("first_air_date");
		//Durée
		int duree=0;
		JSONArray dur = json2.getJSONArray("episode_run_time");
		for (int i = 0 ; i < dur.length(); i++) {
			int obj = dur.getInt(i);
			duree = obj;
		}
		//Origine
		String origine ="";
		JSONArray d = json2.getJSONArray("origin_country");
		for (int i = 0 ; i < d.length(); i++) {
			String obj = d.getString(i);
			origine += " " + obj ;
		}
		//Genre
		String genres ="";
		ArrayList<String> listGenre = new ArrayList<String>();
		JSONArray g = json2.getJSONArray("genres");
		for (int i = 0 ; i < g.length(); i++) {
			JSONObject obj = g.getJSONObject(i);
			listGenre.add(obj.getString("name"));
		}
		String lastGenres = listGenre.get(listGenre.size()-1);
		listGenre.remove(listGenre.size()-1);
		Iterator<String> itGenres = listGenre.iterator();
		while (itGenres.hasNext())
			genres += itGenres.next() + " / ";  	
		genres += lastGenres;

		request.setAttribute("dateSortie", dateSortie);
		request.setAttribute("titre", titre);
		request.setAttribute("image", image);
		request.setAttribute("synopsis", synopsis);
		request.setAttribute("origine", origine);
		request.setAttribute("duree", duree);
		request.setAttribute("genres", genres);


		//------Casting---------

		JSONObject jsonActeurs = readJsonFromUrl("https://api.themoviedb.org/3/tv/"+idSerie+"/credits?api_key=8bc5f304f3c448e636cf678d5d75d7e2&language=fr-FR");

		@SuppressWarnings("rawtypes")
		ArrayList listPersonnages = new ArrayList();
		JSONArray e = jsonActeurs.getJSONArray("cast");
		for (int i = 0 ; i < e.length(); i++) {
			@SuppressWarnings("rawtypes")
			Map attributPersonnage  = new HashMap();
			JSONObject obj = e.getJSONObject(i);
			if (obj.get("profile_path").getClass().getName().equals("java.lang.String")) {
				attributPersonnage.put("image", obj.getString("profile_path"));
				attributPersonnage.put("role", obj.getString("character"));
				attributPersonnage.put("name", obj.getString("name"));
				listPersonnages.add(attributPersonnage);
			}
		}
	    request.setAttribute("acteurs", listPersonnages); 
	    
	    //---------- json Vidéos
	    JSONObject jsonVideos = readJsonFromUrl("https://api.themoviedb.org/3/tv/"+idSerie+"/videos?api_key=8bc5f304f3c448e636cf678d5d75d7e2&language=en-US");
	    @SuppressWarnings("rawtypes")
		ArrayList listVideos = new ArrayList();
	    JSONArray jsonArrayVideos = jsonVideos.getJSONArray("results");
	    for (int i = 0 ; i < jsonArrayVideos.length(); i++) {
	    	@SuppressWarnings("rawtypes")
	    	Map attributVideo  = new HashMap();
	    	JSONObject obj = jsonArrayVideos.getJSONObject(i);
	    	attributVideo.put("video", obj.getString("key"));
	    	listVideos.add(attributVideo);
	    }
	    request.setAttribute("videos", listVideos);

	    //---------- json Recommandation
	    JSONObject jsonReco = readJsonFromUrl("https://api.themoviedb.org/3/tv/"+idSerie+"/recommendations?api_key=8bc5f304f3c448e636cf678d5d75d7e2&language=en-US");
	    @SuppressWarnings("rawtypes")
	    ArrayList listReco = new ArrayList();
	    JSONArray jsonArrayReco = jsonReco.getJSONArray("results");
	    for (int i = 0 ; i < jsonArrayReco.length(); i++) {
	    	@SuppressWarnings("rawtypes")
	    	Map attributReco  = new HashMap();
	    	JSONObject obj = jsonArrayReco.getJSONObject(i);
	    	attributReco.put("id", obj.getInt("id"));
	    	attributReco.put("image", obj.getString("poster_path"));
	    	attributReco.put("titre", obj.getString("name"));
	    	listReco.add(attributReco);
	    }
	    request.setAttribute("reco", listReco);
	    
	    request.setAttribute("idSerie", idSerie);
	    request.setAttribute("booleanAjout", booleanAjout);
	    request.setAttribute("booleanConnexion", booleanConnexion);
	    
		//On indique quelle JSP appeler pour lui fournir les données
		//La seule chose à changer est la String indiquant le chemin de la JSP
		this.getServletContext().getRequestDispatcher("/serie.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
