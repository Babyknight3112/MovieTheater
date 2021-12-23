package com.movietheater.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String memberId;
    private int Score;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id",nullable = false )
    private  Account account;
}
