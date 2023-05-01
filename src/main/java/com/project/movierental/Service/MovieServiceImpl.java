package com.project.movierental.Service;

import com.project.movierental.Entity.Movie;
import com.project.movierental.Repository.MovieRepository;
import com.project.movierental.Resource.MovieResource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieResource> getAllMovies() {
        List<MovieResource> movieList = movieRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
        return movieList;
    }

    public MovieResource getMoviesById(Long id) {
        Movie movie = movieRepository.findById(id).orElseGet(null);
        return convertToDTO(movie);
    }

    public MovieResource createMovie(MovieResource movieResource) {
        Movie movie = convertToEntity(movieResource);
        movieRepository.save(movie);
        return convertToDTO(movie);
    }

    public MovieResource updateMovie(MovieResource movieResource) {
        Movie movie = movieRepository.findById(movieResource.getId()).orElseGet(null);
        BeanUtils.copyProperties(movieResource,movie);
        movieRepository.save(movie);
        return convertToDTO(movie);
    }

    public String deleteMovie(Long id) {
        movieRepository.deleteById(id);
        return "Movie deleted" +id;
    }

    private MovieResource convertToDTO(Movie movie) {
        MovieResource movieResource = new MovieResource();
        BeanUtils.copyProperties(movie,movieResource);
        return movieResource;
    }

    private Movie convertToEntity(MovieResource movieResource) {
        Movie movie = new Movie();
        BeanUtils.copyProperties(movieResource,movie);
        return movie;
    }

}
