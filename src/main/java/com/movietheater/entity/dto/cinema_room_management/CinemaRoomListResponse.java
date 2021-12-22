package com.movietheater.entity.dto.cinema_room_management;

import com.movietheater.entity.Seat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CinemaRoomListResponse {
    private int cinemaRoomId;
    private String cinemaRoomName;
    private int seatQuantity;
    private List<SeatResponse> seatList;
}
