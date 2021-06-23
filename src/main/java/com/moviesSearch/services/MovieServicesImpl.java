package com.moviesSearch.services;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.moviesSearch.data.model.Movie;
import com.moviesSearch.data.repository.MovieRepository;
import com.moviesSearch.web.exceptions.MovieNameCannotBeNullException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class MovieServicesImpl implements MovieServices {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    YouTube youTube;
    @Override
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }


    @Override
    public List<Movie> findMoviesByName(String movieName) throws MovieNameCannotBeNullException, IOException {
        if(movieName==null|| movieName.equals("")){
            throw new MovieNameCannotBeNullException("The Search Cannot Be Null");
        }
        YouTube.Search.List search=youTube.search().list("id,snippet");
        String apiKey ="AIzaSyDPuMXkKgppEj57I-GJCOUskKThCMymHoA";
        search.setKey(apiKey);

        search.setQ(movieName);
        search.setType("video");
        search.setFields ("items(id/kind,id/videoId,snippet/title,snippet/description,snippet/publishedAt,snippet/thumbnails/default/url)");
        search.setMaxResults(4L);
        SearchListResponse searchListResponse=search.execute();
       List<SearchResult>searchResults =searchListResponse.getItems();
        log.info("Movie found are -->{}",searchResults);
        List<Movie> movieList=new ArrayList<>();

        if(searchResults!=null){
            for(SearchResult result:searchResults){
                Movie movie= new Movie();
                movie.setMovieName(result.getSnippet().getTitle());
                movie.setLinkToMovieTrailer(buildVideoUrl(result.getId().getVideoId()));
                movie.setMovieCoverImage(result.getSnippet().getThumbnails().getDefault().getUrl());
                movie.setYearOfProduction(result.getSnippet().getDescription());
                movieList.add(movie);
            }
            log.info("The items found are -->{}",movieList);
        }
       return movieList;
    }
    private String buildVideoUrl(String videoId) {
        StringBuilder builder = new StringBuilder();
        builder.append("https://www.youtube.com/watch?v=");
        builder.append(videoId);

        return builder.toString();
    }
}
