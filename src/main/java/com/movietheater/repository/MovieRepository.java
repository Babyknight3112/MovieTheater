package com.movietheater.repository;

import com.movietheater.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

    Movie findByMovieId(String movieId);

    List<Movie> findAllByMovieNameEnglishStartingWith(String wildcard);
}
