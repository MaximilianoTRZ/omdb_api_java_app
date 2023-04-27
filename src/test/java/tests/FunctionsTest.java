package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

import static helpers.Functions.SearchOne;
import static helpers.Functions.menu;
import static org.junit.jupiter.api.Assertions.*;



class FunctionsTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void showsCompleteInfoAboutAMovie() throws Exception {

        SearchOne("tt0371746","","" );
        String expResult = "Title: Iron Man\n" +
                "Year: 2008\n" +
                "Rated: PG-13\n" +
                "Released: 02 May 2008\n" +
                "Runtime: 126 min\n" +
                "Genre: Action, Adventure, Sci-Fi\n" +
                "Director: Jon Favreau\n" +
                "Writer: Mark Fergus, Hawk Ostby, Art Marcum\n" +
                "Actors: Robert Downey Jr., Gwyneth Paltrow, Terrence Howard\n" +
                "Plot: After being held captive in an Afghan cave, billionaire engineer Tony Stark creates a unique weaponized suit of armor to fight evil.\n" +
                "Language: English, Persian, Urdu, Arabic, Kurdish, Hindi, Hungarian\n" +
                "Country: United States, Canada\n" +
                "Awards: Nominated for 2 Oscars. 22 wins & 73 nominations total\n" +
                "Poster: https://m.media-amazon.com/images/M/MV5BMTczNTI2ODUwOF5BMl5BanBnXkFtZTcwMTU0NTIzMw@@._V1_SX300.jpg\n" +
                "Ratings: \n" +
                "Internet Movie Database\n" +
                "7.9/10\n" +
                "Rotten Tomatoes\n" +
                "94%\n" +
                "Metacritic\n" +
                "79/100\n" +
                "Metascore: 79\n" +
                "imdbRating: 7.9\n" +
                "imdbVotes: 1,074,372\n" +
                "imdbID: tt0371746\n" +
                "Type: movie\n" +
                "DVD: 30 Sep 2008\n" +
                "BoxOffice: $319,034,126\n" +
                "Production: N/A\n" +
                "Website: N/A";

        assertEquals( expResult , outputStreamCaptor.toString().trim());
    }

    @Test
    void menuShowsOptions() throws Exception {

        String expectedOutput =
                "-------------- MOVIE & SERIES MENU --------------\n" +
                "Enter the number of the option you want:\n" +
                "1. Search movie or series by name, type or year.\n"+
                "2. Search movie or series by name and year range.\n" +
                "No option selected.\n";

        String input = "0";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        menu();

        assertEquals(expectedOutput.toLowerCase(Locale.ROOT), outputStreamCaptor.toString().toLowerCase(Locale.ROOT));

    }

//    @Test
//    void searchMovies() {
//    }
//
//    @Test
//    void searchOne() {
//    }
//
//    @Test
//    void searchByRange() {
//    }

}