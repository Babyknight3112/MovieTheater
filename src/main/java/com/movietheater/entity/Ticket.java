package com.movietheater.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Ticket {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int ticketId;
        private  int price;
        private  int ticketType;

        @OneToOne(mappedBy = "ticket")
        private  CinemaRoom cinemaRoom;
}
