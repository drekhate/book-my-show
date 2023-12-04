package com.acciojob.bookmyshow.services;

import com.acciojob.bookmyshow.dtos.AddTheaterRequest;
import com.acciojob.bookmyshow.enums.SeatType;
import com.acciojob.bookmyshow.models.Theater;
import com.acciojob.bookmyshow.models.TheaterSeat;
import com.acciojob.bookmyshow.repositorys.TheaterRepository;
import com.acciojob.bookmyshow.repositorys.TheaterSeatRepository;
import com.acciojob.bookmyshow.transformers.TheaterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private TheaterSeatRepository theaterSeatRepository;
    public String addTheater(AddTheaterRequest addTheaterRequest) {
        Theater theater = TheaterTransformer.convertAddTheaterReqToTheater(addTheaterRequest);
//        create the theater seats
        createTheaterSeats(theater, addTheaterRequest);
        return "theater and seats have been saved to DB";
    }
    public void createTheaterSeats(Theater theater, AddTheaterRequest addTheaterRequest) {
        int noOfClassicSeats = addTheaterRequest.getNoOfClassicSeats();
        int noOfPremiumSeats = addTheaterRequest.getNoOfPremiumSeats();
        int seatsPerRow = addTheaterRequest.getNoOfSeatsPerRow();
        List<TheaterSeat> theaterSeatList = new ArrayList<>();
        int row = 0;
        char ch = 'A';
        for (int i = 1; i <= noOfClassicSeats; i ++) {
            if(i % seatsPerRow == 1) {
                row ++;
                ch = 'A';
            }
            String seatNo = "" + row + ch;
            ch = (char) (ch + 1);
            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.CLASSIC)
                    .theater(theater)
                    .build();
            theaterSeatList.add(theaterSeat);
        }
        row = row + 1;
        ch = 'A';
        for (int i = 1; i <= noOfPremiumSeats; i ++) {
            if (i % seatsPerRow == 1) {
                row ++;
                ch = 'A';
            }
            String seatNo = "" + row + ch;
            ch = (char) (ch + 1);
            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.PREMIUM)
                    .theater(theater)
                    .build();
            theaterSeatList.add(theaterSeat);
        }
        theater.setTheaterSeatList(theaterSeatList);
        theaterRepository.save(theater);
    }
}
