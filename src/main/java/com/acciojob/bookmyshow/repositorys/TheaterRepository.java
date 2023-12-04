package com.acciojob.bookmyshow.repositorys;

import com.acciojob.bookmyshow.models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
}
