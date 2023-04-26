package com.project.movierental.Resource;

import com.project.movierental.Entity.MovieRental;
import com.project.movierental.Entity.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieResource implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private Type type;
    private MovieRental movieRental;


}
