package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {
    public static boolean validateDate(String date) {
        String regexData = "^(0[1-9]|[12][0-9]|3[01])[-/_](0[1-9]|1[0-2])[-/_](\\d{4})$";
        Pattern pattern = Pattern.compile(regexData);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }
    public static boolean validadePages(int pages) {
        if(pages < 0) return false;
        else return pages <= 1000;
    }
    public static boolean validadeInput(String input){
        return Pattern.matches("^[1-9][0-9]*$", input) ;
    }

    public static String formatElapsedTime(long nanos) {
        if (nanos < 1_000) {
            return nanos + " ns";
        } else if (nanos < 1_000_000) {
            return String.format("%.3f µs", nanos / 1_000.0);
        } else if (nanos < 1_000_000_000) {
            return String.format("%.3f ms", nanos / 1_000_000.0);
        } else if (nanos < 60L * 1_000_000_000) {
            return String.format("%.3f s", nanos / 1_000_000_000.0);
        } else {
            return String.format("%.3f min", nanos / (60.0 * 1_000_000_000.0));
        }
    }
}
