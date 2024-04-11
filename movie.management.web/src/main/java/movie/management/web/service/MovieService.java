package movie.management.web.service;

import movie.management.web.data.Movie;
import movie.management.web.data.Actor;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class for managing movies and actors. Provides functionality to add movies and actors, link them, and retrieve information about them.
 */
public class MovieService {
    private Map<Integer, Movie> movies = new HashMap<>();
    private Map<Integer, Actor> actors = new HashMap<>();
    private Map<Integer, List<Integer>> movieToActors = new HashMap<>();
    private static int movieIdCounter = 1; // Movie ID Counter
    private static int actorIdCounter = 1; // Actor ID counter

    /**
     * Adds a new movie to the collection. If the movie already exists, returns the existing one instead of adding a duplicate.
     *
     * @param movie The movie to add.
     * @return The added or existing movie.
     */
    public Movie addMovie(Movie movie) {
        Optional<Movie> existing = movies.values().stream()
            .filter(m -> m.getTitle().equals(movie.getTitle()) && m.getYear().equals(movie.getYear()))
            .findFirst();
        if (existing.isPresent()) {
            return existing.get();
        }
        movie.setId(movieIdCounter++);
        movies.put(movie.getId(), movie);
        return movie;
    }

    /**
     * Adds a new actor to the collection. If the actor already exists, returns the existing one instead of adding a duplicate.
     *
     * @param actor The actor to add.
     * @return The added or existing actor.
     */
    public Actor addActor(Actor actor) {
        Optional<Actor> existing = actors.values().stream()
            .filter(a -> a.getName().equals(actor.getName()))
            .findFirst();
        if (existing.isPresent()) {
            return existing.get();
        }
        actor.setId(actorIdCounter++);
        actors.put(actor.getId(), actor);
        return actor;
    }

    /**
     * Links a movie to an actor by their IDs. Prevents duplicate links.
     *
     * @param movieId The ID of the movie.
     * @param actorId The ID of the actor.
     * @return A message indicating success or failure of the operation.
     */
    public String linkMovieToActor(Integer movieId, Integer actorId) {
        List<Integer> actorIdList = movieToActors.get(movieId);
        if (actorIdList != null && actorIdList.contains(actorId)) {
            Movie movie = movies.get(movieId);
            Actor actor = actors.get(actorId);
            return "Link between " + movie.getTitle() + " and " + actor.getName() + " already exists.";
        }

        movieToActors.computeIfAbsent(movieId, k -> new ArrayList<>()).add(actorId);
        Movie movie = movies.get(movieId);
        Actor actor = actors.get(actorId);
        if (movie != null && actor != null) {
            return "Linked " + movie.getTitle() + " with " + actor.getName() + " successfully.";
        }
        return "Link failed.";
    }

    /**
     * Retrieves a movie by its title.
     *
     * @param title The title of the movie.
     * @return The movie if found, null otherwise.
     */
    public Movie getMovieByTitle(String title) {
        return movies.values().stream().filter(movie -> movie.getTitle().equals(title)).findFirst().orElse(null);
    }

    /**
     * Retrieves movies that a given actor has been linked to.
     *
     * @param name The name of the actor.
     * @return A list of movies associated with the actor.
     */
    public List<Movie> getMoviesByActorName(String name) {
        Set<Integer> actorIds = actors.entrySet().stream().filter(entry -> entry.getValue().getName().equals(name)).map(Map.Entry::getKey).collect(Collectors.toSet());
        List<Movie> result = new ArrayList<>();
        movieToActors.forEach((movieId, actorIdList) -> {
            if (actorIdList.stream().anyMatch(actorIds::contains)) {
                result.add(movies.get(movieId));
            }
        });
        return result;
    }

    /**
     * Retrieves all movies.
     *
     * @return A map of all movies, keyed by their ID.
     */
    public Map<Integer, Movie> getMovies() {
        return movies;
    }

    /**
     * Sets the movie collection to a new map of movies.
     *
     * @param movies A map of movies to set.
     */
    public void setMovies(Map<Integer, Movie> movies) {
        this.movies = movies;
    }
}
