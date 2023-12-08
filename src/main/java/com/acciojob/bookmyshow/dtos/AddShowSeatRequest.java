package com.acciojob.bookmyshow.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddShowSeatRequest {
    private Integer showId;
    private Integer priceOfClassicSeat;
    private Integer priceOfPremiumSeat;
}
