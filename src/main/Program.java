package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
    private static boolean loggedIn = false;

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            BufferedReader reader = getReader();
            int i1 = 0;
            i1 = getUserInputNumber(reader, i1);
            if (selectOption(reader, i1)) break;
        }
    }

    private static BufferedReader getReader() {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        return new BufferedReader(inputStream);
    }

    private static int getUserInputNumber(BufferedReader reader, int i1) {
        try {
            String value = reader.readLine();
            i1 = Integer.parseInt(value);
        } catch (Exception e) {
            System.out.println("Enter a valid integer!!");
        }
        return i1;
    }

    private static String getUserInputString(BufferedReader reader) {
        String input = new String();
        try {
            input = reader.readLine();
        } catch (IOException e) {
            System.out.println("Enter a valid String!!");
        }
        return input;
    }

    private static boolean selectOption(BufferedReader reader, int i1) {
        if (i1 == 1) {
            BookCollection.displayBooks();
        } else if (i1 == 2) {
            checkOutBook(reader);
        } else if (i1 == 3) {
            displayLibraryNumber();
        } else if (i1 == 4) {
            displayMovies();
        } else if (i1 == 5) {
            performLogin(reader);
        } else if (i1 == 9) {
            System.out.println("Quitting...");
            return true;
        } else {
            System.out.println("\n");
            System.out.println("Enter a valid integer!!");
        }
        return false;
    }

    private static void performLogin(BufferedReader reader) {
        clearLogin();
        System.out.println("Enter your library number");
            String libraryNumber = getUserInputString(reader);
            if (User.validLibraryNumber(libraryNumber)) {
                System.out.println("Enter your Password: ");
                String password = getUserInputString(reader);
                if (User.validPassword(password)) {
                    loggedIn = true;
                    User.savedLibraryNumber = libraryNumber;
                }
                else
                    System.out.println("Enter a valid password!!");
            }
            else
            System.out.println("Enter a valid username!!");
    }

    private static void displayMovies() {
        System.out.println(createMovie("Rocky", "John G. Avildsen", "10"));
        System.out.println(createMovie("Rocky II", "John G. Avildsen", "9"));
        System.out.println(createMovie("Rocky III", "John G. Avildsen", "8"));
        System.out.println(createMovie("Rocky IV", "John G. Avildsen", "7"));
        System.out.println(createMovie("Rocky V", "John G. Avildsen", "8"));
        System.out.println(createMovie("Drainage", "Francisco Trindade", "N/A"));
        System.out.println(createMovie("The Shawshank Redemption", "Frank Darabont", "10"));
        System.out.println(createMovie("The Godfather", "Francis Ford Coppola", "7"));
        System.out.println(createMovie("Inception", "Frank Darabont", "10"));
        System.out.println(createMovie("Pulp Fiction", "Quentin Tarantino", "6"));
    }

    private static void displayLibraryNumber() {
        if (loggedIn()) {
            System.out.println("\n");
            System.out.println("Your library number is " + User.savedLibraryNumber);
        } else {

            System.out.println("\n");
            System.out.println("Please talk to Librarian. Thank you.");
        }
    }

    private static void checkOutBook(BufferedReader reader) {
        System.out.println(" Please enter the number of the book you wish to checkout: ");
        int i2 = 0;
        i2 = getUserInputNumber(reader, i2);
        BookCollection.reserveBook(i2);
    }

    private static void displayMenu() {
        System.out.println("**********************************************************");
        System.out.println("* Welcome to The Bangalore Public Library System - Biblioteca *");
        System.out.println("**********************************************************");
        System.out.println("*                Menu                                    *");
        System.out.println("*         =====================                          *");
        System.out.println("*         1. List Book Catalog                           *");
        System.out.println("*         2. Check out Book                              *");
        System.out.println("*         3. Check Library Number                        *");
        System.out.println("*         4. Movie Listing                               *");
        System.out.println("*         5. Login                                       *");
        System.out.println("*         9. Exit                                        *");
        System.out.println("**********************************************************");
        System.out.println("Your Selection: ");
    }

    private static boolean loggedIn() {
        return loggedIn;
    }


    private static void clearLogin() {
        loggedIn = false;
        User.savedLibraryNumber = "";
    }

    private static String createMovie(String movieTitle, String movieDirector, String movieRanking) {
        return movieTitle + " - Director: " + movieDirector + " Rating: " + movieRanking;
    }
}

