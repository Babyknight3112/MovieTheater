package com.movietheater.repository;

import com.movietheater.entity.ShowDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShowDateRepository extends JpaRepository<ShowDate, Integer> {
    List<ShowDate> findByShowDateGreaterThanEqualAndShowDateLessThanEqual(LocalDate fromDate, LocalDate toDate);
}
