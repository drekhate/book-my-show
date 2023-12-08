package com.acciojob.bookmyshow.transformers;

import com.acciojob.bookmyshow.dtos.AddMovieRequest;
import com.acciojob.bookmyshow.models.Movie;

public class MovieTransformer {
    public static Movie convertAddMovieReqToMovie(AddMovieRequest addMovieRequest) {
        Movie movie = Movie.builder()
                .movieName(addMovieRequest.getMovieName())
                .genre(addMovieRequest.getGenre())
                .releaseDate(addMovieRequest.getReleaseDate())
                .rating(addMovieRequest.getRating())
                .build();
        return movie;
    }
}
