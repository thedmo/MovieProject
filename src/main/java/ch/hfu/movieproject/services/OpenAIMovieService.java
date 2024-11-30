package ch.hfu.movieproject.services;

import ch.hfu.movieproject.common.Language;
import ch.hfu.movieproject.common.Movie;

/**
 *  Service interface for retrieving information about movies from an Ai API
 */
public interface OpenAIMovieService {

    /**
     * Retrieves an AI-generated introduction for a movie in the specified language.
     *
     * @param movie The movie to generate an introduction for
     * @param language The target language for the introduction
     * @return A string containing the AI-generated movie introduction
     * @throws IllegalArgumentException if movie or language parameters are null
     */
    String getIntro(Movie movie, Language language);
}
