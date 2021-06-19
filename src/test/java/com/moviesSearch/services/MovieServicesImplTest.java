package com.moviesSearch.services;

import com.moviesSearch.data.model.Movie;
import com.moviesSearch.web.exceptions.MovieNameCannotBeNullException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class MovieServicesImplTest {
    @Autowired
    MovieServices movieServices;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void testThatWeCanFindAllMovies(){
        List<Movie>movieList=movieServices.findAllMovies();
        log.info("All the movies found are-->{}",movieList);
        assertThat(movieList.size()).isEqualTo(3);
    }
    @Test
    void testThatWeCanFindMoviesByKeywords() throws MovieNameCannotBeNullException {
        List<Movie>movieList=movieServices.findMoviesByName("i");
        log.info("All the movies found are-->{}",movieList);
        assertThat(movieList.size()).isEqualTo(2);

    }
}