package test;

import org.junit.Test;
import main.MovieCollection;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class MovieCollectionTest {
    @Test
    public void show_movie_listing() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        MovieCollection.displayMovies();

        assertThat(outputStream.toString(), containsString("The Shawshank Redemption - Director: Frank Darabont Rating: 10"));
        assertThat(outputStream.toString(), containsString("Drainage - Director: Francisco Trindade Rating: N/A"));
        assertThat(outputStream.toString(), containsString("Pulp Fiction - Director: Quentin Tarantino Rating: 6"));
    }
}
