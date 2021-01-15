package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class JsonEpisodeAnimeReader
 */
public class JsonEpisodeAnimeReader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JsonEpisodeAnimeReader() {
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
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Preparation des données
		  //URL (avec URI) de l'API anime pointant vers un anime précis grace à l'ID
		    // exemple ?idEpisode=1&idAnime=20
			int idEpisode = Integer.parseInt(request.getParameter("idEpisode"));
			int idAnime = Integer.parseInt(request.getParameter("idAnime"));

		    JSONObject json = readJsonFromUrl("https://api.jikan.moe/v3/anime/"+idAnime);
		    
		    	
		    String titre = json.getString("title");
		    String image = json.getString("image_url");
			    		
		    JSONObject json2 = readJsonFromUrl("https://api.jikan.moe/v3/anime/"+idAnime+"/episodes");
		    int index = idEpisode-1;
		    
		    if(idEpisode>1000) {
		    	json2 = readJsonFromUrl("https://api.jikan.moe/v3/anime/"+idAnime+"/episodes/11");
		    	index = idEpisode-1001;
		    }
		    else if(idEpisode>900) {
		    	json2 = readJsonFromUrl("https://api.jikan.moe/v3/anime/"+idAnime+"/episodes/10");
		    	index = idEpisode-901;
		    }
		    else if(idEpisode>800) {
		    	json2 = readJsonFromUrl("https://api.jikan.moe/v3/anime/"+idAnime+"/episodes/9");
		    	index = idEpisode-801;
		    }
		    else if(idEpisode>700) {
		    	json2 = readJsonFromUrl("https://api.jikan.moe/v3/anime/"+idAnime+"/episodes/8");
		    	index = idEpisode-701;
		    }
		    else if(idEpisode>600) {
		    	json2 = readJsonFromUrl("https://api.jikan.moe/v3/anime/"+idAnime+"/episodes/7");
		    	index = idEpisode-601;
		    }
		    else if(idEpisode>500) {
		    	json2 = readJsonFromUrl("https://api.jikan.moe/v3/anime/"+idAnime+"/episodes/6");
		    	index = idEpisode-501;
		    }
		    else if(idEpisode>400) {
		    	json2 = readJsonFromUrl("https://api.jikan.moe/v3/anime/"+idAnime+"/episodes/5");
		    	index = idEpisode-401;
		    }
		    else if(idEpisode>300) {
		    	json2 = readJsonFromUrl("https://api.jikan.moe/v3/anime/"+idAnime+"/episodes/4");
		    	index = idEpisode-301;
		    }
		    else if(idEpisode>200) {
		    	json2 = readJsonFromUrl("https://api.jikan.moe/v3/anime/"+idAnime+"/episodes/3");
		    	index = idEpisode-201;
		    }
		    else if(idEpisode>100) {
		    	json2 = readJsonFromUrl("https://api.jikan.moe/v3/anime/"+idAnime+"/episodes/2");
		    	index = idEpisode-101;
		    }
		    
		    JSONArray e = json2.getJSONArray("episodes");
		    
		    String nomEpisode = "Episodes indisponibles";
		    String urlEpisode = "";
		    boolean videoPresent = false;
		    if(e.length() !=0) {
			    nomEpisode = "cet épisode n'est pas dispnible";
			    urlEpisode = "aucune vidéo n'est disponible pour cet épisode";
			    JSONObject obj;
			    if(!e.isNull(index)) {
				    if(e.getJSONObject(index).has("title")) {
					    obj = e.getJSONObject(index);
					    nomEpisode = obj.getString("title");
				    }
				    if(e.getJSONObject(index).has("video_url")) {  
				    	obj = e.getJSONObject(index);
					    if (obj.getString("video_url")!= null) {
					    	urlEpisode = obj.getString("video_url");
					    	videoPresent = true;
					    }
				    }
			    }
		    }
		    //REQUEST
		    //Ajout des données dans la requete
		    
		    request.setAttribute("titre", titre);
		    request.setAttribute("image", image);
		    request.setAttribute("nom", nomEpisode);
		    request.setAttribute("video", urlEpisode);
		    request.setAttribute("videoPresent", videoPresent);
		    
	
		    //On indique quelle JSP appeler pour lui fournir les données
		    //La seule chose à changer est la String indiquant le chemin de la JSP
		    this.getServletContext().getRequestDispatcher("/pageEpisode.jsp").forward(request, response);	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
