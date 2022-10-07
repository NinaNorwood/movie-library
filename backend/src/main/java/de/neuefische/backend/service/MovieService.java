package de.neuefische.backend.service;

import de.neuefische.backend.model.Movie;
import de.neuefische.backend.model.MovieDTO;
import de.neuefische.backend.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return movieRepo.findAll();
    }

    public Optional<Movie> getMovieById(String id) {
        Optional<Movie> movie= movieRepo.findById(id);
        return movie;
    }

    public Movie addMovie(MovieDTO movie) {
        Movie newMovie = Movie.builder()
                .id(idService.generateID())
                .title(movie.getTitle())
                .posterURL(movie.getPosterURL())
                .year(movie.getYear())
                .build();

        return movieRepo.save(newMovie);
    }

    public void deleteMovie(String id) {
        movieRepo.deleteById(id);
    }
}
