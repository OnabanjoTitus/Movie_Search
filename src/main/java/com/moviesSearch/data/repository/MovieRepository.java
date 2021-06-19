package com.moviesSearch.data.repository;

import com.moviesSearch.data.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,String> {

    List<Movie> findMoviesByMovieNameContainingOrderByYearOfProduction(String movieName);

}
