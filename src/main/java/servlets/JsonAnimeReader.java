package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
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

//import services.JsonReader;

public class JsonAnimeReader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public JsonAnimeReader() {
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
    
    
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	    
		 
		//Preparation des données
		  //URL (avec URI) de l'API anime pointant vers un anime précis grace à l'ID
			int idAnime = Integer.parseInt(request.getParameter("idAnime"));
			
			
			//pour récuperer l'anime
			HttpSession sessionHTTP = request.getSession();
		///////////////////////////////////
		//	int idUtilisateur = (int) sessionHTTP.getAttribute("id");
			
			boolean booleanConnexion = false;
			boolean booleanAjout = false;			

			if(sessionHTTP.getAttribute("id") != null) {
				System.out.println("coucou Antoine");
				booleanAjout = RequeteBDD.getAnimeVu(idAnime, (int) sessionHTTP.getAttribute("id"));	
				booleanConnexion = true;					
			}

			JSONObject json = readJsonFromUrl("https://api.jikan.moe/v3/anime/"+idAnime);
		    
		    int episodes = json.getInt("episodes"); //Integer.toString()
		    String titre = json.getString("title");
		    String image = json.getString("image_url"); 
		    String type = json.getString("type");
		    boolean film = false;
		    	if(type.equals("TV"))
		    		type = "Série animé";
		    	else if(type.equals("Movie")) {
			    	type = "Film d'animation";
			    	film = true;
		    	}
		    String duration = json.getString("duration"); // à traduire
		    boolean airing = json.getBoolean("airing");
		   
		    String synopsis = json.getString("synopsis"); // à traduire
		    JSONObject aired = json.getJSONObject("aired");
		    JSONObject prop = aired.getJSONObject("prop");
		    JSONObject from = prop.getJSONObject("from");
		    JSONObject to = prop.getJSONObject("to");
		    int jDebut = from.getInt("day");
		    int mDebut = from.getInt("month");
		    int aDebut = from.getInt("year");
		    
		    int jFin = 0;
		    int mFin = 0;
		    int aFin = 0;
		    if(!to.isNull("day")) {
			   jFin = to.getInt("day");
			   mFin = to.getInt("month");
			   aFin = to.getInt("year");
		    }  
		    
		    String studios ="";
			    ArrayList<String> listStudios = new ArrayList<String>();
			    JSONArray c = json.getJSONArray("studios");
			    	for (int i = 0 ; i < c.length(); i++) {
			    		JSONObject obj = c.getJSONObject(i);
			    		listStudios.add(obj.getString("name"));
			    	}
			    	boolean studioPresent = false;
			    	if(listStudios.size() !=0) {
				    	studioPresent = true;
				    	String lastStudios = listStudios.get(listStudios.size()-1);
				    	listStudios.remove(listStudios.size()-1);
				    	Iterator<String> itStudios = listStudios.iterator();
				    	while (itStudios.hasNext())
				    		studios += itStudios.next() + ", ";  	
				    	studios += lastStudios;
			    	}
			   
			String genres ="";
		    ArrayList<String> listGenre = new ArrayList<String>();
		    JSONArray d = json.getJSONArray("genres");
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
		   
		    JSONObject json2 = readJsonFromUrl("https://api.jikan.moe/v3/anime/"+idAnime+"/characters_staff");	
		    	
		    @SuppressWarnings("rawtypes")
			ArrayList listPersonnages = new ArrayList();
		    JSONArray e = json2.getJSONArray("characters");
		    	for (int i = 0 ; i < e.length(); i++) {
		    		if(i<10) {
		    		@SuppressWarnings("rawtypes")
					Map attributPersonnage  = new HashMap();
		    		JSONObject obj = e.getJSONObject(i);
		    		attributPersonnage.put("image", obj.getString("image_url"));
		    		attributPersonnage.put("name", obj.getString("name"));
		    		listPersonnages.add(attributPersonnage);
		    		}
		    	}
		    	
		    	String trailer ="";
		    	boolean trailerPresent = false;
		    	if(!json.isNull("trailer_url")) {
		    		trailer = json.getString("trailer_url");
		    		trailerPresent = true;
		    	}
		    	
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
			    	
///////OUVERTURE BDD /////////
			    	//Preparation de la constrution de sessions
					Configuration config = new Configuration();
					SessionFactory sessionFactory = config.configure().buildSessionFactory();
					
