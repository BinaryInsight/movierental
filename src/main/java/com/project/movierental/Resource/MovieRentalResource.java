package com.project.movierental.Resource;

import com.project.movierental.Entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieRentalResource implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private int daysRented;
    private Movie movie;

}
