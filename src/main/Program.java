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
            int option = 0;
            option = getUserInputNumber(reader, option);
            if (selectOption(reader, option)) break;
        }
    }

    private static BufferedReader getReader() {
        InputStreamReader inputStream = new InputStreamReader(System.in);
        return new BufferedReader(inputStream);
    }

    private static int getUserInputNumber(BufferedReader reader, int number) {
        try {
            String value = reader.readLine();
            number = Integer.parseInt(value);
        } catch (Exception e) {
            System.out.println("Enter a valid integer!!");
        }
        return number;
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

    private static boolean selectOption(BufferedReader reader, int option) {
        if (option == 1) {
            BookCollection.displayBooks();
        } else if (option == 2) {
            checkOutBook(reader);
        } else if (option == 3) {
            displayLibraryNumber();
        } else if (option == 4) {
            MovieCollection.displayMovies();
        } else if (option == 5) {
            performLogin(reader);
        } else if (option == 9) {
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
        int bookNumber = 0;
        bookNumber = getUserInputNumber(reader, bookNumber);
        BookCollection.reserveBook(bookNumber);
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
}

