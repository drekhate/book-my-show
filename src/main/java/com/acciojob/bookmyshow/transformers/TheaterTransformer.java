package com.acciojob.bookmyshow.transformers;

import com.acciojob.bookmyshow.dtos.AddTheaterRequest;
import com.acciojob.bookmyshow.models.Theater;

public class TheaterTransformer {
    public static Theater convertAddTheaterReqToTheater(AddTheaterRequest addTheaterRequest) {
        Theater theater = Theater.builder()
                .theaterName(addTheaterRequest.getTheaterName())
                .address(addTheaterRequest.getAddress())
                .city(addTheaterRequest.getCity())
                .build();
        return theater;
    }
}
