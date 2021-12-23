package com.movietheater.service;

import com.movietheater.entity.Movie;
import com.movietheater.entity.dto.movie_management.MovieCreation;
import com.movietheater.entity.dto.movie_management.MovieResponse;
import com.movietheater.entity.mapper.Mapper;
import com.movietheater.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieManagementService {

    private final MovieRepository movieRepository;
    private final Mapper mapper;

    @Autowired
    public MovieManagementService(MovieRepository movieRepository, Mapper mapper) {
        this.movieRepository = movieRepository;
        this.mapper = mapper;
    }

    public MovieResponse getMovieById(String movieId){
        return mapper.toMovieResponse(movieRepository.findByMovieId(movieId));
    }

    public List<MovieResponse> getAllMovie(){
        return movieRepository.findAll().stream().map(mapper::toMovieResponse).collect(Collectors.toList());
    }

    public List<MovieResponse> getMovieByWildcard(String wildcard){
        return movieRepository.findAllByMovieNameEnglishStartingWith(wildcard)
                .stream().map(mapper::toMovieResponse).collect(Collectors.toList());
    }

    public String addMovie(MovieCreation movieCreation){
        movieRepository.save(mapper.toMovie(movieCreation));
        return "Successfully add a movie";
    }

    public String editMovie(String movieId, MovieCreation movieCreation){
        Movie movie = movieRepository.findByMovieId(movieId);
        mapper.fixDup2(movie, movieCreation);
        movieRepository.save(movie);
        return "Successfully update the movie has id: " + movieId;
    }

    public String deleteMovie(String movieId){
        movieRepository.deleteById(movieId);
        return "Successfully delete the movie has id: " + movieId;
    }
}
