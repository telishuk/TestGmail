package utils;

import java.util.Locale;
import java.util.Random;

public class RandomData {
    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String lower = upper.toLowerCase(Locale.ROOT);
    public static final String digits = "0123456789";
    public static final String alphanum = upper + lower + digits;


    public String getRandomString() throws NullPointerException {
        StringBuilder str = new StringBuilder();
        Random rnd = new Random();
        while (str.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * alphanum.length());
            str.append(alphanum.charAt(index));
        }
        return str.toString();
    }

    public String getRandomLongString() throws NullPointerException {
        StringBuilder str = new StringBuilder();
        Random rnd = new Random();
        while (str.length() < 130) { // length of the random string.
            int index = (int) (rnd.nextFloat() * alphanum.length());
            str.append(alphanum.charAt(index));
        }
        return str.toString();
    }

    public String getRandomInt() throws NullPointerException {
        StringBuilder str = new StringBuilder();
        Random rnd = new Random();
        while (str.length() < 9) { // length of the random string.
            int index = (int) (rnd.nextFloat() * digits.length());
            str.append(digits.charAt(index));
        }
        return str.toString();
    }

}
