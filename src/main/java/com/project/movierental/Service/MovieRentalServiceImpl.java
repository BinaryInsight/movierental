package com.project.movierental.Service;

import com.project.movierental.Entity.Movie;
import com.project.movierental.Entity.MovieRental;
import com.project.movierental.Repository.MovieRentalRepository;
import com.project.movierental.Resource.MovieRentalResource;
import com.project.movierental.Resource.MovieResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieRentalServiceImpl implements MovieRentalService {

    @Autowired
    MovieRentalRepository movieRentalRepository;


    public List<MovieRentalResource> getAllMovieRentals() {
        List<MovieRentalResource> movieRentalList = movieRentalRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
        return movieRentalList;
    }

    public MovieRentalResource getMovieRentalById(Long id) {
        MovieRental movieRental = movieRentalRepository.findById(id).orElseGet(null);
        return convertToDTO(movieRental);
    }

    public MovieRentalResource createMovieRental(MovieRentalResource movieRentalResource) {
        MovieRental movieRental = convertToEntity(movieRentalResource);
        movieRentalRepository.save(movieRental);
        return convertToDTO(movieRental);
    }

    public MovieRentalResource updateMovieRentalById(MovieRentalResource movieRentalResource) {
        MovieRental movieRental = movieRentalRepository.findById(movieRentalResource.getId()).orElseGet(null);
        movieRental.setDaysRented(movieRentalResource.getDaysRented());
//        movieRental.setMovie(movieRentalResource.getMovie());
        movieRentalRepository.save(movieRental);
        return convertToDTO(movieRental);
    }

    public String deleteMovieRental(Long id) {
        movieRentalRepository.deleteById(id);
        return "MovieRental Deleted" +id;
    }


    private MovieRentalResource convertToDTO(MovieRental movieRental) {
        MovieRentalResource movieRentalResource = new MovieRentalResource();
        movieRentalResource.setDaysRented(movieRental.getDaysRented());
//        movieRentalResource.setMovie(movieRental.getMovie());
        return movieRentalResource;
    }

    private MovieRental convertToEntity(MovieRentalResource movieRentalResource) {
        MovieRental movieRental = new MovieRental();
        movieRental.setDaysRented(movieRentalResource.getDaysRented());
        return movieRental;
    }
}
