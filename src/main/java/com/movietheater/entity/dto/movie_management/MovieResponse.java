package com.movietheater.entity.dto.movie_management;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class MovieResponse {
    private String movieId;
    private String movieNameEnglish;
    private String movieNameVN;
    private LocalDate ReleaseDate;
    private String movieProductionCompany;
    private int duration;
    private String version;
}
