package com.movietheater.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int scheduleId;
    private String scheduleTime;

// Comment để cho anh em biết đây là sai
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable( name = "movie_shedule"
//    , joinColumns = @JoinColumn( name = "schedule_id")
//    ,inverseJoinColumns = @JoinColumn( name = "movie_id"))
//    private Set<Movie> movies = new HashSet<>();

    @OneToMany(mappedBy = "schedule")
    private  Set<ScheduleSeat> scheduleSeats =new HashSet<>();

}
