package com.movie.service;

import com.movie.model.Movie;
import com.movie.model.Actor;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://service.movie.com/")
public interface MovieService {
    @WebMethod int addMovie(Movie movie);
    @WebMethod int addActor(Actor actor);
    @WebMethod boolean linkMovieToActor(int movieId, int actorId);
    @WebMethod Movie getMovieByTitle(String title);
    @WebMethod List<Actor> getActorsByMovie(String movieTitle);
    @WebMethod List<Movie> getMoviesByActor(String actorName);
    @WebMethod String getMovieRating(String title); 
}
