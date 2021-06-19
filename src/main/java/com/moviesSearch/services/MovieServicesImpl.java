package com.moviesSearch.services;

import com.moviesSearch.data.model.Movie;
import com.moviesSearch.data.repository.MovieRepository;
import com.moviesSearch.web.exceptions.MovieNameCannotBeNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServicesImpl implements MovieServices {
    @Autowired
    MovieRepository movieRepository;
    @Override
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> findMoviesByName(String movieName) throws MovieNameCannotBeNullException {
        if(movieName==null|| movieName.equals("")){
            throw new MovieNameCannotBeNullException("The Search Cannot Be Null");
        }
       List<Movie> movieList= movieRepository.findMoviesByMovieNameContainingOrderByYearOfProduction(movieName);
        if(movieList.isEmpty()){
            return null;
//            movieRepository.findAll().stream()
//                    .filter(movie -> movie.getMovieName().contains(movieName))
//                    .collect(Collectors.toList());
        }
       return movieList;
    }
}
