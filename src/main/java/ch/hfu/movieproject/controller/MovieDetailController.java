package ch.hfu.movieproject.controller;

import ch.hfu.movieproject.common.Language;
import ch.hfu.movieproject.common.LanguageFactory;
import ch.hfu.movieproject.common.Movie;
import ch.hfu.movieproject.services.MovieDatabase;
import ch.hfu.movieproject.services.MovieService;
import ch.hfu.movieproject.services.OpenAIMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Locale;

@Controller
public class MovieDetailController {
    private MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private OpenAIMovieService aiMovieService;

    @Autowired
    public void setAiMovieService(OpenAIMovieService aiMovieService) {
        this.aiMovieService = aiMovieService;
    }

    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    private MovieDatabase movieDatabase;

    @Autowired
    public void setMovieDatabase(MovieDatabase movieDatabaseImpl) {
        this.movieDatabase = movieDatabaseImpl;
    }

    @GetMapping("/{id}")
    public String showMovieDetails(Model model, @PathVariable int id, Locale locale) {
        String backString = messageSource.getMessage("backString", null, locale);
        model.addAttribute("backString", backString);

        Movie movie = movieService.getMovie(id).orElse(null);
        if (movie == null) {
            return "MovieNotFound";
        }
        model.addAttribute("movie", movie);

        Language currentLanguage = LanguageFactory.fromLocale(locale);

        String introduction = movieDatabase.getIntro(movie, currentLanguage).orElseGet(
                () -> {
                    String newIntro = aiMovieService.getIntro(movie, currentLanguage);
                    movieDatabase.addNewEntry(movie, currentLanguage, newIntro);
                    return newIntro;
                }
        );

        model.addAttribute("introduction", introduction);

        return "MovieDetails";
    }


}
