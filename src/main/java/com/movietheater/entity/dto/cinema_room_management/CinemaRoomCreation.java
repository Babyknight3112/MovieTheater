package com.movietheater.entity.dto.cinema_room_management;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CinemaRoomCreation {
    private String cinemaRoomName;
    private int seatQuantity;
}
