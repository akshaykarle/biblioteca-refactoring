package test;

import main.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.containsString;

public class BookCollectionTest {
    @Test
    public void show_the_books_available_for_rental() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        BookCollection.displayBooks();
        assertThat(outputStream.toString(), containsString("1. Sweet Valley High vol. 4 by John Travolta "));
        assertThat(outputStream.toString(), containsString("2. eXtreme Programming Explained by Kent Beck "));
        assertThat(outputStream.toString(), containsString("3. How to Win Friends and Influence People by Dale Carnagie "));
        assertThat(outputStream.toString(), containsString("4. How to Cheat at TWU Assignements by Anonymous "));
    }

}
