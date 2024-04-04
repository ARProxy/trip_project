package com.trip.repository;

import com.trip.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DayRepository extends JpaRepository<Day, Long> {

    List<Day> findByBoardId(Long boardId);


}
