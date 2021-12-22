package com.movietheater.entity.mapper;

import com.movietheater.entity.CinemaRoom;
import com.movietheater.entity.Seat;
import com.movietheater.entity.dto.cinema_room_management.CinemaRoomCreation;
import com.movietheater.entity.dto.cinema_room_management.CinemaRoomListResponse;
import com.movietheater.entity.dto.cinema_room_management.SeatResponse;
import com.movietheater.repository.SeatRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class Mapper {

    private final SeatRepository seatRepository;

    public Mapper(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public CinemaRoomListResponse toCinemaRoomResponse(CinemaRoom cinemaRoom) {

        List<SeatResponse> seats = seatRepository.findByCinemaRoom(cinemaRoom)
                .stream().map(seat -> new SeatResponse(
                        seat.getSeatId(),
                        seat.getSeatColumn(),
                        seat.getSeatRow(),
                        seat.getSeatStatus(),
                        seat.getSeatType()))
                .collect(Collectors.toList());

        return new CinemaRoomListResponse(
                cinemaRoom.getCinemaRoomId(),
                cinemaRoom.getCinemaRoomName(),
                cinemaRoom.getSeatQuantity(),
                seats
        );
    }

    public CinemaRoom toCinemaRoom(CinemaRoomCreation cinemaRoomCreation) {
        CinemaRoom cinemaRoom = new CinemaRoom();
        cinemaRoom.setCinemaRoomName(cinemaRoomCreation.getCinemaRoomName());
        cinemaRoom.setSeatQuantity(cinemaRoomCreation.getSeatQuantity());
        return cinemaRoom;
    }

    public SeatResponse toSeatResponse(Seat seat) {
        return new SeatResponse(
                seat.getSeatId(),
                seat.getSeatColumn(),
                seat.getSeatRow(),
                seat.getSeatStatus(),
                seat.getSeatType()
        );
    }


}
