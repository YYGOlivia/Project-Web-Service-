package movie.management.web.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import org.json.JSONArray;
import org.json.JSONObject;
import movie.management.web.data.Movie;
import movie.management.web.data.Actor;
import movie.management.web.service.MovieService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Resource class for managing movies and actors.
 */
@Path("/movieService")
public class MovieResource {
    private MovieService service = new MovieService();

    /**
     * Adds a new movie to the service.
     *
     * @param movie The movie to be added.
     * @return A Response object with the result of the addition.
     */
    @POST
    @Path("/addMovie")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addMovie(Movie movie) {
        Movie newMovie = service.addMovie(movie);
        if (newMovie != null) {
            JSONObject jsonResponse = new JSONObject();
            jsonResponse.put("id", newMovie.getId());
            return Response.ok(jsonResponse.toString()).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    /**
     * Adds a new actor to the service.
     *
     * @param actor The actor to be added.
     * @return A Response object with the result of the addition.
     */
    @POST
    @Path("/addActor")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addActor(Actor actor) {
        Actor newActor = service.addActor(actor);
        if (newActor != null && newActor.getId() != null) {
            JSONObject jsonResponse = new JSONObject();
            jsonResponse.put("id", newActor.getId());
            jsonResponse.put("name", newActor.getName());
            return Response.ok(jsonResponse.toString()).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Unable to add actor").build();
        }
    }

    /**
     * Links a movie to an actor.
     *
     * @param movieId The ID of the movie.
     * @param actorId The ID of the actor.
     * @return A Response object indicating the success or failure of the operation.
     */
    @POST
    @Path("/link")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response linkMovieToActor(@QueryParam("movieId") Integer movieId, @QueryParam("actorId") Integer actorId) {
        String result = service.linkMovieToActor(movieId, actorId);
        if (result.equals("Link failed.")) {
            return Response.status(Response.Status.BAD_REQUEST).entity(result).build();
        }
        return Response.ok().entity(result).build();
    }

    /**
     * Retrieves a movie by its title.
     *
     * @param title The title of the movie.
     * @return A Response object with the movie information or an error status if not found.
     */
    @GET
    @Path("/getMovieByTitle")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovieByTitle(@QueryParam("title") String title) {
        Movie movie = service.getMovieByTitle(title);
        if (movie == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(movie).build();
    }

    /**
     * Retrieves all movies.
     *
     * @return A Response object containing a list of all movies.
     */
    @GET
    @Path("/getMovies")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovies() {
        Map<Integer, Movie> movies = service.getMovies();
        List<String> m = new ArrayList<>();
        for (Movie tmp : movies.values()) {
            m.add(tmp.toString());
        }
        if (movies.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        JSONArray jsonArray = new JSONArray(m);
        return Response.ok(jsonArray.toString()).build();
    }

    /**
     * Retrieves movies by an actor's name.
     *
     * @param name The name of the actor.
     * @return A Response object containing the movies associated with the actor or an error status if not found.
     */
    @GET
    @Path("/getMoviesByActorName")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMoviesByActorName(@QueryParam("name") String name) {
        List<Movie> movies = service.getMoviesByActorName(name);

        if (movies.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        JSONArray jsonArray = new JSONArray();
        for (Movie movie : movies) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("id", movie.getId());
            jsonObj.put("title", movie.getTitle());
            jsonObj.put("year", movie.getYear());

            jsonArray.put(jsonObj);
        }

        return Response.ok(jsonArray.toString()).build();
    }
}
