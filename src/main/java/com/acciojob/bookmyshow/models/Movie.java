package com.acciojob.bookmyshow.models;

import com.acciojob.bookmyshow.enums.Genre;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movieTable")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;
    @Column(unique = true)
    private String movieName;
    private Double rating;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    private LocalDate releaseDate;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Show> showList = new ArrayList<>();
}
