package com.movietheater.repository;

import com.movietheater.entity.CinemaRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRoomRepository extends JpaRepository<CinemaRoom, Integer> {
    CinemaRoom findByCinemaRoomId(int cinemaRoomId);

    List<CinemaRoom> findAll();

    List<CinemaRoom> findByCinemaRoomNameStartingWith(String wildCard);

    CinemaRoom findByCinemaRoomName(String cinemaRoomName);

}
