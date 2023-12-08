package com.acciojob.bookmyshow.dtos;

import com.acciojob.bookmyshow.enums.City;
import com.acciojob.bookmyshow.models.TheaterSeat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddTheaterRequest {
    private String theaterName;
    private String address;
    private City city;
    private Integer noOfClassicSeats;
    private Integer noOfPremiumSeats;
    private Integer noOfSeatsPerRow;
}
