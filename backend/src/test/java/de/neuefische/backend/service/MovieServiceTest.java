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
        when(movieRepo.getAllMovies()).thenReturn(
                List.of(
                        new Movie("123", "Lord of the Rings - The two towers", "http://cdn.shopify.com/s/files/1/0037/8008/3782/products/lord_of_the_rings_the_two_towers_NG06275_B_2_framed1-423634.jpg?v=1611688137", "2002"),
                        new Movie("456", "Star Wars - The empire strikes back", "https://upload.wikimedia.org/wikipedia/en/3/3f/The_Empire_Strikes_Back_%281980_film%29.jpg", "1980")));

        //WHEN
        List<Movie> actual = movieService.getAllMovies();

        //THEN
        List<Movie> expected = List.of(
                new Movie("123", "Lord of the Rings - The two towers", "http://cdn.shopify.com/s/files/1/0037/8008/3782/products/lord_of_the_rings_the_two_towers_NG06275_B_2_framed1-423634.jpg?v=1611688137", "2002"),
                new Movie("456", "Star Wars - The empire strikes back", "https://upload.wikimedia.org/wikipedia/en/3/3f/The_Empire_Strikes_Back_%281980_film%29.jpg", "1980"));

        verify(movieRepo).getAllMovies();
        assertEquals(expected, actual);

    }

    @Test
    void addMovie() {
        //GIVEN
        MovieDTO dummyMovie = new MovieDTO("Lord of the Rings - The two towers", "http://cdn.shopify.com/s/files/1/0037/8008/3782/products/lord_of_the_rings_the_two_towers_NG06275_B_2_framed1-423634.jpg?v=1611688137", "2002");
        Movie expected = new Movie("123", "Lord of the Rings - The two towers", "http://cdn.shopify.com/s/files/1/0037/8008/3782/products/lord_of_the_rings_the_two_towers_NG06275_B_2_framed1-423634.jpg?v=1611688137", "2002");
        when(idService.generateID()).thenReturn("123");
        when(movieRepo.addMovie(any())).thenReturn(
                Movie.builder()
                    .id("123")
                    .title(dummyMovie.getTitle())
                    .posterURL(dummyMovie.getPosterURL())
                    .year(dummyMovie.getYear())
                   .build());


        //WHEN
        Movie actual = movieService.addMovie(dummyMovie);

        //THEN
        assertEquals(expected, actual);
    }
}