package com.javamc;

public class Main {

    public static void main(String[] args) {

        System.out.println(getEvenDigitSum(123456789));
        System.out.println(getEvenDigitSum(252));
        System.out.println(getEvenDigitSum(-22));
    }

    public static int getEvenDigitSum (int number) {

        final int ERROR_INDICATOR_VALUE = -1;

        if (number < 0) {
            return ERROR_INDICATOR_VALUE;
        }

        int evenSum = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            if (lastDigit % 2 == 0) {
                evenSum += lastDigit;
            }
            number /= 10;
        }

        return evenSum;
    }
}
