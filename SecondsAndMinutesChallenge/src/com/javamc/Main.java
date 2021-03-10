package com.javamc;

public class Main {

    private static final String INVALID_VALUE_MESSAGE = "Invalid value";

    public static void main(String[] args) {
        String duration1 = getDurationString(1432);
        String duration2 = getDurationString(345, 52);
        String duration3 = getDurationString(99999);
        String duration4 = getDurationString(895, 82);
        String duration5 = getDurationString(61, 0);

        System.out.println(duration1);
        System.out.println(duration2);
        System.out.println(duration3);
        System.out.println(duration4);
        System.out.println(duration5);
    }

    private static String getDurationString (int minutes, int seconds) {

        if (minutes < 0) {
            return INVALID_VALUE_MESSAGE;
        }

        if (seconds < 0 || seconds > 59) {
            return INVALID_VALUE_MESSAGE;
        }

        int hours = minutes / 60;
        minutes %= 60;

        String hoursString = getDoubleDigitsTimeString(hours) + ":";
        String minutesString = getDoubleDigitsTimeString(minutes) + ":";
        String secondsString = getDoubleDigitsTimeString(seconds);

        return hoursString + minutesString + secondsString;
    }

    private static String getDurationString (int seconds) {

        if (seconds < 0) {
            return INVALID_VALUE_MESSAGE;
        }

        int minutes = seconds / 60;
        seconds %= 60;

        return getDurationString(minutes, seconds);
    }

    private static String getDoubleDigitsTimeString(int time) {

        if (time < 0) {
            return INVALID_VALUE_MESSAGE;
        }

        return time < 10 ? "0" + time : time + "";
    }
}
