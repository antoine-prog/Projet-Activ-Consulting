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

/**
 * Servlet implementation class TrendingFilm
 */
public class TrendingFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrendingFilm() {
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
		
		String cleAPI = "8bc5f304f3c448e636cf678d5d75d7e2";
		
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
		
		this.getServletContext().getRequestDispatcher("/recherche.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
