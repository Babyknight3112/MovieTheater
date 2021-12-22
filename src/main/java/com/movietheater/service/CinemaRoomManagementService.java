package com.movietheater.service;

import com.movietheater.entity.CinemaRoom;
import com.movietheater.entity.Seat;
import com.movietheater.entity.dto.cinema_room_management.CinemaRoomCreation;
import com.movietheater.entity.dto.cinema_room_management.CinemaRoomListResponse;
import com.movietheater.entity.dto.cinema_room_management.SeatResponse;
import com.movietheater.entity.dto.cinema_room_management.UpdateSeatRequest;
import com.movietheater.entity.mapper.Mapper;
import com.movietheater.repository.CinemaRoomRepository;
import com.movietheater.repository.SeatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CinemaRoomManagementService {

    private final Mapper mapper;
    private final CinemaRoomRepository cinemaRoomRepository;
    private final SeatRepository seatRepository;

    @Autowired
    public CinemaRoomManagementService(Mapper mapper, CinemaRoomRepository cinemaRoomRepository, SeatRepository seatRepository) {
        this.mapper = mapper;
        this.cinemaRoomRepository = cinemaRoomRepository;
        this.seatRepository = seatRepository;
    }

    public CinemaRoomListResponse getByCinemaRoomId(int id){
        return mapper.toCinemaRoomResponse(cinemaRoomRepository.findByCinemaRoomId(id));
    }

    public List<CinemaRoomListResponse> getAllCinemaRoom(){
        return cinemaRoomRepository.findAll()
                .stream().map(mapper::toCinemaRoomResponse).collect(Collectors.toList());

    }

    public List<CinemaRoomListResponse> getByNameLike(String wildCard){
        return cinemaRoomRepository
                .findByCinemaRoomNameStartingWith(wildCard)
                .stream().map(mapper::toCinemaRoomResponse).collect(Collectors.toList());
    }

    public String addCinemaRoom(CinemaRoomCreation cinemaRoomCreation){
        cinemaRoomRepository.save(mapper.toCinemaRoom(cinemaRoomCreation));
        return "Successfully add a cinema room";
    }

    public List<SeatResponse> getListSeatByRoomId(int cinemaRoomId){
        CinemaRoom cinemaRoom = cinemaRoomRepository.findByCinemaRoomId(cinemaRoomId);
        List<Seat> seats = new ArrayList<>(seatRepository.findByCinemaRoom(cinemaRoom));
        return seats.stream().map(mapper::toSeatResponse).collect(Collectors.toList());
    }

    public String updateTypeSeat(int seatId, UpdateSeatRequest updateSeatRequest){
        Seat seat = seatRepository.findBySeatId(seatId);
        seat.setSeatType(updateSeatRequest.getState());
        seatRepository.save(seat);
        return "Successfully updated this seat";
    }

}
