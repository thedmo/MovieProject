package ch.hfu.movieproject.controller;

import java.util.List;
import ch.hfu.movieproject.common.Movie;
import ch.hfu.movieproject.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;
/**
 * Main controller handling the startpage of the movie application.
 * Manages the display of movie listings and basic navigation.
 */
@Controller
public class MainController {

    private MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private MovieService movieService;

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Displays the start page with a list of all movies.
     *
     * @param model Model object for passing attributes to view
     * @param locale Current locale for internationalization
     * @return String template name for the index page
     */
    @GetMapping(value = "/", produces = "text/html; charset=UTF-8; lang=DE")
    public String startPage(Model model, Locale locale) {
        String title = messageSource.getMessage("title", null, locale);
        String newMovie = messageSource.getMessage("newMovie", null, locale);

        List<Movie> movieList = movieService.getAllMovies();

        model.addAttribute("movies", movieList);
        model.addAttribute("title", title);
        model.addAttribute("newMovie", newMovie);

        return "Index";
    }
}
