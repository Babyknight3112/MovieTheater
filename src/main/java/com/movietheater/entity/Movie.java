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

    @Column(nullable = false)
    private String actor;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private LocalDate fromDate;

    @Column(nullable = false)
    private String movieProductionCompany;

    @Column(nullable = false)
    private LocalDate toDate;

    @Column(nullable = false)
    private String version;

    @Column(nullable = false)
    private String movieNameEnglish;

    @Column(nullable = false)
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
    @ManyToOne(optional = false)
    @JoinColumn( name = "cinemaRoom_id", referencedColumnName = "cinemaRoomId")
    private  CinemaRoom cinemaRoom;


}
