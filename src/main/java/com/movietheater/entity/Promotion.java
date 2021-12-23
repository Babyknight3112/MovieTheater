package com.movietheater.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Promotion {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  int promotionId;

    @Column(nullable = false)
    private String detail;

    @Column(nullable = false)
    private  int discountLevel;

    @Column(nullable = false)
    private LocalDate endTime;

    private String image;

    @Column(nullable = false)
    private LocalDate startTime;

    @Column(nullable = false)
    private String title;

}
