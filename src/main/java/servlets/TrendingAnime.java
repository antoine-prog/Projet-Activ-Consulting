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

public class TrendingAnime extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TrendingAnime() {
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
		
		this.getServletContext().getRequestDispatcher("/recherche.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
