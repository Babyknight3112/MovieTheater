package com.movietheater.controller;

import com.movietheater.entity.dto.movie_management.MovieCreation;
import com.movietheater.entity.dto.movie_management.MovieResponse;
import com.movietheater.service.MovieManagementService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/MM")
public class MovieManagementController {

    private final MovieManagementService movieManagementService;

    public MovieManagementController(MovieManagementService movieManagementService) {
        this.movieManagementService = movieManagementService;
    }

    @GetMapping("/movie/id/{id}")
    public MovieResponse getMovieById(@PathVariable("id") String movieId){
        return movieManagementService.getMovieById(movieId);
    }

    @GetMapping("/movie")
    public List<MovieResponse> getAllMovie(){
        return movieManagementService.getAllMovie();
    }

    @GetMapping("/movie/name/{name}")
    public List<MovieResponse> getMovieByWildcard(@PathVariable("name") String wildcard){
        return movieManagementService.getMovieByWildcard(wildcard);
    }

    @PostMapping("/add")
    public String addMovie(@Valid @RequestBody MovieCreation movieCreation){
        return movieManagementService.addMovie(movieCreation);
    }

    @PutMapping("/update/id/{id}")
    public String editMovie(@PathVariable("id") String movieId, @Valid @RequestBody MovieCreation movieCreation){
        return movieManagementService.editMovie(movieId, movieCreation);
    }

    @DeleteMapping("/delete/id/{id}")
    public String deleteMovie(@PathVariable("id") String movieId){
        return movieManagementService.deleteMovie(movieId);
    }

}
