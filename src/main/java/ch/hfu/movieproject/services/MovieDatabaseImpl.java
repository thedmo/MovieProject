package ch.hfu.movieproject.services;

import ch.hfu.movieproject.common.Language;
import ch.hfu.movieproject.common.Movie;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class MovieDatabaseImpl implements MovieDatabase {

    Map<Movie, EnumMap<Language, String>> moviesMap = new HashMap<>();

    @Override
    public Optional<String> getIntro(Movie movie, Language language) {
        if (!moviesMap.containsKey(movie)) {
            return Optional.empty();
        }

        return Optional.ofNullable(moviesMap.get(movie).get(language));
    }

    @Override
    public void addNewEntry(Movie movie, Language language, String introduction) {
        if (!moviesMap.containsKey(movie)) {
            EnumMap<Language, String> eMap = new EnumMap<>(Language.class);
            eMap.put(language, introduction);
            moviesMap.put(movie, eMap);
        } else {
            moviesMap.get(movie).put(language, introduction);
        }
    }
}
