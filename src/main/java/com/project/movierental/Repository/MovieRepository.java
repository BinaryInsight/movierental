package com.project.movierental.Repository;

import com.project.movierental.Entity.Movie;
import com.project.movierental.Resource.MovieResource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
