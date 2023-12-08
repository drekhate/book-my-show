package com.acciojob.bookmyshow.dtos;

import com.acciojob.bookmyshow.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddMovieRequest {
    private String movieName;
    private Double rating;
    private Genre genre;
    private LocalDate releaseDate;
}
