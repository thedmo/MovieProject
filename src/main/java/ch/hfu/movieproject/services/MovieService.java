package ch.hfu.movieproject.services;

import ch.hfu.movieproject.common.Movie;
import java.util.List;
import java.util.Optional;

/**
 * Service interface defining core operations for movie management.
 * Provides methods for retrieving and adding movies to the collection.
 */
public interface MovieService {
    /**
     * Retrieves all movies in the collection.
     *
     * @return List of all movies
     */
    List<Movie> getAllMovies();

    /**
     * Retrieves a specific movie by its ID.
     *
     * @param id The unique identifier of the movie
     * @return Optional containing the movie if found, empty otherwise
     */
    Optional<Movie> getMovie(int id);

    /**
     * Adds a new movie to the collection.
     *
     * @param movie The movie object to be added
     */
    void addMovie(Movie movie);
}
