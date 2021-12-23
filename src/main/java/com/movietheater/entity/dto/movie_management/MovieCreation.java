package com.movietheater.entity.dto.movie_management;

import com.movietheater.entity.CinemaRoom;
import com.movietheater.entity.Schedule;
import com.movietheater.entity.Type;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class MovieCreation {
    private String movieNameEnglish;
    private String movieNameVN;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String actor;
    private String movieProductionCompany;
    private String director;
    private int duration;
    private String version;
    private List<String> types = new ArrayList<>();
    private String cinemaRoomName;
    private List<String> schedules = new ArrayList<>();
    private String content;
    private String smallImage;
    private String largeImage;
}
