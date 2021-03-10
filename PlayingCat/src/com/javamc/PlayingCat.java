package com.javamc;

public class PlayingCat {

    private static final int UPPER_TEMPERATURE_LIMIT_SUMMER = 45;
    private static final int UPPER_TEMPERATURE_LIMIT = 35;
    private static final int LOWER_TEMPERATURE_LIMIT = 25;

    public static boolean isCatPlaying (boolean summer, int temperature) {

        // We first check if temperature is lower than the lower limit.
        // If it is, then return false.
        // Otherwise, continue to check if it's inside the required range.
        if (temperature < LOWER_TEMPERATURE_LIMIT) {
            return false;
        }

        // If it is summer, check if temperature is lower or equal than the upper limit for summer.
        // After checking temperature, return the appropriate value.
        if (summer) {
            return temperature <= UPPER_TEMPERATURE_LIMIT_SUMMER;
        }

        // At this point, we know it is not summer.
        // Check if temperature is lower than the normal upper limit.
        // Return the appropriate value.
        return temperature <= UPPER_TEMPERATURE_LIMIT;

    }
}
