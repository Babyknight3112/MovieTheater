package com.movietheater.entity.mapper;

import com.movietheater.entity.*;
import com.movietheater.entity.dto.cinema_room_management.CinemaRoomCreation;
import com.movietheater.entity.dto.cinema_room_management.CinemaRoomResponse;
import com.movietheater.entity.dto.cinema_room_management.SeatResponse;
import com.movietheater.entity.dto.movie_management.MovieCreation;
import com.movietheater.entity.dto.movie_management.MovieResponse;
import com.movietheater.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Component
@Slf4j
public class Mapper {

    private final SeatRepository seatRepository;

    private final TypeRepository typeRepository;

    private final ScheduleRepository scheduleRepository;

    private final CinemaRoomRepository cinemaRoomRepository;

    private final ShowDateRepository showDateRepository;

    @Autowired
    public Mapper(SeatRepository seatRepository, TypeRepository typeRepository,
                  ScheduleRepository scheduleRepository, CinemaRoomRepository cinemaRoomRepository,
                  ShowDateRepository showDateRepository) {
        this.seatRepository = seatRepository;
        this.typeRepository = typeRepository;
        this.scheduleRepository = scheduleRepository;
        this.cinemaRoomRepository = cinemaRoomRepository;
        this.showDateRepository = showDateRepository;
    }

    public CinemaRoomResponse toCinemaRoomResponse(CinemaRoom cinemaRoom) {

        List<SeatResponse> seats = seatRepository.findByCinemaRoom(cinemaRoom)
                .stream().map(seat -> new SeatResponse(
                        seat.getSeatId(),
                        seat.getSeatColumn(),
                        seat.getSeatRow(),
                        seat.getSeatStatus(),
                        seat.getSeatType()))
                .collect(Collectors.toList());

        return new CinemaRoomResponse(
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

    public MovieResponse toMovieResponse(Movie movie){
        return new MovieResponse(
                movie.getMovieId(),
                movie.getMovieNameEnglish(),
                movie.getMovieNameVN(),
                movie.getFromDate(),
                movie.getMovieProductionCompany(),
                movie.getDuration(),
                movie.getVersion()
        );
    }

    public Movie toMovie (MovieCreation movieCreation){
        Movie movie = new Movie();
        fixDup(movie, movieCreation);
        return movie;
    }

    public void fixDup(Movie movie, MovieCreation movieCreation){
        movie.setMovieId(UUID.randomUUID().toString().replace("-","").substring(0,8));
        fixDup2(movie, movieCreation);
    }

    public void fixDup2(Movie movie, MovieCreation movieCreation){
        Set<Type> types = new HashSet<>();
        for (String type : movieCreation.getTypes()) {
            types.add(typeRepository.findByTypeName(type));
        }

        Set<Schedule> schedules = new HashSet<>();
//        List<Schedule> schedules = new ArrayList<>();
        for (String schedule: movieCreation.getSchedules()) {
            schedules.add(scheduleRepository.findByScheduleTime(schedule));
        }

        CinemaRoom cinemaRoom = cinemaRoomRepository.findByCinemaRoomName(movieCreation.getCinemaRoomName());

        Set<ShowDate> showDates = new HashSet<>();
        for (ShowDate showDate : showDateRepository.findByShowDateGreaterThanEqualAndShowDateLessThanEqual(
                movieCreation.getFromDate(), movieCreation.getToDate())) {
            showDates.add(showDate);
        }
        log.info("{}",cinemaRoom);
        movie.setMovieNameEnglish(movieCreation.getMovieNameEnglish());
        movie.setMovieNameVN(movieCreation.getMovieNameVN());
        movie.setFromDate(movieCreation.getFromDate());
        movie.setToDate(movieCreation.getToDate());
        movie.setActor(movieCreation.getActor());
        movie.setMovieProductionCompany(movieCreation.getMovieProductionCompany());
        movie.setDirector(movieCreation.getDirector());
        movie.setDuration(movieCreation.getDuration());
        movie.setVersion(movieCreation.getVersion());
        movie.setTypes(types);
        movie.setCinemaRoom(cinemaRoom);
        movie.setSchedules(schedules);
        movie.setContent(movieCreation.getContent());
        movie.setSmallImage(movieCreation.getSmallImage());
        movie.setLargeImage(movieCreation.getLargeImage());
        movie.setShowDates(showDates);
    }

}
