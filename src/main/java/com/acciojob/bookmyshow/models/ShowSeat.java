package com.acciojob.bookmyshow.models;

import com.acciojob.bookmyshow.enums.SeatType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "showSeatsTable")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showSeatId;
    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private Integer cost;
    private Boolean isAvailable;
    private Boolean isFoodAttached;
    @ManyToOne
    @JoinColumn
    private Show show;
}
