package com.acciojob.bookmyshow.services;

import com.acciojob.bookmyshow.dtos.AddShowRequest;
import com.acciojob.bookmyshow.dtos.AddShowSeatRequest;
import com.acciojob.bookmyshow.enums.SeatType;
import com.acciojob.bookmyshow.models.*;
import com.acciojob.bookmyshow.repositorys.MovieRepository;
import com.acciojob.bookmyshow.repositorys.ShowRepository;
import com.acciojob.bookmyshow.repositorys.ShowSeatRepository;
import com.acciojob.bookmyshow.repositorys.TheaterRepository;
import com.acciojob.bookmyshow.transformers.ShowTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TheaterRepository theaterRepository;
    public String addShow(AddShowRequest addShowRequest) {
        Show show = ShowTransformer.convertAddShowReqToShow(addShowRequest);
        Movie movie = movieRepository.findMovieByMovieName(addShowRequest.getMovieName());
        Optional<Theater> theaterOptional = theaterRepository.findById(addShowRequest.getTheaterId());
        Theater theater = theaterOptional.get();
        show.setMovie(movie);
        show.setTheater(theater);
        theater.getShowList().add(show);
        movie.getShowList().add(show);
        showRepository.save(show);
        return "show has been saved to db with showId" + show.getShowId();
    }
    public String enableShowSeats(AddShowSeatRequest addShowSeatRequest) {
        Optional<Show> showOptional = showRepository.findById(addShowSeatRequest.getShowId());
        Show show = showOptional.get();
        Theater theater = show.getTheater();
        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();
        List<ShowSeat> showSeatList = new ArrayList<>();
        for (TheaterSeat theaterSeat: theaterSeatList) {
            ShowSeat showSeat = ShowSeat.builder()
                    .seatType(theaterSeat.getSeatType())
                    .seatNo(theaterSeat.getSeatNo())
                    .isAvailable(true)
                    .isFoodAttached(false)
                    .show(show)
                    .build();
            if (theaterSeat.getSeatType().equals(SeatType.CLASSIC)) {
                showSeat.setCost(addShowSeatRequest.getPriceOfClassicSeat());
            } else {
                showSeat.setCost(addShowSeatRequest.getPriceOfPremiumSeat());
            }
            showSeatList.add(showSeat);
        }
        show.setShowSeatList(showSeatList);
        showSeatRepository.saveAll(showSeatList);
        return "the show seats have been added";
    }
}
