package com.moviesSearch.data.repository;

import com.moviesSearch.data.model.Movie;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class MovieRepositoryTest {
    @Autowired
    private MovieRepository movieRepository;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void testThatWeCanFetchAMovieFromTheDatabase(){
        List<Movie>movieList=movieRepository.findAll();
        log.info("The list of movies returned are -->{}",movieList);
        assertThat(movieList.size()).isEqualTo(3);
    }
    @Test
    void testThatWeCanFetchAMovieFromTheDatabaseByKeywords(){
        List<Movie>movieList=movieRepository.findMoviesByMovieNameContainingOrderByYearOfProduction("i");
        log.info("The list of movies returned are -->{}",movieList);
        assertThat(movieList.size()).isEqualTo(2);
    }

}