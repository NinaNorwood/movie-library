package de.neuefische.backend.controller;


import de.neuefische.backend.model.Movie;
import de.neuefische.backend.repository.MovieRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private MovieRepo movieRepo;


    @DirtiesContext
    @Test
    void getAllMovies() throws Exception {
        //GIVEN
        Movie movie1 = new Movie("456", "Star Wars - The empire strikes back", "https://upload.wikimedia.org/wikipedia/en/3/3f/The_Empire_Strikes_Back_%281980_film%29.jpg", "1980");
        movieRepo.save(movie1);

        //WHEN &THEN
        mockMvc.perform(get("/api/movie"))
                .andExpect(status().is(200))
                .andExpect(content().string("""
                        [{"id":"456","title":"Star Wars - The empire strikes back","posterURL":"https://upload.wikimedia.org/wikipedia/en/3/3f/The_Empire_Strikes_Back_%281980_film%29.jpg","year":"1980"}]"""));
    }

/*    @DirtiesContext
    @Test
    void addMovie() throws Exception {
        //GIVEN
        Movie movie1 = new Movie("456", "Star Wars - The empire strikes back", "https://upload.wikimedia.org/wikipedia/en/3/3f/The_Empire_Strikes_Back_%281980_film%29.jpg", "1980");
        movieRepo.save(movie1);

        //WHEN & THEN
        mockMvc.perform(
                        post("/api/movie/")
                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                                .content("""
                        {"title":"Star Wars - The empire strikes back","posterURL":"https://upload.wikimedia.org/wikipedia/en/3/3f/The_Empire_Strikes_Back_%281980_film%29.jpg","year":"1980"}
                        """))
                .andExpect(status().is(200))
                .andExpect(content().string("""
                        {"id":"456","title":"Star Wars - The empire strikes back","posterURL":"https://upload.wikimedia.org/wikipedia/en/3/3f/The_Empire_Strikes_Back_%281980_film%29.jpg","year":"1980"}"""));
    }*/
}
