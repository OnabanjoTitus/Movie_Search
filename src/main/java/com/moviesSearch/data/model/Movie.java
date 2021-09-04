package com.moviesSearch.data.model;

import com.google.api.client.util.DateTime;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Movie {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    @Id
    private String movieName;
    @Column(nullable = false)
    private DateTime yearOfProduction;
    @Column(nullable = false)
    private String movieCoverImage;
    @Column(nullable = false)
    private String linkToMovieTrailer;


}
