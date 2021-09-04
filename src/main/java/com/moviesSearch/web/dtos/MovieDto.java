package com.moviesSearch.web.dtos;

import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
public class MovieDto {
    @NotEmpty(message = "movie title cannot be empty")
    private String movieName;

}
