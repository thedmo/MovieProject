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
//
//    @PostMapping("/add")
//    public String startPagePost(Model model, Locale locale, HttpSession session) {
//        String title = messageSource.getMessage("title", null, locale);
//   Redirect zu /
//    }

}
