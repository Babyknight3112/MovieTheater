package com.movietheater.entity.dto.cinema_room_management;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SeatResponse {
    private  int seatId;
    private  String seatColumn;
    private  int seatRow;
    private int seatStatus;
    private int seatType;
}
