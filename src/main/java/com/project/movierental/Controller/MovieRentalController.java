package com.project.movierental.Controller;

import com.project.movierental.Entity.Movie;
import com.project.movierental.Entity.MovieRental;
import com.project.movierental.Resource.MovieRentalResource;
import com.project.movierental.Resource.MovieResource;
import com.project.movierental.Service.MovieRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movierental")
public class MovieRentalController {

    @Autowired
    private MovieRentalService movieRentalService;

    @GetMapping("/allMovieRentals")
    public ResponseEntity<List<MovieRentalResource>> getAllMovieRentals() {
        return ResponseEntity.ok(movieRentalService.getAllMovieRentals());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieRentalResource> getMovieRentalById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(movieRentalService.getMovieRentalById(id));
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<MovieRentalResource> createMovieRental(@RequestBody MovieRentalResource movieRentalResource) {
        return ResponseEntity.ok(movieRentalService.createMovieRental(movieRentalResource));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MovieRentalResource> updateMovieRentalById(@PathVariable("id") Long id, @RequestBody MovieRentalResource movieRentalResource) {
        return ResponseEntity.ok(movieRentalService.updateMovieRentalById(movieRentalResource));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteMovieRental(@PathVariable("id") Long id) {
        return ResponseEntity.ok(movieRentalService.deleteMovieRental(id));
    }

}
