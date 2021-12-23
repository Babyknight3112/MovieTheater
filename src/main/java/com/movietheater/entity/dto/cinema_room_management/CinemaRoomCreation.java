package com.movietheater.entity.dto.cinema_room_management;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CinemaRoomCreation {

    @NotBlank(message = "missing cinema room name")
    private String cinemaRoomName;

    @NotNull(message = "missing seat quantity")
    @DecimalMax(value = "100", message = "must be greater than 100")
    @Positive(message = "must be a positive number")
    private int seatQuantity;
}
