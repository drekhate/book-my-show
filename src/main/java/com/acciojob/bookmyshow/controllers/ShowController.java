package com.acciojob.bookmyshow.controllers;

import com.acciojob.bookmyshow.dtos.AddShowRequest;
import com.acciojob.bookmyshow.dtos.AddShowSeatRequest;
import com.acciojob.bookmyshow.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    private ShowService showService;
    @PostMapping("/addShow")
    public ResponseEntity addShow(@RequestBody AddShowRequest addShowRequest) {
        String result = showService.addShow(addShowRequest);
        return new ResponseEntity(result, HttpStatus.OK);
    }
    @PostMapping("/enableShowSeats")
    public ResponseEntity enableShowSeats(@RequestBody AddShowSeatRequest addShowSeatRequest) {
        String result = showService.enableShowSeats(addShowSeatRequest);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
