package de.neuefische.backend.controller;

import de.neuefische.backend.model.Movie;
import de.neuefische.backend.model.MovieDTO;
import de.neuefische.backend.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable String id) {
        return movieService.getMovieById(id);
    }


    @PostMapping
    public Movie addMovie(@RequestBody MovieDTO newMovieDTO) {
        return movieService.addMovie(newMovieDTO);
    }

    @DeleteMapping("/{id}")
    public Movie deleteMovie(@PathVariable String id){
        return movieService.deleteMovie(id);
    }

}