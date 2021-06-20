package com.moviesSearch.web.controller;

import com.moviesSearch.data.model.Movie;
import com.moviesSearch.services.MovieServices;
import com.moviesSearch.web.dtos.MovieDto;
import com.moviesSearch.web.exceptions.MovieNameCannotBeNullException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
@Slf4j
@Controller
@RequestMapping("/movieSearch")
public class MovieController {
    @Autowired
    MovieServices movieServices;
    private String movieName;
    @GetMapping("")
    public String homepage(Model model){
        model.addAttribute("movies",new MovieDto());
        return "index";
    }
    @GetMapping("/about")
    public String aboutPage(){
        return "abouts";
    }
    @GetMapping("/contact")
    public String contactPage(){
        return "contact";
    }
    @GetMapping("/foundMovie")
    public String searchResult(Model model) throws MovieNameCannotBeNullException, IOException {
        List<Movie>movies=movieServices.findMoviesByName(movieName);
        model.addAttribute("movies",movies);
        return "movieList";
    }

    @PostMapping("/find")
    public String findMoviesWithKeyword(@Valid MovieDto movieName)  {
        log.info("The info sent is --->{}",movieName);
        this.movieName=movieName.getMovieName();
        return "redirect:/movieSearch/foundMovie";
    }

}
