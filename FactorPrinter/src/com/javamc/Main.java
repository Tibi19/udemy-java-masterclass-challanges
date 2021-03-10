package com.javamc;

public class Main {

    public static void main(String[] args) {

        printFactors(6);
        printFactors(32);
        printFactors(10);
        printFactors(-1);

    }

    public static void printFactors (int number) {

        final String INVALID_VALUE_MESSAGE = "Invalid Value";

        if (number < 1) {
            System.out.println(INVALID_VALUE_MESSAGE);
        } else {
            String factors = "1 ";

            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    factors += (i + " ");
                }
            }

            if (number != 1) {
                factors += number;
            }
            System.out.println(factors);
        }
    }

}
