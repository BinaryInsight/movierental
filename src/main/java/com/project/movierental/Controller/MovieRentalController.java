package com.project.movierental.Controller;

import com.project.movierental.Entity.Movie;
import com.project.movierental.Entity.MovieRental;
import com.project.movierental.Resource.MovieRentalResource;
import com.project.movierental.Resource.MovieResource;
import com.project.movierental.Service.MovieRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movierental")
public class MovieRentalController {

    @Autowired
    private MovieRentalService movieRentalService;

    @GetMapping("/allMovieRentals")
    public List<MovieRentalResource> getAllMovieRentals() {
        return movieRentalService.getAllMovieRentals();
    }

    @GetMapping("/{id}")
    public MovieRentalResource getMovieRentalById(@PathVariable("id") Long id) {
        return movieRentalService.getMovieRentalById(id);
    }

    @PostMapping(consumes = "application/json")
    public MovieRentalResource createMovieRental(@RequestBody MovieRentalResource movieRentalResource) {
        return movieRentalService.createMovieRental(movieRentalResource);
    }

    @PutMapping("/update/{id}")
    public MovieRentalResource updateMovieRentalById(@PathVariable("id") Long id, @RequestBody MovieRentalResource movieRentalResource) {
        return movieRentalService.updateMovieRentalById(movieRentalResource);
    }

    @DeleteMapping("delete/{id}")
    public String deleteMovieRental(@PathVariable("id") Long id) {
        movieRentalService.deleteMovieRental(id);
        return "MovieRental deleted " +id;
    }

}
