package ch.hfu.movieproject.services;

import ch.hfu.movieproject.common.Language;
import ch.hfu.movieproject.common.Movie;

public interface OpenAIMovieService {
    String getIntro(Movie movie, Language language);
}
