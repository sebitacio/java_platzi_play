package com.platzi.play.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.platzi.play.domain.dto.MovieDto;
import com.platzi.play.domain.service.MovieService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieDto> getAll() {
        return (List<MovieDto>) this.movieService.getAll();
    }
    
    @GetMapping("/{id}")
    public MovieDto getMovieById(@PathVariable long id) {
        return this.movieService.getById(id);
    }
}
