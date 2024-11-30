package ch.hfu.movieproject.services;

import ch.hfu.movieproject.common.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> getAllMovies();
    Optional<Movie> getMovie(int id);
    void addMovie(Movie movie);
}
