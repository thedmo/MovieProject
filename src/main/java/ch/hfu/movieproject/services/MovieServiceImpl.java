package ch.hfu.movieproject.services;

import ch.hfu.movieproject.common.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    List<Movie> movies;
    int counter = 0;

    public MovieServiceImpl() {
        movies = new ArrayList<>();

        addMovie(new Movie("It", 1990 ));
        addMovie(new Movie("Iron Man", 2008 ));
        addMovie(new Movie("Alien", 1979 ));
        addMovie(new Movie("The Secret Life of Walter Mitty", 2013));
        addMovie(new Movie("Big Stan", 2007));
        addMovie(new Movie("Yes Man", 2008));
        addMovie(new Movie("Free Solo", 2018));
    }

    @Override
    public List<Movie> getAllMovies() {
        return Collections.unmodifiableList(movies);
    }

    @Override
    public Optional<Movie> getMovie(int id) {

        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return Optional.of(movie);
            }
        }

        return Optional.empty();
    }

    @Override
    public void addMovie(Movie movie) {
        counter++;
        movie.setId(counter);
        movies.add(movie);
    }
}
