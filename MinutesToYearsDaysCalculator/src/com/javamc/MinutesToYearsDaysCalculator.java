package com.javamc;

public class MinutesToYearsDaysCalculator {

    private static final long MINUTES_TO_HOURS = 60L;
    private static final long HOURS_TO_DAY = 24L;
    private static final long DAYS_TO_YEAR = 365L;
    private static final String INVALID_VALUE_MESSAGE = "Invalid Value";

    public static void printYearsAndDays (long minutes) {

        if (minutes < 0L) {
            System.out.println(INVALID_VALUE_MESSAGE);
        } else {
            long hours = minutes / MINUTES_TO_HOURS;
            long days = hours / HOURS_TO_DAY;
            long years = days / DAYS_TO_YEAR;

            days %= DAYS_TO_YEAR;

            System.out.println(minutes + " min = " + years + " y and " + days + " d");
        }

    }

}
