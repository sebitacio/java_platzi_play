package com.platzi.play.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.domain.service.MovieService;

@RestController 
public class MovieController {

    private final MovieService movieService;
    
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<MovieDto> getAll() {
        return (List<MovieDto>) this.movieService.getAll();
    } 
}
