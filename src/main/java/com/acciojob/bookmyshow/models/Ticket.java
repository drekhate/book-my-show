package com.acciojob.bookmyshow.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "ticketTable")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    private String theaterAddress;
    private String movieName;
    private Integer totalPrice;
    private String bookedSeats;
    private LocalDate showDate;
    private LocalTime showTime;
    @ManyToOne
    @JoinColumn
    private Show show;
    @ManyToOne
    @JoinColumn
    private User user;

}
