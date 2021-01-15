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


public class TrendingSerie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public TrendingSerie() {
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
	
		String cleAPI = "8bc5f304f3c448e636cf678d5d75d7e2";
		
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
