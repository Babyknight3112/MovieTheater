package com.movietheater.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Data
public class Movie {
    @Id
    private String movieId;
    private String actor;
    private String content;
    private String director;
    private int duration;
    private LocalDate fromDate;
    private String movieProductionCompany;
    private LocalDate toDate;
    private String version;
    private String movieNameEnglish;
    private String movieNameVN;
    private String largeImage;
    private String smallImage;


//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "movie_date"
//    ,joinColumns = @JoinColumn(name = "movie_id")
//    ,inverseJoinColumns = @JoinColumn(name = "showDate_id"))
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<ShowDate> showDates = new HashSet<>();


//    @ManyToMany(mappedBy = "movies", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ManyToMany(fetch = FetchType.EAGER)
    private  Set<Type> types = new HashSet<>();

//    @ManyToMany(mappedBy = "movies", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ManyToMany(fetch = FetchType.EAGER)
    private  Set<Schedule> schedules = new HashSet<>();
//    private List<Schedule> schedules = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private  Set<ScheduleSeat> scheduleSeats =new HashSet<>();


//    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn( name = "cinemaRoom_id", referencedColumnName = "cinemaRoomId")
    private  CinemaRoom cinemaRoom;


}
