package com.javamc;

public class Main {

    public static void main(String[] args) {

        System.out.println(SumOddRange.sumOdd(1, 100));
        System.out.println(SumOddRange.sumOdd(-1, 100));
        System.out.println(SumOddRange.sumOdd(100, 100));
        System.out.println(SumOddRange.sumOdd(13, 13));
        System.out.println(SumOddRange.sumOdd(100, -100));
        System.out.println(SumOddRange.sumOdd(100, 1000));

    }
}

class SumOddRange {

    public static boolean isOdd (int number) {

        if (number <= 0) {
            return false;
        }

        return number % 2 == 1;
    }

    public static int sumOdd(int start, int end) {

        final int ERROR_INDICATOR_VALUE = -1;

        if (start <= 0 || end <= 0) {
            return ERROR_INDICATOR_VALUE;
        }

        if (end < start) {
            return ERROR_INDICATOR_VALUE;
        }

        int sum = 0;

        for (int i = start; i <= end; i++) {
            //sum += isOdd(i) ? i : 0;

            if (isOdd(i)) {
                sum += i;
            }
        }

        return sum;
    }
}
