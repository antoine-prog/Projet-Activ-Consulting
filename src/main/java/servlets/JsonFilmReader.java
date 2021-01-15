package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import services.RequeteBDD;

/**
 * Servlet implementation class JsonFilmReader
 */
public class JsonFilmReader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonFilmReader() {
        super();
        // TODO Auto-generated constructor stub
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idFilm = Integer.parseInt(request.getParameter("idFilm"));
		
		//pour récuperer l'Film
		HttpSession sessionHTTP = request.getSession();

		boolean booleanConnexion = false;
		boolean booleanAjout = false;
		
		
		if(sessionHTTP.getAttribute("id") != null) {
			booleanAjout = RequeteBDD.getFilmVu(idFilm, (int) sessionHTTP.getAttribute("id"));
			booleanConnexion = true;
		}
		
		//////////////// json Général
		JSONObject jsonGeneral = readJsonFromUrl("https://api.themoviedb.org/3/movie/"+idFilm+"?api_key=8bc5f304f3c448e636cf678d5d75d7e2&language=fr-FR");
	    String titre = jsonGeneral.getString("original_title");
	    String image_path = jsonGeneral.getString("poster_path");
	    String image = "https://image.tmdb.org/t/p/w500" + image_path;
//	    Boucle pour les tags
	    String genres ="";
	    ArrayList<String> listGenre = new ArrayList<String>();
	    JSONArray d = jsonGeneral.getJSONArray("genres");
	    for (int i = 0 ; i < d.length(); i++) {
	    	JSONObject obj = d.getJSONObject(i);
	    	listGenre.add(obj.getString("name"));
	    }
	    String lastGenres = listGenre.get(listGenre.size()-1);
	    listGenre.remove(listGenre.size()-1);
	    Iterator<String> itGenres = listGenre.iterator();
	    while (itGenres.hasNext())
	    	genres += itGenres.next() + " / ";  	
	    genres += lastGenres;
//	    
	    String dateSortie = jsonGeneral.getString("release_date");
	    String synopsis = jsonGeneral.getString("overview");
//	    Boucle pour les prod countries
	    ArrayList<String> listeOrigines = new ArrayList<String>();     
	    JSONArray jsonArrayProdCount = (JSONArray) jsonGeneral.get("production_countries");
	    if (jsonArrayProdCount != null) {
	    	int lenOrigine = jsonArrayProdCount.length();
	    	for (int i = 0; i < lenOrigine; i++) {
	    		JSONObject listePays = (JSONObject) jsonArrayProdCount.get(i);
	    		if (listePays != null) {
	    			listeOrigines.add(listePays.getString("name"));
	    		}
	    	}
	    }
//
	    int duree = jsonGeneral.getInt("runtime");
	    
	    //////////////// json Acteurs
	    JSONObject jsonActeurs = readJsonFromUrl("https://api.themoviedb.org/3/movie/"+idFilm+"/credits?api_key=8bc5f304f3c448e636cf678d5d75d7e2&language=fr-FR");
	    @SuppressWarnings("rawtypes")
		ArrayList listPersonnages = new ArrayList();
	    JSONArray jsonArrayActeurs = jsonActeurs.getJSONArray("cast");
	    for (int i = 0 ; i < jsonArrayActeurs.length(); i++) {
	    	@SuppressWarnings("rawtypes")
	    	Map attributPersonnage  = new HashMap();
	    	JSONObject obj = jsonArrayActeurs.getJSONObject(i);
	    	if (obj.get("profile_path").getClass().getName().equals("java.lang.String")) {
	    		attributPersonnage.put("image", obj.getString("profile_path"));
	    		attributPersonnage.put("role", obj.getString("character"));
	    		attributPersonnage.put("name", obj.getString("name"));
	    		listPersonnages.add(attributPersonnage);
	    	}
	    }
	    
	    //////////////// json Vidéos
	    JSONObject jsonVideos = readJsonFromUrl("https://api.themoviedb.org/3/movie/"+idFilm+"/videos?api_key=8bc5f304f3c448e636cf678d5d75d7e2&language=fr-FR");
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
	    
	    ////////////////json Vidéos
	    JSONObject jsonReco = readJsonFromUrl("https://api.themoviedb.org/3/movie/"+idFilm+"/recommendations?api_key=8bc5f304f3c448e636cf678d5d75d7e2&language=fr-FR");
	    @SuppressWarnings("rawtypes")
	    ArrayList listReco = new ArrayList();
	    JSONArray jsonArrayReco = jsonReco.getJSONArray("results");
	    for (int i = 0 ; i < jsonArrayReco.length(); i++) {
	    	@SuppressWarnings("rawtypes")
	    	Map attributReco  = new HashMap();
	    	JSONObject obj = jsonArrayReco.getJSONObject(i);
	    	if (obj.get("poster_path").getClass().getName().equals("java.lang.String")) {
	    		attributReco.put("id", obj.getInt("id"));
	    		attributReco.put("image", obj.getString("poster_path"));
	    		attributReco.put("titre", obj.getString("title"));
	    		listReco.add(attributReco);
	    	}
	    }
	    
	    //REQUEST
	    //Ajout des données dans la requete
	    /////////// json général
	    request.setAttribute("idFilm", idFilm);
	    request.setAttribute("titre", titre);
	    request.setAttribute("image", image);
	    request.setAttribute("genres", genres);
	    request.setAttribute("dateSortie", dateSortie);
	    request.setAttribute("synopsis", synopsis);
	    request.setAttribute("listeOrigines", listeOrigines);
	    request.setAttribute("durée", duree);
	    /////////// json acteurs
	    request.setAttribute("acteurs", listPersonnages);
	    /////////// json videos
	    request.setAttribute("videos", listVideos);
	    /////////// json reco
	    request.setAttribute("reco", listReco);
	    
	    //request boolean pour ajouter le film
	    request.setAttribute("booleanAjout", booleanAjout);
	    request.setAttribute("booleanConnexion", booleanConnexion);

	    //On indique quelle JSP appeler pour lui fournir les données
	    //La seule chose à changer est la String indiquant le chemin de la JSP
	    this.getServletContext().getRequestDispatcher("/film.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
