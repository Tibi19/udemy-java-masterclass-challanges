package com.javamc;

public class Main {

    public static void main(String[] args) {

        System.out.println(getGreatestCommonDivisor(25, 15));
        System.out.println(getGreatestCommonDivisor(12, 30));
        System.out.println(getGreatestCommonDivisor(9, 18));
        System.out.println(getGreatestCommonDivisor(81, 153));
        System.out.println();
        System.out.println(getGreatestCommonDivisor(13, 17));
        System.out.println(getGreatestCommonDivisor(38, 38));
        System.out.println(getGreatestCommonDivisor(38, 19));

    }

    public static int getGreatestCommonDivisor (int first, int second) {

        final int ERROR_INDICATOR_VALUE = -1;

        if (first < 10 || second < 10) {
            return ERROR_INDICATOR_VALUE;
        }

        int biggerNumber = Math.max(first, second);
        int smallerNumber = Math.min(first, second);

        if (biggerNumber % smallerNumber == 0) {
            return smallerNumber;
        }

        int divisor = smallerNumber / 2;
        while (true) {
            if (biggerNumber % divisor == 0 && smallerNumber % divisor == 0) {
                return divisor;
            }
            divisor--;
        }

    }
}
