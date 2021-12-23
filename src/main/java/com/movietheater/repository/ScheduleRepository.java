package com.movietheater.repository;

import com.movietheater.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    Schedule findByScheduleTime(String scheduleTime);
}
