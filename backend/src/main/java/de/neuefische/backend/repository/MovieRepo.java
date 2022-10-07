package de.neuefische.backend.repository;

import de.neuefische.backend.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface MovieRepo extends MongoRepository<Movie, String> {



   /* Map<String, Movie> movies = new HashMap<>();

    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies.values());
    }

    public Movie getMovieById(String id) {
        return movies.get(id);
    }

    public Movie addMovie(Movie newMovie) {
        movies.put(newMovie.getId(), newMovie);
        return newMovie;
    }


    public Movie deleteMovie(String id) {
        return movies.remove(id);
    }*/

}
