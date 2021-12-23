package com.movietheater.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class CinemaRoom {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int cinemaRoomId;

    @Column(nullable = false)
    private String cinemaRoomName;

    @Column(nullable = false)
    private int seatQuantity;


    @OneToMany(mappedBy = "cinemaRoom", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("cinemaRoom")
//    private Set<Seat> seats = new HashSet<>();
    private List<Seat> seats = new ArrayList<>();


    @OneToOne
//    @JoinColumn(name = "ticket_id", nullable = false)
    @JoinColumn(name = "ticket_id")
    private  Ticket ticket;

//    @OneToMany( mappedBy = "cinemaRoom", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OneToMany( mappedBy = "cinemaRoom")
    private Set<Movie> movies = new HashSet<>();

}
