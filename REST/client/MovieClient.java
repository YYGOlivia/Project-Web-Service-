package movie.management.client;

import org.json.JSONArray;
import org.json.JSONObject;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.client.WebClient;

/**
 * This class serves as a client for interacting with the movie management service.
 */
public class MovieClient {

    private static final String BASE_URL = "http://localhost:8080/movie.management.web/api/movieService";
    private static final String OMDB_API_URL = "http://www.omdbapi.com/";
    private static final String OMDB_API_KEY = "9b2e930d"; 
    
    /**
     * Main method to demonstrate the functionalities of the MovieClient class.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // Adding movies
        int inceptionMovieId = addMovie("Inception", 2010);
        int titanicMovieId = addMovie("Titanic", 1997); 
        int bladeRunnerMovieId = addMovie("Blade Runner 2049", 2017); 
        
        // Adding actors
        int actorLeonardoId = addActor("Leonardo DiCaprio"); 
        int actorJosephId = addActor("Joseph Gordon-Levitt"); 
        int actorRyanId = addActor("Ryan Gosling"); 

        // Linking actors to movies
        if (inceptionMovieId != -1 && actorLeonardoId != -1) {
            linkMovieToActor(inceptionMovieId, actorLeonardoId); 
        }
        if (titanicMovieId != -1 && actorLeonardoId != -1) {
            linkMovieToActor(titanicMovieId, actorLeonardoId); 
        }
        if (inceptionMovieId != -1 && actorJosephId != -1) {
            linkMovieToActor(inceptionMovieId, actorJosephId); 
        }
        if (bladeRunnerMovieId != -1 && actorRyanId != -1) {
            linkMovieToActor(bladeRunnerMovieId, actorRyanId); 
        }
        
        // Retrieving movie information
        getMovieByTitle("Inception");
        getMovieByTitle("Titanic");
        getMovieByTitle("Blade Runner 2049");

        // Retrieving movies by actor name
        getMoviesByActorName("Leonardo DiCaprio");
        getMoviesByActorName("Joseph Gordon-Levitt");
        getMoviesByActorName("Ryan Gosling");
        
        // Retrieving all movies
        getMovies(); 

        // Retrieving movie ratings from OMDB API
        getMovieRating("Inception"); 
        getMovieRating("Titanic"); 
        getMovieRating("Blade Runner 2049"); 
    }

    /**
     * Adds a movie to the movie management service.
     * @param title The title of the movie.
     * @param year The release year of the movie.
     * @return The ID of the added movie, or -1 if addition fails.
     */
    private static int addMovie(String title, int year) {
        WebClient client = WebClient.create(BASE_URL + "/addMovie");
        client.type("application/json").accept("application/json");
        
        String movieJson = String.format("{\"movie\":{\"title\":\"%s\", \"year\":%d}}", title, year);
        System.out.println(movieJson);
        
        Response response = client.post(movieJson);
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            String responseBody = response.readEntity(String.class);
            JSONObject jsonObject = new JSONObject(responseBody);
            int id = jsonObject.getInt("id");  
            System.out.println("Movie added successfully with ID: " + id);
            return id;
        } else {
            System.out.println("Failed to add movie. Status: " + response.getStatus());
            return -1;
        }
    }

    /**
     * Adds an actor to the movie management service.
     * @param name The name of the actor.
     * @return The ID of the added actor, or -1 if addition fails.
     */
    private static int addActor(String name) {
        WebClient client = WebClient.create(BASE_URL + "/addActor");
        client.type("application/json").accept("application/json");

        String actorJson = String.format("{\"actor\":{\"name\":\"%s\"}}", name);
        System.out.println(actorJson);
        Response response = client.post(actorJson);

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            String responseBody = response.readEntity(String.class);
            JSONObject jsonObject = new JSONObject(responseBody);
            int id = jsonObject.getInt("id");  
            System.out.println("Actor added successfully with ID: " + id);
            return id;
        } else {
            System.out.println("Failed to add actor. Status: " + response.getStatus());
            return -1;
        }
    }

    /**
     * Links a movie to an actor in the movie management service.
     * @param movieId The ID of the movie.
     * @param actorId The ID of the actor.
     */
    private static void linkMovieToActor(int movieId, int actorId) {
        WebClient client = WebClient.create(BASE_URL + "/link");
        client.query("movieId", movieId).query("actorId", actorId).accept("application/json");
        Response response = client.post(null);

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            String linkResult = response.readEntity(String.class);
            System.out.println(linkResult);
        } else {
            System.out.println("Failed to link movie to actor. Status: " + response.getStatus());
        }
    }

    /**
     * Retrieves movie information by its title from the movie management service.
     * @param title The title of the movie to retrieve.
     */
    private static void getMovieByTitle(String title) {
        WebClient client = WebClient.create(BASE_URL + "/getMovieByTitle");
        client.query("title", title).accept("application/json");
        Response response = client.get();

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            String movieInfo = response.readEntity(String.class);
            System.out.println("Movie information retrieved: " + movieInfo);
        } else {
            System.out.println("Failed to retrieve movie information. Status: " + response.getStatus());
        }
    }

    /**
     * Retrieves all movies from the movie management service.
     */
    private static void getMovies() {
        WebClient client = WebClient.create(BASE_URL + "/getMovies");
        client.accept("application/json");
        Response response = client.get();

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            try {
                String jsonResponse = response.readEntity(String.class);
                System.out.println("Movies: " + jsonResponse); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to retrieve movies information. Status: " + response.getStatus());
        }
    }

    /**
     * Retrieves movies by the name of an actor from the movie management service.
     * @param name The name of the actor.
     */
    private static void getMoviesByActorName(String name) {
        WebClient client = WebClient.create(BASE_URL + "/getMoviesByActorName");
        client.query("name", name).accept("application/json");
        Response response = client.get();

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            String moviesInfo = response.readEntity(String.class);
            JSONArray moviesJsonArray = new JSONArray(moviesInfo); // Use org.json to parse the string

            System.out.println("Movies information for actor " + name + ": ");
            for (int i = 0; i < moviesJsonArray.length(); i++) {
                JSONObject movieJson = moviesJsonArray.getJSONObject(i);
                System.out.println("Movie ID: " + movieJson.getInt("id") + ", Title: " + movieJson.getString("title"));
            }
        } else {
            System.out.println("Failed to retrieve movies information. Status: " + response.getStatus());
        }
    }

    /**
     * Retrieves the rating of a movie from the OMDB API.
     * @param title The title of the movie.
     */
    private static void getMovieRating(String title) {
        WebClient client = WebClient.create(OMDB_API_URL);
        client.query("t", title).query("apikey", OMDB_API_KEY);
        Response response = client.get();

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            String responseBody = response.readEntity(String.class);
            System.out.println("Rating from OMDB: " + responseBody);
        } else {
            System.out.println("Failed to get movie rating from OMDB API. Status: " + response.getStatus());
        }
    }
}
