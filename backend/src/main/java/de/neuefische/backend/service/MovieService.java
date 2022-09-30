package de.neuefische.backend.service;

import de.neuefische.backend.model.Movie;
import de.neuefische.backend.model.MovieDTO;
import de.neuefische.backend.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepo movieRepo;
    private final IdService idService;

    @Autowired
    public MovieService(MovieRepo movieRepo, IdService idService) {
        this.movieRepo = movieRepo;
        this.idService = idService;
    }

    public List<Movie> getAllMovies() {
        return movieRepo.getAllMovies();
    }

    public Movie getMovieById(String id) {
        return movieRepo.getMovieById(id);
    }

    public Movie addMovie(MovieDTO movie) {
        Movie newMovie = Movie.builder()
                .id(idService.generateID())
                .title(movie.getTitle())
                .posterURL(movie.getPosterURL())
                .year(movie.getYear())
                .build();

        return movieRepo.addMovie(newMovie);
    }

    public Movie deleteMovie(String id) {
            return movieRepo.deleteMovie(id);
    }
}
