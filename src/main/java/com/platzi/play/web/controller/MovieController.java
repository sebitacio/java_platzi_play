package com.platzi.play.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<MovieDto>> getAll() {
        return ResponseEntity.ok((List<MovieDto>) this.movieService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable long id) {
        
        MovieDto movie = this.movieService.getById(id);
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
