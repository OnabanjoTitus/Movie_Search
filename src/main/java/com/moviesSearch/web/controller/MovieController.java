package com.moviesSearch.web.controller;

import com.moviesSearch.data.model.Movie;
import com.moviesSearch.services.MovieServices;
import com.moviesSearch.web.exceptions.MovieNameCannotBeNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/movieSearch")
public class MovieController {
    @Autowired
    MovieServices movieServices;

    @GetMapping("")
    public String homepage(){
        return "index";
    }
    @GetMapping("/about")
    public String aboutPage(){
        return "aboutus";
    }
    @GetMapping("/contact")
    public String contactPage(){
        return "contact";
    }
    @GetMapping("/moviesFound")
    public String findMoviesWithKeyword(Model model,String movieName) throws MovieNameCannotBeNullException {
        List<Movie>movies=movieServices.findMoviesByName(movieName);

        return "movieList";
    }

}
