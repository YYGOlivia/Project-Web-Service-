package com.movie.client;

import com.movie.model.Movie;
import com.movie.model.Actor;
import com.movie.service.MovieServiceImpl;
import java.util.List;

public class MovieServiceClient {

    public static void main(String[] args) {
        // Instantiate the service
        MovieServiceImpl service = new MovieServiceImpl();
        
        // Add movies
        Movie inception = new Movie();
        inception.setTitle("Inception");
        inception.setYear(2010);
        int inceptionId = service.addMovie(inception);
        System.out.println("Added Movie: " + inception.getTitle() + " with ID: " + inceptionId);
        
        Movie titanic = new Movie();
        titanic.setTitle("Titanic");
        titanic.setYear(1997);
        int titanicId = service.addMovie(titanic);
        System.out.println("Added Movie: " + titanic.getTitle() + " with ID: " + titanicId);
        
        // Add actor
        Actor actor = new Actor();
        actor.setName("Leonardo DiCaprio");
        int actorId = service.addActor(actor);
        System.out.println("Added Actor: " + actor.getName() + " with ID: " + actorId);
        
        // Link actor to movies
        service.linkMovieToActor(inceptionId, actorId);
        service.linkMovieToActor(titanicId, actorId);
        System.out.println("Linked Actor: " + actor.getName() + " to Movies: " + inception.getTitle() + " and " + titanic.getTitle() + ".");
        
        // Retrieve and display information about movies and actors
        displayMovieAndActorDetails(service, inception.getTitle());
        displayMovieAndActorDetails(service, titanic.getTitle());
        
    }
    
    private static void displayMovieAndActorDetails(MovieServiceImpl service, String movieTitle) {
        // Retrieve movie by title
        Movie retrievedMovie = service.getMovieByTitle(movieTitle);
        if (retrievedMovie != null) {
            System.out.println("Retrieved Movie: " + retrievedMovie.getTitle() + ", ID: " + retrievedMovie.getId() + ", Year: " + retrievedMovie.getYear());
            
            // Get and display actor information associated with the movie
            List<Actor> linkedActors = service.getActorsByMovie(retrievedMovie.getTitle());
            if (linkedActors.isEmpty()) {
                System.out.println("No actors linked to the movie: " + retrievedMovie.getTitle());
            } else {
                System.out.println("Linked Actors for " + retrievedMovie.getTitle() + ":");
                for (Actor linkedActor : linkedActors) {
                    System.out.println("Actor Name: " + linkedActor.getName() + ", ID: " + linkedActor.getId());
                }
            }
            
            // Retrieve and display movies linked to the actor
            System.out.println("Movies linked to Actor " + linkedActors.get(0).getName() + ":");
            List<Movie> moviesByActor = service.getMoviesByActor(linkedActors.get(0).getName());
            for (Movie movie : moviesByActor) {
                System.out.println(movie.getTitle() + ", Year: " + movie.getYear());
            }
            
            // Fetch and display movie ratings
            String rating = service.getMovieRating(movieTitle);
            System.out.println("Rating for '" + movieTitle + "' from OMDB: " + rating);
        }
    }
}
