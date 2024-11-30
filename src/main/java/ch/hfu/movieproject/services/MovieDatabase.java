package ch.hfu.movieproject.services;

import ch.hfu.movieproject.common.Language;
import ch.hfu.movieproject.common.Movie;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface MovieDatabase {
    Optional<String> getIntro(Movie movie, Language language);
    void addNewEntry(Movie movie, Language language, String introduction);
}