					//Ouverture de session
					Session session = sessionFactory.openSession();
					
					//Debut d'une transaction
					session.beginTransaction();
			////////////////////////////////////////////////////////////////////////////////
					if(RequeteBDD.getListAnimeIdBoolean(idAnime)) {
						List <Integer> id2 = RequeteBDD.getListAnimeId(idAnime);
						
						List<AnimeSaisonVu> animeAAfficher = new ArrayList<AnimeSaisonVu>();
						for (Integer curseur: id2) {
						 animeAAfficher.add(session.get(AnimeSaisonVu.class, curseur));
						}
					
						List<AnimeReview> listeAnimeReview = new ArrayList<AnimeReview>();
						for(AnimeSaisonVu curseur2: animeAAfficher) {
						listeAnimeReview.addAll(curseur2.getListAnimeReviews());
						}
						
						@SuppressWarnings("unused")
						List<Integer> listeIDUser = new ArrayList<Integer>();
						@SuppressWarnings("rawtypes")
						List reviewAEnvoyer = new ArrayList();
						List<Integer> noteAnime = new ArrayList<Integer>();
						for (int i = 0; i < listeAnimeReview.size(); i++) {
							@SuppressWarnings("rawtypes")
							Map attributReview = new HashMap();
							attributReview.put("commentaire", listeAnimeReview.get(i).getCommentaire());
							attributReview.put("note", listeAnimeReview.get(i).getNote());
							attributReview.put("id", listeAnimeReview.get(i).getUtilisateur().getId());
//							noteAnime.add(listeAnimeReview.get(i).getNote());
							attributReview.put("pseudonyme", listeAnimeReview.get(i).getUtilisateur().getPseudonyme());
							attributReview.put("imageBoolean", listeAnimeReview.get(i).getUtilisateur().isImage());
							reviewAEnvoyer.add(attributReview);
						}
						
							boolean noteBoolean = false;
//							double note = 0.0;
//							String noteStg = "";
//							if (!noteAnime.isEmpty()) {
//								for(int curseur3: noteAnime) {
//									note += curseur3;
//									System.out.println(note);
//								}
//								System.out.println("Addition de toutes les notes : " + note);
//								note = note / noteAnime.size();
//								System.out.println("valeur taille liste note : " + noteAnime.size());
//								System.out.println("total : " + note);
//								DecimalFormat df = new DecimalFormat("0.00");
//								noteStg = df.format(note);
//								System.out.println("total arrondie (2 chiffres après virgule): " + noteStg);
//								noteBoolean = true;
//							}
//							
						
							request.setAttribute("listeReview", reviewAEnvoyer);
							request.setAttribute("noteBoolean", noteBoolean);
	//						request.setAttribute("note", noteStg);
						
					}
				
					session.getTransaction().commit();	
				
					//Fermeture de session
					session.close();
					
///////FIN BDD /////////			    	
			   
		    //REQUEST
		    //Ajout des données dans la requete
		    
			request.setAttribute("idAnime", idAnime);
			request.setAttribute("episodes", episodes);
		    request.setAttribute("titre", titre);
		    request.setAttribute("image", image);
		    request.setAttribute("type", type);
		    request.setAttribute("film", film);
		    request.setAttribute("duration", duration);
		    request.setAttribute("airing", airing);
		    request.setAttribute("synopsis", synopsis);
		    request.setAttribute("jDebut", jDebut);
		    request.setAttribute("mDebut", mDebut);
		    request.setAttribute("aDebut", aDebut);
		    request.setAttribute("jFin", jFin);
		    request.setAttribute("mFin", mFin);
		    request.setAttribute("aFin", aFin);
		    request.setAttribute("studios", studios);
		    request.setAttribute("studioPresent", studioPresent);
		    request.setAttribute("genres", genres);
		    request.setAttribute("personnages", listPersonnages);
		    request.setAttribute("trailer", trailer);
		    request.setAttribute("trailerPresent", trailerPresent);
		    request.setAttribute("recommandation", listRecommandation);
		    request.setAttribute("booleanAjout", booleanAjout);
		    request.setAttribute("booleanConnexion", booleanConnexion);
		    
	
		    //On indique quelle JSP appeler pour lui fournir les données
		    //La seule chose à changer est la String indiquant le chemin de la JSP
		    
		    this.getServletContext().getRequestDispatcher("/anime.jsp").forward(request, response);
		    
}	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
