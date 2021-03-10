package com.javamc;

public class Main {

    public static void main(String[] args) {

        boolean bool1 = EqualSumChecker.hasEqualSum(1, 1, 1);
        boolean bool2 = EqualSumChecker.hasEqualSum(1, 1, 2);
        boolean bool3 = EqualSumChecker.hasEqualSum(1, -1, 0);

        System.out.println(bool1);
        System.out.println(bool2);
        System.out.println(bool3);
    }
}
