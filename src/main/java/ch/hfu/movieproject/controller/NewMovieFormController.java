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

    @GetMapping("/new")
    public String startPage(Model model, Locale locale) {
        String backString = messageSource.getMessage("backString", null, locale);
        model.addAttribute("backString", backString);

        String addNewButtonText = messageSource.getMessage("addNewMovieText", null, locale);
        model.addAttribute("addNewButtonText", addNewButtonText);

        model.addAttribute("newMovie", new Movie());

        return "NewMovieForm";
    }

    @PostMapping("/addNew")
    public RedirectView addNewMovie(@ModelAttribute Movie movie) {
        movieService.addMovie(movie);
        return new RedirectView("/");
    }
}
