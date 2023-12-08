package com.acciojob.bookmyshow.repositorys;

import com.acciojob.bookmyshow.models.Movie;
import com.acciojob.bookmyshow.models.Show;
import com.acciojob.bookmyshow.models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
    Show findShowByShowDateAndShowTimeAndMovieAndTheater(LocalDate showDate, LocalTime showTime, Movie movie, Theater theater);
}
