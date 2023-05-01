package com.project.movierental.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MovieRental contains the movies and the daysRented them
 *
 * @author Parasuram
 */

@Entity
@Table(name = "movie_rental")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieRental {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "days-rented")
    private int daysRented;

    @OneToOne(mappedBy = "movieRental", cascade = CascadeType.ALL)
    @JsonIgnore
//    @PrimaryKeyJoinColumn // (name = "movie_id", referencedColumnName = "id")
    private Movie movie;

    public MovieRental(int daysRented, Movie movie) {
        this.daysRented = daysRented;
        this.movie = movie;
    }

}
