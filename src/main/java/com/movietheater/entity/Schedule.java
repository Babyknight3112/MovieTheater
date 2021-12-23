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

    @Column(nullable = false)
    private String scheduleTime;

    @OneToMany(mappedBy = "schedule")
    private  Set<ScheduleSeat> scheduleSeats =new HashSet<>();

}
