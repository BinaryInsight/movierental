package com.project.movierental.Repository;

import com.project.movierental.Entity.MovieRental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRentalRepository extends JpaRepository<MovieRental, Long> {
}
