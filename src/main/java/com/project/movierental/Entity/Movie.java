package com.project.movierental.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Movies and its types
 * @author Parasuram
 */

@Entity
@Table(name = "movie")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private Type type;
    @OneToOne(cascade = CascadeType.ALL)
//    @MapsId
    @JoinColumn(name = "movie_rentals_id", referencedColumnName = "id")  // renamed from "id" to "movie_rentals_id"
    private MovieRental movieRental;

    public Movie(String title, Type type, MovieRental movieRental) {
        this.title = title;
        this.type = type;
        this.movieRental = movieRental;
    }

}
