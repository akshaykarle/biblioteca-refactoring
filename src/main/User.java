package main;

public class User {
    static String savedLibraryNumber = "";

    public static boolean validPassword(String password) {
        return "bhaisahab".equals(password);
    }

    public static boolean validLibraryNumber(String libraryNumber) {
        return libraryNumber.matches("\\d\\d\\d-\\d\\d\\d\\d");
    }
}
