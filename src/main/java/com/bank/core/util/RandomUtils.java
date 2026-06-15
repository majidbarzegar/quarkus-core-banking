package com.bank.core.util;

import java.security.SecureRandom;

public class RandomUtils {
    private static final SecureRandom random = new SecureRandom();

    public static String generate13DigitNumber() {
        long timePart = System.currentTimeMillis() % 1_000_000_000L; // 9 digits
        int randomPart = random.nextInt(10_000); // 4 digits
        return String.format("%09d%04d", timePart, randomPart);
    }
}
