package com.project.movierental.Controller;

import com.project.movierental.Entity.Movie;
import com.project.movierental.Resource.MovieResource;
import com.project.movierental.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public List<MovieResource> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public MovieResource getMovieById(@PathVariable("id") Long id) {
        return movieService.getMoviesById(id);
    }

    @PostMapping(consumes = "application/json")
    public MovieResource createMovie(@RequestBody MovieResource movieResource) {
        return movieService.createMovie(movieResource);
    }

    @PutMapping("/update/{id}")
    public MovieResource updateMovie(@PathVariable("id") Long id, @RequestBody MovieResource movieResource) {
        return movieService.updateMovie(movieResource);
    }

    @DeleteMapping("delete/{id}")
    public String deleteMovie(@PathVariable("id") Long id) {
         movieService.deleteMovie(id);
         return "Movie deleted " +id;
    }

}
