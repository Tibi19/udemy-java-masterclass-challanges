package com.javamc;

public class BarkingDog {

    public static boolean shouldWakeUp (boolean barking, int hourOfDay) {

        if (hourOfDay < 0 || hourOfDay > 23) {
            return false;
        }

        if (!barking) {
            return false;
        }

        if (hourOfDay < 8 || hourOfDay > 22) {
            return true;
        }

        return false;

        // !!! It's always better to use if else, even in this situation !!!
        // using only if conditions is more risky.
    }
}
