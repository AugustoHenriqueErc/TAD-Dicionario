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
}
