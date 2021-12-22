package com.movietheater.controller;

import com.movietheater.entity.dto.cinema_room_management.CinemaRoomCreation;
import com.movietheater.entity.dto.cinema_room_management.CinemaRoomListResponse;
import com.movietheater.entity.dto.cinema_room_management.SeatResponse;
import com.movietheater.entity.dto.cinema_room_management.UpdateSeatRequest;
import com.movietheater.service.CinemaRoomManagementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CRM")
public class CinemaRoomManagementController {

    private final CinemaRoomManagementService cinemaRoomManagementService;

    public CinemaRoomManagementController(CinemaRoomManagementService cinemaRoomManagementService) {
        this.cinemaRoomManagementService = cinemaRoomManagementService;
    }

    @GetMapping("/room/id/{id}")
    public CinemaRoomListResponse getByCinemaRoomId(@PathVariable("id") int id){
        return cinemaRoomManagementService.getByCinemaRoomId(id);
    }

    @GetMapping("/room")
    public List<CinemaRoomListResponse> getAllCinemaRoom(){
        return cinemaRoomManagementService.getAllCinemaRoom();
    }

    @GetMapping("/room/name/{name}")
    public List<CinemaRoomListResponse> getByNameLike(@PathVariable("name") String wildCard){
        return cinemaRoomManagementService.getByNameLike(wildCard);
    }

    @PostMapping("/room/add")
    public String addCinemaRoom(@RequestBody CinemaRoomCreation cinemaRoomCreation){
        return cinemaRoomManagementService.addCinemaRoom(cinemaRoomCreation);
    }

    @GetMapping("/seat/id/{id}")
    public List<SeatResponse> getListSeatByRoomId(@PathVariable("id") int cinemaRoomId){
        return cinemaRoomManagementService.getListSeatByRoomId(cinemaRoomId);
    }

    @PutMapping("/seat/update/id/{id}")
    public String updateTypeSeat(@PathVariable("id") int seatId, @RequestBody UpdateSeatRequest updateSeatRequest){
        return cinemaRoomManagementService.updateTypeSeat(seatId, updateSeatRequest);
    }
}
