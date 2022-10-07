package de.neuefische.backend.service;

import de.neuefische.backend.model.Movie;
import de.neuefische.backend.model.MovieDTO;
import de.neuefische.backend.repository.MovieRepo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class MovieServiceTest {

    private final MovieRepo movieRepo = mock(MovieRepo.class);
    private final IdService idService = mock(IdService.class);
    private final MovieService movieService = new MovieService(movieRepo, idService);


    @Test
    void getAllMovies() {
        //GIVEN
        when(movieRepo.findAll()).thenReturn(
                List.of(
                        new Movie("123", "Lord of the Rings - The two towers", "http://cdn.shopify.com/s/files/1/0037/8008/3782/products/lord_of_the_rings_the_two_towers_NG06275_B_2_framed1-423634.jpg?v=1611688137", "2002"),
                        new Movie("456", "Star Wars - The empire strikes back", "https://upload.wikimedia.org/wikipedia/en/3/3f/The_Empire_Strikes_Back_%281980_film%29.jpg", "1980")));

        //WHEN
        List<Movie> actual = movieService.getAllMovies();

        //THEN
        List<Movie> expected = List.of(
                new Movie("123", "Lord of the Rings - The two towers", "http://cdn.shopify.com/s/files/1/0037/8008/3782/products/lord_of_the_rings_the_two_towers_NG06275_B_2_framed1-423634.jpg?v=1611688137", "2002"),
                new Movie("456", "Star Wars - The empire strikes back", "https://upload.wikimedia.org/wikipedia/en/3/3f/The_Empire_Strikes_Back_%281980_film%29.jpg", "1980"));

        verify(movieRepo).findAll();
        assertEquals(expected, actual);
    }

 /*   @Test
    void getMovieById() {
        //GIVEN
        when(movieRepo.findById("123")).thenReturn(new Optional<Movie> ("123", "Mustermovie", "http://picture.de", "2000"));

        //WHEN
        Optional<Movie> actual = movieService.getMovieById("123");

        //THEN
        verify(movieRepo).findById("123");
    }*/

    @Test
    void addMovie() {
        //GIVEN
        MovieDTO movie1 = new MovieDTO("Lord of the Rings - The two towers", "http://cdn.shopify.com/s/files/1/0037/8008/3782/products/lord_of_the_rings_the_two_towers_NG06275_B_2_framed1-423634.jpg?v=1611688137", "2002");
        Movie expected = new Movie("123", "Lord of the Rings - The two towers", "http://cdn.shopify.com/s/files/1/0037/8008/3782/products/lord_of_the_rings_the_two_towers_NG06275_B_2_framed1-423634.jpg?v=1611688137", "2002");
        when(idService.generateID()).thenReturn("123");
        when(movieRepo.save(any())).thenReturn(
                Movie.builder()
                    .id("123")
                    .title(movie1.getTitle())
                    .posterURL(movie1.getPosterURL())
                    .year(movie1.getYear())
                   .build());

        //WHEN
        Movie actual = movieService.addMovie(movie1);

        //THEN
        assertEquals(expected, actual);
    }

/*    @Test
    void deleteMovie() {
        //GIVEN
        when(movieRepo.findById("123")).thenReturn(new Movie("123", "Mustermovie", "http://picture.de", "2000"));

        //WHEN
        movieService.deleteMovie("123");

        //THEN
        verify(movieRepo).deleteById("123");
    }*/
}