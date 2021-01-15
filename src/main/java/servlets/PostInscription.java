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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class PostInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PostInscription() {
        super();
       
    }
    
    //Pour API
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

		//--------- json Recommandation Anime
		int idAnime = 269;
		JSONObject json3 = readJsonFromUrl("https://api.jikan.moe/v3/anime/"+idAnime+"/recommendations");	
    	
	    @SuppressWarnings("rawtypes")
		ArrayList listRecommandation = new ArrayList();
	    JSONArray f = json3.getJSONArray("recommendations");
	    	for (int i = 0 ; i < f.length(); i++) {
	    		//combien de recommandation seront affiché
	    		if(i<10) {
		    		@SuppressWarnings("rawtypes")
					Map attributRecommandation  = new HashMap();
		    		JSONObject obj = f.getJSONObject(i);
		    		attributRecommandation.put("id", obj.getInt("mal_id"));
		    		attributRecommandation.put("image", obj.getString("image_url"));
		    		attributRecommandation.put("title", obj.getString("title"));
		    		listRecommandation.add(attributRecommandation);
	    		}
	    	}
	    	request.setAttribute("recoAnime", listRecommandation);
	    	
	    //----------- json Recomandation de Film
		    JSONObject jsonRecoFilm = readJsonFromUrl("https://api.themoviedb.org/3/movie/550/recommendations?api_key=8bc5f304f3c448e636cf678d5d75d7e2&language=fr-FR");
		    @SuppressWarnings("rawtypes")
		    ArrayList listRecoFilm = new ArrayList();
		    JSONArray jsonArrayRecoFilm = jsonRecoFilm.getJSONArray("results");
		    for (int i = 0 ; i < jsonArrayRecoFilm.length(); i++) {
		    	@SuppressWarnings("rawtypes")
		    	Map attributReco  = new HashMap();
		    	JSONObject obj = jsonArrayRecoFilm.getJSONObject(i);
		    	attributReco.put("id", obj.getInt("id"));
		    	attributReco.put("image", obj.getString("poster_path"));
		    	attributReco.put("titre", obj.getString("title"));
		    	listRecoFilm.add(attributReco);
		    }
		    request.setAttribute("recoFilm", listRecoFilm);
		
		//---------- json Recommandation Série Last Dance
	    JSONObject jsonReco = readJsonFromUrl("https://api.themoviedb.org/3/tv/79525/recommendations?api_key=8bc5f304f3c448e636cf678d5d75d7e2&language=en-US");
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
	    request.setAttribute("recoSerie", listReco);
		
		
		this.getServletContext().getRequestDispatcher("/postInscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
