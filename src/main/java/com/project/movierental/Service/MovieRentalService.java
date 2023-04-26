package com.project.movierental.Service;

import com.project.movierental.Entity.MovieRental;
import com.project.movierental.Resource.MovieRentalResource;

import java.util.List;

public interface MovieRentalService {

    public List<MovieRentalResource> getAllMovieRentals();

    public MovieRentalResource getMovieRentalById(Long id);

    public MovieRentalResource createMovieRental(MovieRentalResource movieRentalResource);

    public MovieRentalResource updateMovieRentalById(MovieRentalResource movieRentalResource);

    public String deleteMovieRental(Long id);
}
