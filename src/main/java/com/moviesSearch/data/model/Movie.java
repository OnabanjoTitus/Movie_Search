package com.moviesSearch.data.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Movie {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    @Id
    private String movieName;
    @Column(nullable = false)
    private String yearOfProduction;
    @Column(nullable = false)
    private String movieCoverImage;
    @Column(nullable = false)
    private String linkToMovieTrailer;

}
