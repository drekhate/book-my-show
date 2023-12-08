package com.acciojob.bookmyshow.dtos;

import com.acciojob.bookmyshow.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookTicketRequest {
    private String movieName;
    private Integer theaterId;
    private LocalDate showDate;
    private LocalTime showTime;
    private List<String> requestSeatNo;
    private Integer userId;
}