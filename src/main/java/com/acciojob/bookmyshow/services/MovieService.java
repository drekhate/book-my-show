package com.acciojob.bookmyshow.services;

import com.acciojob.bookmyshow.dtos.AddMovieRequest;
import com.acciojob.bookmyshow.models.Movie;
import com.acciojob.bookmyshow.repositorys.MovieRepository;
import com.acciojob.bookmyshow.transformers.MovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public String addMovie(AddMovieRequest addMovieRequest) throws Exception {
        Movie movie = MovieTransformer.convertAddMovieReqToMovie(addMovieRequest);
        movieRepository.save(movie);
        return "movie has been added to the db succesfully";
    }
}
