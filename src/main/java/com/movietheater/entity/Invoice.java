package com.movietheater.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  String invoiceId;
    private int addScore;
    private Date bookingDate;
    private  int status;
    private  int totalMoney;
    private  int userScore;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @OneToOne
    @JoinColumn( name = "schedule_seat")
    private  ScheduleSeat scheduleSeat;

}
