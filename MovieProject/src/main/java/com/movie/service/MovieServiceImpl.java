package com.movie.service;

import com.movie.model.Movie;
import com.movie.model.Actor;
import org.json.JSONObject;
import javax.jws.WebService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


@WebService(endpointInterface = "com.movie.service.MovieService")
public class MovieServiceImpl implements MovieService {
	
	 // Store movies and actors using their IDs for quick access
    private final Map<Integer, Movie> movies = new HashMap<Integer, Movie>();
    private final Map<Integer, Actor> actors = new HashMap<Integer, Actor>();
    
    // Link movies to actors through movie IDs and list of actor IDs
    private final Map<Integer, List<Integer>> movieActors = new HashMap<Integer, List<Integer>>();
    
    // Generators for unique movie and actor IDs
    private final AtomicInteger movieIdGenerator = new AtomicInteger();
    private final AtomicInteger actorIdGenerator = new AtomicInteger();
    
    // API key for accessing external movie rating service
    private static final String API_KEY = "9b2e930d";

    
    // Adds a movie to the collection and assigns a unique ID
    public int addMovie(Movie movie) {
        int id = movieIdGenerator.incrementAndGet();
        movie.setId(id);
        movies.put(id, movie);
        return id;
    }

    
    // Adds an actor to the collection and assigns a unique ID
    public int addActor(Actor actor) {
        int id = actorIdGenerator.incrementAndGet();
        actor.setId(id);
        actors.put(id, actor);
        return id;
    }
    
    // Links a movie to an actor by their IDs
    public boolean linkMovieToActor(int movieId, int actorId) {
        List<Integer> actorIds = movieActors.get(movieId);
        if (actorIds == null) {
            actorIds = new ArrayList<Integer>();
            movieActors.put(movieId, actorIds);
        }
        actorIds.add(actorId);
        return true;
    }

    // Finds a movie by title, ignoring case
    public Movie getMovieByTitle(String title) {
        for (Movie movie : movies.values()) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }
    
   // Gets all actors for a given movie title
    public List<Actor> getActorsByMovie(String movieTitle) {
        for (Map.Entry<Integer, Movie> entry : movies.entrySet()) {
            if (entry.getValue().getTitle().equalsIgnoreCase(movieTitle)) {
                List<Actor> actorsList = new ArrayList<Actor>();
                for (Integer actorId : movieActors.get(entry.getKey())) {
                    actorsList.add(actors.get(actorId));
                }
                return actorsList;
            }
        }
        return new ArrayList<Actor>();
    }
    
    
    // Finds all movies a given actor has participated in
    public List<Movie> getMoviesByActor(String actorName) {
        List<Movie> moviesList = new ArrayList<Movie>();
        for (Map.Entry<Integer, Actor> entry : actors.entrySet()) {
            if (entry.getValue().getName().equalsIgnoreCase(actorName)) {
                for (Map.Entry<Integer, List<Integer>> movieEntry : movieActors.entrySet()) {
                    if (movieEntry.getValue().contains(entry.getKey())) {
                        moviesList.add(movies.get(movieEntry.getKey()));
                    }
                }
            }
        }
        return moviesList;
    }
    
 // Fetches the movie rating from an external API by title
    public String getMovieRating(String title) {
        try {
            URL url = new URL("http://www.omdbapi.com/?t=" + encodeValue(title) + "&apikey=" + API_KEY);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                StringBuilder informationString = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    informationString.append(line);
                }
                reader.close();

                JSONObject obj = new JSONObject(informationString.toString());
                return obj.has("imdbRating") ? obj.getString("imdbRating") : "Rating not found";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
 // Helper method to URL encode a string value
    private static String encodeValue(String value) {
        try {
            return java.net.URLEncoder.encode(value, java.nio.charset.StandardCharsets.UTF_8.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}