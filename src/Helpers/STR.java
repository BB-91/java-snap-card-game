package Helpers;

public class STR {
    public static String titleWord(String word) {
        return word.toUpperCase().charAt(0) + word.toLowerCase().substring(1);
    }
}
