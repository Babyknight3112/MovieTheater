package com.movietheater.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
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


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "movie_date"
    ,joinColumns = @JoinColumn(name = "showDate_id")
    ,inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<ShowDate> showDates = new HashSet<>();


    @ManyToMany(mappedBy = "movies", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private  Set<Type> types = new HashSet<>();

    @ManyToMany(mappedBy = "movies", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private  Set<Schedule> schedules = new HashSet<>();

    @OneToMany(mappedBy = "movie")
    private  Set<ScheduleSeat> scheduleSeats =new HashSet<>();


    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn( name = "cinemaRoom_id")
    private  CinemaRoom cinemaRoom;


}
