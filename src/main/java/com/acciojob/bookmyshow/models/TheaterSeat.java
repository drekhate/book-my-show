package com.acciojob.bookmyshow.models;

import com.acciojob.bookmyshow.enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "theaterSeats")
@Builder
@Getter
@Setter
public class TheaterSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer theaterSeatId;
    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    @ManyToOne
    @JoinColumn
    private Theater theater;
}
