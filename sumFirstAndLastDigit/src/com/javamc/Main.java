package com.javamc;

public class Main {

    public static void main(String[] args) {

        System.out.println(sumFirstAndLastDigit(252));
        System.out.println(sumFirstAndLastDigit(257));
        System.out.println(sumFirstAndLastDigit(0));
        System.out.println(sumFirstAndLastDigit(5));
        System.out.println(sumFirstAndLastDigit(-1));
    }

    public static int sumFirstAndLastDigit (int number) {

        final int ERROR_INDICATOR_VALUE = -1;

        if (number < 0) {
            return ERROR_INDICATOR_VALUE;
        }

        int firstDigit;
        int lastDigit = number % 10;

        while (number >= 10) {
            number /= 10;
        }

        firstDigit = number;

        return firstDigit + lastDigit;
    }
}
