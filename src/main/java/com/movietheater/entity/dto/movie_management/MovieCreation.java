package com.movietheater.entity.dto.movie_management;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class MovieCreation {

    @NotBlank(message = "missing movie english name")
    private String movieNameEnglish;

    @NotBlank(message = "missing movie vietnam name")
    private String movieNameVN;

    @NotNull(message = "missing release date")
    private LocalDate fromDate;

    @NotNull(message = "missing end date")
    private LocalDate toDate;

    @NotBlank(message = "missing actor")
    private String actor;

    @NotBlank(message = "missing movie production company")
    private String movieProductionCompany;

    @NotBlank(message = "missing director")
    private String director;

    @NotNull(message = "missing duration")
    @Positive(message = "must be greater than 0")
    private int duration;

    @NotBlank(message = "missing version")
    private String version;

    @NotNull(message = "must be contain at least one type")
    private List<String> types = new ArrayList<>();

    @NotBlank(message = "missing cinema room name")
    private String cinemaRoomName;

    @NotNull(message = "must be contain at least one schedule")
    private List<String> schedules = new ArrayList<>();

    @NotBlank(message = "missing content")
    private String content;

    // nullable
    private String smallImage;

    // nullable
    private String largeImage;
}
