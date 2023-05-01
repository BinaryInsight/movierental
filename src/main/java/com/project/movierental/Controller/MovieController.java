package com.project.movierental.Controller;

import com.project.movierental.Entity.Movie;
import com.project.movierental.Resource.MovieResource;
import com.project.movierental.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<List<MovieResource>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResource> getMovieById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(movieService.getMoviesById(id));
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<MovieResource> createMovie(@RequestBody MovieResource movieResource) {
        return ResponseEntity.ok(movieService.createMovie(movieResource));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MovieResource> updateMovie(@PathVariable("id") Long id, @RequestBody MovieResource movieResource) {
        return ResponseEntity.ok(movieService.updateMovie(movieResource));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long id) {
         return ResponseEntity.ok(movieService.deleteMovie(id));
    }

}
