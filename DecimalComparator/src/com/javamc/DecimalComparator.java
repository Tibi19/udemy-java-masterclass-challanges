package com.javamc;

public class DecimalComparator {

    public static boolean areEqualByThreeDecimalPlaces (double x, double y) {

        int xConverted = (int) (x * 1000d); // (int) (statement) - casting after statement; (int) statement - casting before.
        int yConverted = (int) (y * 1000d);

        return xConverted == yConverted;  // or just use return ((int) (x * 1000d)) == ((int) (y * 1000d));
    }
}
