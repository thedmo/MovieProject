package ch.hfu.movieproject.services;

import ch.hfu.movieproject.common.Language;
import ch.hfu.movieproject.common.Movie;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service interface for managing movie introductions in multiple languages.
 * Handles storage and retrieval of movie descriptions.
 */
@Service
public interface MovieDatabase {
    /**
     * Retrieves a movie introduction in the specified language.
     *
     * @param movie The movie to get the introduction for
     * @param language The desired language of the introduction
     * @return Optional containing the introduction if available
     */
    Optional<String> getIntro(Movie movie, Language language);

    /**
     * Adds a new movie introduction in the specified language.
     *
     * @param movie The movie to add the introduction for
     * @param language The language of the introduction
     * @param introduction The introduction text
     */
    void addNewEntry(Movie movie, Language language, String introduction);
}
