package com.acciojob.bookmyshow.services;

import com.acciojob.bookmyshow.dtos.BookTicketRequest;
import com.acciojob.bookmyshow.models.*;
import com.acciojob.bookmyshow.repositorys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TheaterRepository theaterRepository;
    public String bookTicket(BookTicketRequest bookTicketRequest) {
        Show show = findRightShow(bookTicketRequest);
        List<ShowSeat> showSeatList = show.getShowSeatList();
//        whatever are the booked seats mark them as not available in show seats
        Integer totalPrice = 0;
        for (ShowSeat showSeat: showSeatList) {
            if (bookTicketRequest.getRequestSeatNo().contains(showSeat.getSeatNo())) {
                showSeat.setIsAvailable(false);
//        calculate total price
                totalPrice += showSeat.getCost();
            }
        }
        Optional<User> userOptional = userRepository.findById(bookTicketRequest.getUserId());
        User user = userOptional.get();
        Ticket ticket = Ticket.builder()
                .movieName(show.getMovie().getMovieName())
                .showDate(bookTicketRequest.getShowDate())
                .showTime(bookTicketRequest.getShowTime())
                .theaterAddress(show.getTheater().getAddress())
                .bookedSeats(bookTicketRequest.getRequestSeatNo().toString())
                .totalPrice(totalPrice)
                .user(user)
                .show(show)
                .build();
        show.getTicketList().add(ticket);
        user.getTicketList().add(ticket);
        ticketRepository.save(ticket);
        return "ticket has been booked";
    }
    private Show findRightShow(BookTicketRequest bookTicketRequest) {
        Movie movie = movieRepository.findMovieByMovieName(bookTicketRequest.getMovieName());
        Optional<Theater> theaterOptional = theaterRepository.findById(bookTicketRequest.getTheaterId());
        Theater theater = theaterOptional.get();
        return showRepository.findShowByShowDateAndShowTimeAndMovieAndTheater(bookTicketRequest.getShowDate(), bookTicketRequest.getShowTime(), movie, theater);
    }
}
