package com.moviesSearch.services;

import com.moviesSearch.data.model.Movie;
import com.moviesSearch.web.exceptions.MovieNameCannotBeNullException;

import java.io.IOException;
import java.util.List;

public interface MovieServices {
    List<Movie> findAllMovies();
    List<Movie> findMoviesByName(String movieName) throws MovieNameCannotBeNullException, IOException;
}
