package com.moviesSearch;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MoviesSearchApplication {


	public static void main(String[] args) {
		SpringApplication.run(MoviesSearchApplication.class, args);
	}
	@Bean
	public YouTube getYouTube() {
			YouTube youtube = new YouTube.Builder(new NetHttpTransport(), new JacksonFactory(),
					(request) -> {}).setApplicationName("youtube-spring-boot-demo").build();
			return youtube;
	}
}
