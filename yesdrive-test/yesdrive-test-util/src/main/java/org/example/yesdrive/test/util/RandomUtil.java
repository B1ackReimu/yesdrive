package org.example.yesdrive.test.util;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtil {

    private final static String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private final static String NUMBER = "1234567890";
    private final static String UPPER_CASE = LOWER_CASE.toUpperCase(Locale.ROOT);
    private final static String LETTER_NUMBER = NUMBER + LOWER_CASE + UPPER_CASE;
    private final static int LETTER_NUMBER_LENGTH = LETTER_NUMBER.length();

    public static String getRandomLetterNumber(int length) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < length; i++) {
            s.append(LETTER_NUMBER.charAt(ThreadLocalRandom.current().nextInt(LETTER_NUMBER_LENGTH)));
        }
        return String.valueOf(s);
    }

    public static int getRandomInt(int maxInt) {
        return ThreadLocalRandom.current().nextInt(maxInt);
    }

}
