package com.javamc;

public class Main {

    public static void main(String[] args) {

        System.out.println(sumDigits(125));
        System.out.println(sumDigits(6799));
        System.out.println(sumDigits(1));
        System.out.println(sumDigits(-12));
        System.out.println(sumDigits(83));

    }

    private static int sumDigits (int number) {

        final int ERROR_INDICATOR_VALUE = -1;

        if (number < 10) {
            return ERROR_INDICATOR_VALUE;
        }

        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
