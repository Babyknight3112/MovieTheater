package com.movietheater.repository;

import com.movietheater.entity.CinemaRoom;
import com.movietheater.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

    Seat findBySeatId(int seatId);

    List<Seat> findByCinemaRoom(CinemaRoom cinemaRoom);


}
