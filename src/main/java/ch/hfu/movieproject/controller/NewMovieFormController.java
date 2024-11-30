package ch.hfu.movieproject.controller;

import ch.hfu.movieproject.common.Movie;
import ch.hfu.movieproject.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import java.util.Locale;

/**
 * Controller handling the creation of new movie entries.
 * Manages the form display and submission for adding new movies.
 */
@Controller
public class NewMovieFormController {

    final private MessageSource messageSource;

    @Autowired
    public NewMovieFormController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    private MovieService movieService;

    @Autowired
    public NewMovieFormController setMovieService(MovieService movieService) {
        this.movieService = movieService;
        return this;
    }

    /**
     * Displays the form for adding a new movie.
     *
     * @param model Model object for passing attributes to view
     * @param locale Current locale for internationalization
     * @return String template name for the new movie form
     */
    @GetMapping("/new")
    public String startPage(Model model, Locale locale) {
        String backString = messageSource.getMessage("backString", null, locale);
        model.addAttribute("backString", backString);

        String addNewButtonText = messageSource.getMessage("addNewMovieText", null, locale);
        model.addAttribute("addNewButtonText", addNewButtonText);

        model.addAttribute("newMovie", new Movie());

        return "NewMovieForm";
    }

    /**
     * Processes the submission of a new movie.
     *
     * @param movie Movie object populated from form submission
     * @return RedirectView redirecting to the index page
     */
    @PostMapping("/addNew")
    public RedirectView addNewMovie(@ModelAttribute Movie movie) {
        movieService.addMovie(movie);
        return new RedirectView("/");
    }
}
