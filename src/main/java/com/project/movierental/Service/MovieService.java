package com.project.movierental.Service;

import com.project.movierental.Entity.Movie;
import com.project.movierental.Resource.MovieResource;
import java.util.List;

public interface MovieService {

    public List<MovieResource> getAllMovies();

    public MovieResource getMoviesById(Long id);

    public MovieResource createMovie(MovieResource movieResource);

    public MovieResource updateMovie(MovieResource movieResource);

    public String deleteMovie(Long id);



}
